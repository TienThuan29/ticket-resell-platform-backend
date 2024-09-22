package swp391.userservice.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateInfoRequest {

    @NotBlank
    @JsonProperty("firstname")
    private String firstname;

    @NotBlank
    @JsonProperty("lastname")
    private String lastname;

    @NotBlank
    @JsonProperty("email")
    private String email;

    @NotBlank
    @JsonProperty("phone")
    private String phone;

}
