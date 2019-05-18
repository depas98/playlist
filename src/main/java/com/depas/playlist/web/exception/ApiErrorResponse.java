package com.depas.playlist.web.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;

@JsonPropertyOrder({"statusCode", "status", "message", "detail"})
public class ApiErrorResponse {
    private HttpStatus status;
    private String message;
    private Throwable rootCause;

    private ApiErrorResponse(ApiErrorResponseBuilder apiErrorResponseBuilder){
        this.status = apiErrorResponseBuilder.status;
        this.message = apiErrorResponseBuilder.message;
        this.rootCause = apiErrorResponseBuilder.rootCause;
    }

    // getter and setters
    public HttpStatus getStatus() {
        return status;
    }

    public int getStatusCode() {
        return status.value();
    }

    public String getMessage() {
        return message;
    }

    @JsonIgnore
    public Throwable getRootCause() {
        return rootCause;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName())
                .append(" [status=").append(status)
                .append(", message=").append(message)
                .append(", rootCause=").append(rootCause == null ? "" : rootCause.getLocalizedMessage())
                .append("]");
        return sb.toString();
    }

    //Builder
    public static final class ApiErrorResponseBuilder {
        private HttpStatus status;
        private String message;
        private Throwable rootCause;

        public ApiErrorResponseBuilder() {
        }

        public ApiErrorResponseBuilder status(HttpStatus status) {
            this.status = status;
            return this;
        }

        public ApiErrorResponseBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ApiErrorResponseBuilder rootCause(Throwable rootCause) {
            this.rootCause = rootCause;
            return this;
        }

        public ApiErrorResponse build() {
            ApiErrorResponse apiErrorResponse = new ApiErrorResponse(this);
            return apiErrorResponse;
        }
    }
}
