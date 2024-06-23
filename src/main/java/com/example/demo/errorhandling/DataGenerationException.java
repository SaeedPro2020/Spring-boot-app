//*        Functionality    */
/*
 *  Handle data generation error
 */

package com.example.demo.errorhandling;

public class DataGenerationException extends RuntimeException {
    public DataGenerationException(String message) {
        super(message);
    }

    public DataGenerationException(String message, Throwable cause) {
        super(message, cause);
    }
}
