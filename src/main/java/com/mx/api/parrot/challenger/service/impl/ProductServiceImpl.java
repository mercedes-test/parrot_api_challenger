package com.mx.api.parrot.challenger.service.impl;

import com.mx.api.parrot.challenger.model.dto.request.ProductRequest;
import com.mx.api.parrot.challenger.model.entity.ProductEntity;
import com.mx.api.parrot.challenger.model.entity.ProductListEntity;
import com.mx.api.parrot.challenger.repository.ProductRepository;
import com.mx.api.parrot.challenger.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductEntity> createProduct(List<ProductRequest> products, ProductListEntity productListEntity) {
        List<ProductEntity> productsEntity =  new ArrayList<>();
        Map<String, ProductEntity> mapProducts = new HashMap<>();

        products.stream().forEach(p -> {
            ProductEntity productEntity = null;

           if(mapProducts.containsKey(p.getProductName())) {

                productEntity =  mapProducts.get(p.getProductName());

                BigInteger quantity = BigInteger.valueOf(p.getQuantity())
                        .add(BigInteger.valueOf(productEntity.getQuantity()));

                productEntity.setQuantity(quantity.intValue());

            }else{

                productEntity = ProductEntity.builder()
                        .name(p.getProductName())
                        .quantity(p.getQuantity())
                        .unitPrice(p.getUnitPrice())
                        .createdDate(new Date())
                        .productList(productListEntity)
                        .build();
            }
            mapProducts.put(p.getProductName(),productEntity);

        });

        saveProducts(mapProducts, productsEntity);

        return productsEntity;
    }


    private void saveProducts(Map<String, ProductEntity> mapProductEntity, List<ProductEntity> productsEntity){

        for (String keyItem : mapProductEntity.keySet().toArray(new String[mapProductEntity.keySet().size()])) {
            ProductEntity productEntity  = mapProductEntity.get(keyItem);
            productRepository.save(productEntity);
            productsEntity.add(productEntity);
        }
    }
}
