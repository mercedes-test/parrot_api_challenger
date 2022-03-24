package com.mx.api.parrot.challenger.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class ProductEntity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "product_name",  nullable = false)
    private String name;
    @Column(name = "unit_price",  nullable = false)
    private Double unitPrice;
    @Column(name = "quantity",  nullable = false)
    private Integer quantity;
    @Temporal(TemporalType.TIMESTAMP)
    @JoinColumn(name = "created_date")
    private Date createdDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_product_list")
    private ProductListEntity productList;
}
