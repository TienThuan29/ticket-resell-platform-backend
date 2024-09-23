package swp391.userservice.dto.reponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Author: Nguyen Tien Thuan
 */
@Getter
@Setter
public class ApiResponse<T> extends ResponseEntity<ApiResponse.Payload<T>> {

    public ApiResponse(HttpStatus httpStatus, String message) {
        super(new Payload(message, httpStatus), HttpStatus.OK);
    }

    public ApiResponse(HttpStatus httpStatus, String message, T data) {
        super(new Payload(message, data, httpStatus), HttpStatus.OK);
    }

    @Getter
    public static class Payload<T> {
            @JsonProperty("httpStatus")
            private HttpStatus httpStatus;

            @JsonProperty("message")
            private String message;

            @JsonProperty("object")
            private T object;

            public Payload(String message, HttpStatus status) {
                this.message = message;
                this.httpStatus = status;
            }

            public Payload(String message, T object, HttpStatus status) {
                this.message = message;
                this.object = object;
                this.httpStatus = status;
            }
    }
}
