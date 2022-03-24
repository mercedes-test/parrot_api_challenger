package com.mx.api.parrot.challenger.service;


import com.mx.api.parrot.challenger.model.dto.response.ResponseDTO;
import com.mx.api.parrot.challenger.model.dto.response.GenericResponse;

public interface ResponseService {

    <T> GenericResponse buildResponse(ResponseDTO responseDTO) ;
}
