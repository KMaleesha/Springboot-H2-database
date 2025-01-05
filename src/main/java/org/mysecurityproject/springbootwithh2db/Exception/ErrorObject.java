package org.mysecurityproject.springbootwithh2db.Exception;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorObject {
    private Integer errorCode;
    private String errorMessage;
    private Date timestamp;
}
