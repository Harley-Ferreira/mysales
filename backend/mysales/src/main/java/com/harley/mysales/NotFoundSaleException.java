package com.harley.mysales;

public class NotFoundSaleException extends RuntimeException {
    public NotFoundSaleException(String message) {
        super(message);
    }
}
