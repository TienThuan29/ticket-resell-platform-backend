package swp391.userservice.exception.def;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Author: Nguyen Tien Thuan
 */
@Getter
@AllArgsConstructor
public class ErrorResponse {

    @JsonProperty("httpStatus")
    private HttpStatus httpStatus;

    @JsonProperty("message")
    private String message;

}
