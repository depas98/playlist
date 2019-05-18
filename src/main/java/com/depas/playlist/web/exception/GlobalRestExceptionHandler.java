package com.depas.playlist.web.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalRestExceptionHandler extends ResponseEntityExceptionHandler {

//    private static final Logger logger = LoggerFactory.getLogger(GlobalRestExceptionHandler.class);
    private final Log logger = LogFactory.getLog(this.getClass());

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> defaultExceptionHandler(final Exception ex) {
        return buildRestResponse(ex, HttpStatus.BAD_REQUEST, MessageServerity.ERROR);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleGenericApiException(final RecordNotFoundException ex, WebRequest request) {
        return buildRestResponse(ex, HttpStatus.NOT_FOUND, MessageServerity.INFO);
    }

    private ResponseEntity<ApiErrorResponse> buildRestResponse(final Exception ex,
                                                               final HttpStatus status,
                                                               final MessageServerity serverity) {
        final ApiErrorResponse response = new ApiErrorResponse.ApiErrorResponseBuilder()
                .status(status)
                .message(ex.getLocalizedMessage())
                .rootCause(ex.getCause())
                .build();

        // TODO log error
        logResponse(response, ex, serverity);

        return new ResponseEntity<>(response, response.getStatus());
    }

    private <T> void logResponse(final ApiErrorResponse response,
                                 final Exception ex,
                                 final MessageServerity serverity) {
        Throwable rootCause = ex.getCause() == null ? ex : ex.getCause();
        switch (serverity) {
            case ERROR:
                logger.error(response, rootCause);
                break;
            case WARNING:
                logger.warn(response, rootCause);
                break;
            case INFO:
                logger.info(response);
                break;
            default:
                logger.error("Missing error handling for added message severity!");
                logger.error(response, rootCause);
                break;
        }
    }

}
