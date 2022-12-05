package com.bosonit.block7crudvalidation.exceptions;

import lombok.Data;
import java.util.Date;

@Data
public class CustomError {
    Date timestamp;
    int HttpCode;
    String mensaje;

}


