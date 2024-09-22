package swp391.userservice.dto.reponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.http.HttpStatus;

/**
 * Author: Nguyen Tien Thuan
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {

    @JsonProperty("httpStatus")
    private HttpStatus httpStatus;

    @JsonProperty("message")
    private String message;

    @JsonProperty("object")
    private T object;

}
