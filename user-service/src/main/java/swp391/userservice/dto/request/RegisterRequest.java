package swp391.userservice.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

/**
 * Author: Nguyen Tien Thuan
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    @JsonProperty("username")
    @Size(min = 6, max = 50, message = "Tên đăng nhập không hợp lệ")
    private String username;

    @JsonProperty("password")
    @Size(min = 6, max = 100, message = "Mật khẩu không hợp lệ")
    private String password;

    @JsonProperty("email")
    @NotBlank
    private String email;

    @JsonProperty("firstname")
    @NotBlank
    private String firstname;

    @JsonProperty("lastname")
    @NotBlank
    private String lastname;

}
