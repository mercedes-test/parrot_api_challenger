package com.mx.api.parrot.challenger.service.impl;

import com.mx.api.parrot.challenger.exception.ApiParrotException;
import com.mx.api.parrot.challenger.model.dto.request.ProductReportRequest;
import com.mx.api.parrot.challenger.model.dto.response.ProductReportAgregationResponseDTO;
import com.mx.api.parrot.challenger.model.dto.response.ProductReportResponseDTO;
import com.mx.api.parrot.challenger.repository.ProductRepository;
import com.mx.api.parrot.challenger.service.ProductReportService;
import com.mx.api.parrot.challenger.util.ApiParrotUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductReportServiceImpl implements ProductReportService {

    private final ProductRepository productRepository;

    @Override
    public ProductReportResponseDTO getReportProducts( ProductReportRequest reportRequest) throws ApiParrotException {

        ProductReportResponseDTO productReportResponseDTO =  ProductReportResponseDTO.builder().build();

        final  List<ProductReportAgregationResponseDTO> productsEntity = productRepository.getProductsReport(ApiParrotUtil.formatDate(reportRequest.getStartDate()), ApiParrotUtil.formatDate(reportRequest.getEndDate()));

        productReportResponseDTO.setProducts(productsEntity);

        return productReportResponseDTO;
    }
}
