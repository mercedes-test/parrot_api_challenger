package com.mx.api.parrot.challenger.controller;

import com.mx.api.parrot.challenger.constant.CodesHttp;
import com.mx.api.parrot.challenger.exception.ApiParrotException;
import com.mx.api.parrot.challenger.model.dto.request.OrderRequest;
import com.mx.api.parrot.challenger.model.dto.response.OrderResponseDTO;
import com.mx.api.parrot.challenger.model.dto.response.ResponseDTO;
import com.mx.api.parrot.challenger.service.OrderService;
import com.mx.api.parrot.challenger.service.ResponseService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final ResponseService responseService;
    private final OrderService orderService;


    @ApiOperation(notes = "Add Order", value = "creating a new order", response = OrderController.class)
    @ApiResponses(value = {
            @ApiResponse(code = CodesHttp.CODIGO_SUCCESS, message = CodesHttp.RESPUESTA_SUCCESS, response = OrderController.class),
            @ApiResponse(code = CodesHttp.CODIGO_UNAUTHORIZED, message = CodesHttp.RESPUESTA_UNAUTHORIZED),
            @ApiResponse(code = CodesHttp.CODIGO_FORBIDDEN, message = CodesHttp.RESPUESTA_FORBIDDEN),
            @ApiResponse(code = CodesHttp.CODIGO_NOT_FOUND, message = CodesHttp.RESPUESTA_NOT_FOUND),
            @ApiResponse(code = CodesHttp.CODIGO_FAILURE, message = CodesHttp.RESPUESTA_FAILURE) })
    @PostMapping("/order")
    public ResponseEntity<ResponseDTO> addOrder(@RequestBody OrderRequest orderRequest, Authentication authentication) throws ApiParrotException {
        OrderResponseDTO orderResponseDTO = null;

        if(Objects.isNull(authentication)){
            return new ResponseEntity<>(responseService.buildResponse(null), HttpStatus.NOT_FOUND);
        }

        orderResponseDTO = orderService.addOrder(orderRequest, authentication.getName());

        return new ResponseEntity<>(responseService.buildResponse(orderResponseDTO), OK);
    }
}
