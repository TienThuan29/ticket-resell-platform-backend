package swp391.ticketservice.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
public class CategoryResponse {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;
}
