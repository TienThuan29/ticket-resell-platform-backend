package swp391.ticketservice.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.http.HttpStatus;

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

    @JsonProperty("data")
    private T object;

}
