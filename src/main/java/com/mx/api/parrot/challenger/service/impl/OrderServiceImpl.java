package com.mx.api.parrot.challenger.service.impl;

import com.mx.api.parrot.challenger.exception.ApiParrotException;
import com.mx.api.parrot.challenger.exception.enums.ApiParrotExceptionEnum;
import com.mx.api.parrot.challenger.model.dto.request.OrderRequest;
import com.mx.api.parrot.challenger.model.dto.response.OrderResponseDTO;
import com.mx.api.parrot.challenger.model.dto.response.ProductResponseDTO;
import com.mx.api.parrot.challenger.model.entity.OrderEntity;
import com.mx.api.parrot.challenger.model.entity.ProductEntity;
import com.mx.api.parrot.challenger.model.entity.ProductListEntity;
import com.mx.api.parrot.challenger.repository.OrderRepository;
import com.mx.api.parrot.challenger.repository.ProductRepository;
import com.mx.api.parrot.challenger.service.OrderService;
import com.mx.api.parrot.challenger.service.ProductListService;
import com.mx.api.parrot.challenger.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductListService productListService;
    private final ProductService productService;
    private final ProductRepository productRepository;

    @Override
    public OrderResponseDTO addOrder(OrderRequest ordeRequest, String username) throws ApiParrotException {

        BigDecimal totalPrice = new BigDecimal(0.0);

        final ProductListEntity productListEntity = productListService.createProductList(username);

        final List<ProductEntity> productsEntity = productService.createProduct(ordeRequest.getProducts(),productListEntity);

        totalPrice = totalPrice.add(BigDecimal.valueOf(productRepository.getTotalPriceByProduct(productListEntity.getId())
                .orElseThrow(() -> new ApiParrotException(ApiParrotExceptionEnum.API_LIST_PRODUCT_NO_FOUNT))));


        OrderEntity orderEntity =  OrderEntity.builder()
                .productList(productListEntity)
                .createdDate(new Date())
                .nameClient(ordeRequest.getNameClient())
                .totalPrice(totalPrice.doubleValue())
                .build();

        orderEntity = Optional.ofNullable(orderRepository.save(orderEntity))
                .orElseThrow(() ->new ApiParrotException(ApiParrotExceptionEnum.API_ORDER_NO_CREATE));

        OrderResponseDTO  orderResponseDTO = OrderResponseDTO.builder()
                .orderNumber(orderEntity.getId())
                .totalPrice(totalPrice.doubleValue())
                .nameClient(orderEntity.getNameClient())
                .products(getProducts(productsEntity))
                .build();

        return orderResponseDTO;
    }

    private List<ProductResponseDTO> getProducts(List<ProductEntity> productsEntity){
        List<ProductResponseDTO> products = new ArrayList<>();

        productsEntity.stream().forEach(p ->{
            products.add(ProductResponseDTO.builder()
                    .nameProduct(p.getName())
                    .quantity(p.getQuantity())
                    .unitPrice(p.getUnitPrice())
                    .build());
        });

        return products;
    }
}
