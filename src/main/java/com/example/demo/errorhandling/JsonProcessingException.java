//*        Functionality    */
/*
 *  Handle Json processing errors
 */

package com.example.demo.errorhandling;

public class JsonProcessingException extends RuntimeException {
    public JsonProcessingException(String message) {
        super(message);
    }

    public JsonProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}
