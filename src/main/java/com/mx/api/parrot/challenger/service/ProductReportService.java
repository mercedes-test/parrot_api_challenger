package com.mx.api.parrot.challenger.service;

import com.mx.api.parrot.challenger.exception.ApiParrotException;
import com.mx.api.parrot.challenger.model.dto.request.ProductReportRequest;
import com.mx.api.parrot.challenger.model.dto.response.ProductReportResponseDTO;

public interface ProductReportService {

    ProductReportResponseDTO getReportProducts( ProductReportRequest reportRequest) throws ApiParrotException;
}
