package com.mx.api.parrot.challenger.controller;

import com.mx.api.parrot.challenger.constant.CodesHttp;
import com.mx.api.parrot.challenger.exception.ApiParrotException;
import com.mx.api.parrot.challenger.model.dto.request.ProductReportRequest;
import com.mx.api.parrot.challenger.model.dto.response.ProductReportResponseDTO;
import com.mx.api.parrot.challenger.model.dto.response.ResponseDTO;
import com.mx.api.parrot.challenger.service.ProductReportService;
import com.mx.api.parrot.challenger.service.ResponseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/report")
@CrossOrigin("*")
@RequiredArgsConstructor
@Validated
@Slf4j
public class ProductReportController {

    private final ResponseService responseService;
    private final ProductReportService productReportService;

    @ApiOperation(notes = "Get Report", value = "Obtiene un Reoporte de productos vendidos orden", response = ProductReportController.class)
    @ApiResponses(value = {
            @ApiResponse(code = CodesHttp.CODIGO_SUCCESS, message = CodesHttp.RESPUESTA_SUCCESS, response = ProductReportController.class),
            @ApiResponse(code = CodesHttp.CODIGO_UNAUTHORIZED, message = CodesHttp.RESPUESTA_UNAUTHORIZED),
            @ApiResponse(code = CodesHttp.CODIGO_FORBIDDEN, message = CodesHttp.RESPUESTA_FORBIDDEN),
            @ApiResponse(code = CodesHttp.CODIGO_NOT_FOUND, message = CodesHttp.RESPUESTA_NOT_FOUND),
            @ApiResponse(code = CodesHttp.CODIGO_FAILURE, message = CodesHttp.RESPUESTA_FAILURE) })
    @PostMapping("/order")
    public ResponseEntity<ResponseDTO> reportOrderByProducts(@RequestBody  ProductReportRequest reportRequest) throws ApiParrotException {

        ProductReportResponseDTO productReportResponseDTO = productReportService.getReportProducts(reportRequest);

        return new ResponseEntity<>(responseService.buildResponse(productReportResponseDTO), OK);
    }

}
