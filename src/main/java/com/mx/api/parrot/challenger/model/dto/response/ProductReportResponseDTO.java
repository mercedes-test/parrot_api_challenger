package com.mx.api.parrot.challenger.model.dto.response;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class ProductReportResponseDTO implements ResponseDTO {

    private List<ProductReportAgregationResponseDTO> products;
}
