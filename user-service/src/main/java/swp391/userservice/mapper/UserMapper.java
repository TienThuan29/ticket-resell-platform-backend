package swp391.userservice.mapper;

import org.springframework.stereotype.Component;
import swp391.entity.User;
import swp391.userservice.dto.reponse.UserDTO;

@Component
public class UserMapper {

    public UserDTO toUserDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .avatar(user.getAvatar())
                .email(user.getEmail())
                .isEnable(user.getIsEnable())
                .roleCode(user.getRoleCode())
                .balance(user.getBalance())
                .revenue(user.getRevenue())
                .customerCode(user.getCustomerCode())
                .isSeller(user.getIsSeller())
                .build();
    }

}
