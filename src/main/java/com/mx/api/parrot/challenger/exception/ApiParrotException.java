package com.mx.api.parrot.challenger.exception;

import com.mx.api.parrot.challenger.exception.enums.ApiParrotExceptionEnum;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiParrotException extends Exception {

   
    /**
	 * 
	 */
	private static final long serialVersionUID = -4249486972820566527L;
	
	private HttpStatus status;
    private String message;
    private String code;

    public ApiParrotException(Throwable cause) {
        super(cause);
    }

    public ApiParrotException(String message) {
        super(message);
    }
    
    public ApiParrotException(ApiParrotExceptionEnum message) {
    	   super(message.getErrorMessage());
           this.message = message.getErrorMessage();
           this.status = message.getCategory();
           this.code = message.getCode();
    }

    public ApiParrotException(String message, HttpStatus status) {
        super(message);
        this.message = message;
        this.status = status;
    }
}
