package swp391.userservice.configuration;

import org.springframework.stereotype.Component;

/**
 * Author: Nguyen Tien Thuan
 */
@Component
public class MessageConfiguration {

    public final String ERROR_USERNAME_EXIST = "Tên đăng nhập đã tồn tại!";
    public final String ERROR_REGISTER_FAIL = "Đăng ký không thành công!";
    public final String ERROR_REGISTER_SUCCESS = "Đăng ký thành công!";
    public final String ERROR_NOT_FOUND_USERID = "Không thể tìm thấy người dùng";
    public final String MESSAGE_UPDATE_USER_SUCCESS = "Cập nhật thông tin thành công";

}
