package com.mx.api.parrot.challenger.model.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.io.Serializable;

@Generated
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("product_name")
    private String productName;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("unit_price")
    private Double unitPrice;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("quantity")
    private Integer quantity;
}
