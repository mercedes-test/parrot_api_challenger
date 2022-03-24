package com.mx.api.parrot.challenger.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ProductReportRequest implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @JsonProperty("start_date")
    private String startDate;
    @JsonProperty("end_date")
    private String endDate;
}
