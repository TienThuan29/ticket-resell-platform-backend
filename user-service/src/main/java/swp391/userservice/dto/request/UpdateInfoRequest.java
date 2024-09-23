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

    @NotEmpty(message = "Tên không được để trống")
    @JsonProperty("firstname")
    private String firstname;

    @NotEmpty(message = "Tên không được để trống")
    @JsonProperty("lastname")
    private String lastname;

    @NotEmpty(message = "Email không được để trống")
    @JsonProperty("email")
    private String email;

    @NotEmpty(message = "Số điện thoại không được để trống")
    @JsonProperty("phone")
    private String phone;

}
