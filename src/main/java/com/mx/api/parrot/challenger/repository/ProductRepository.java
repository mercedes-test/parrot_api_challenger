package com.mx.api.parrot.challenger.repository;

import com.mx.api.parrot.challenger.model.dto.response.ProductReportAgregationResponseDTO;
import com.mx.api.parrot.challenger.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

   @Query ("select new com.mx.api.parrot.challenger.model.dto.response.ProductReportAgregationResponseDTO(p.name, sum(p.quantity),sum(p.unitPrice * p.quantity))" + "from  ProductEntity as p, ProductListEntity as pl" +
            " where p.createdDate between ?1 and ?2  and  p.productList.username =  pl.username  group by p.name, p.quantity, pl.username order by  pl.username, p.quantity desc ")
    List<ProductReportAgregationResponseDTO> getProductsReport(@Param("startDate") Date startDate, @Param("endDate") Date endDate);


    @Query("select sum(p.unitPrice * p.quantity)  from ProductEntity as p where p.productList.id = ?1")
    Optional<Double> getTotalPriceByProduct(@Param("idProductList") Integer productListId);

}

