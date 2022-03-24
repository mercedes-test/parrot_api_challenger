package com.mx.api.parrot.challenger.service.impl;

import com.mx.api.parrot.challenger.exception.ApiParrotException;
import com.mx.api.parrot.challenger.exception.enums.ApiParrotExceptionEnum;
import com.mx.api.parrot.challenger.model.entity.ProductListEntity;
import com.mx.api.parrot.challenger.model.entity.UserEntity;
import com.mx.api.parrot.challenger.repository.ProductListRepository;
import com.mx.api.parrot.challenger.repository.UserRepository;
import com.mx.api.parrot.challenger.service.ProductListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductListServiceImpl implements ProductListService {

    private final ProductListRepository productListRepository;
    private final UserRepository userRepository;

    @Override
    public ProductListEntity createProductList(String username) throws ApiParrotException {

        final UserEntity userEntity = userRepository.findByUsername(username);

        Optional.ofNullable(userEntity).orElseThrow(() -> new ApiParrotException(ApiParrotExceptionEnum.API_USER_NO_FOUNT));

        ProductListEntity productListEntity = Optional.ofNullable(ProductListEntity.builder()
                .username(userEntity).build()).orElseThrow(() -> new ApiParrotException(ApiParrotExceptionEnum.API_LIST_NO_FOUNT));

        productListEntity =  Optional.ofNullable(productListRepository.save(productListEntity))
                .orElseThrow(() -> new ApiParrotException(ApiParrotExceptionEnum.API_LIST_NO_CREATE));


        return productListRepository.findProductListById(productListEntity.getId())
                .orElseThrow(() -> new ApiParrotException(ApiParrotExceptionEnum.API_LIST_PRODUCT_NO_FOUNT));
    }
}
