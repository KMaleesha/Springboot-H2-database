package org.mysecurityproject.springbootwithh2db.Exception;

public class CustomerNotFoundException extends  RuntimeException {
    private static final long serialVersionUID = 1;

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
