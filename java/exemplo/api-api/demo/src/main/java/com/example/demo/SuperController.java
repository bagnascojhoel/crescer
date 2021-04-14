package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class SuperController {

    @ExceptionHandler()
    public ResponseEntity<ErrorResponse> errosGenericos(Exception e){
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(ErrorResponse.builder().message("Erro desconhecido").build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler()
    public ResponseEntity<ErrorResponse> errosDeRequisicao(FeignException e) throws JsonProcessingException {
        log.error(e.getMessage(), e);
        String message = e.getMessage();

        String[] arrayMessage = message.split("]:");
        ErrorResponse[] errorResponse = new ObjectMapper().readValue(arrayMessage[1], ErrorResponse[].class);

        return new ResponseEntity<>(
              errorResponse[0], HttpStatus.BAD_REQUEST);
    }


}
