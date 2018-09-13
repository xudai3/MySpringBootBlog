package com.xd.myspringbootblog.exception;

import com.xd.myspringbootblog.response.Response;
import com.xd.myspringbootblog.response.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    Response handleException(Exception e){
        logger.error(e.getMessage(), e);

        Response resp = new Response();
        return resp.failure(StatusCode.DATA_NOT_FOUND);
    }

    @ExceptionHandler(BusinessException.class)
    Response handleBusinessException(BusinessException e){
        logger.error(e.getMessage(), e);

        Response resp = new Response();
        return resp.failure(StatusCode.BUSINESS_ERROR, e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    Response handleIllegalParamException(MethodArgumentNotValidException e){
        List<ObjectError> errors = e.getBindingResult().getAllErrors();

        String errorMessage = "Param Not valid";

        if(errors.size() > 0){
            errorMessage = errors.get(0).getDefaultMessage();
        }

        logger.error(errorMessage, e);

        Response resp = new Response();

        return resp.failure(StatusCode.PARAM_IS_INVALID, errorMessage);
    }
}
