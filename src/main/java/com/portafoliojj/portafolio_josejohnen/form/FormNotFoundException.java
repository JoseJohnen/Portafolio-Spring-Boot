package com.portafoliojj.portafolio_josejohnen.form;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FormNotFoundException extends RuntimeException
{
    public FormNotFoundException()
    {
        super("Form Not Found");
    }
}
