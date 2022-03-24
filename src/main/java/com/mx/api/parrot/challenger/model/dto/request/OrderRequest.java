package com.mx.api.parrot.challenger.model.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Generated
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderRequest implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("products")
    private List<ProductRequest> products;

    @JsonProperty("name_client")
    private String nameClient;
}
