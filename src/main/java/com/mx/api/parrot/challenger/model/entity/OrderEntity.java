package com.mx.api.parrot.challenger.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class OrderEntity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;
    @JoinColumn(name = "name_client")
    private String nameClient;
    @JoinColumn(name = "total_price")
    private Double totalPrice;
    @JoinColumn(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_product_list")
    private ProductListEntity productList;
}
