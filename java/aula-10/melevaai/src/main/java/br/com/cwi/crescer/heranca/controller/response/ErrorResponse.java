package br.com.cwi.crescer.heranca.controller.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Builder
public class ErrorResponse {

    private String message;
    private int status;
}