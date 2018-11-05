package ami.cloudexample.users.mapper;

import ami.cloudexample.users.dto.UserDTO;
import ami.cloudexample.users.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mihai Alexandru
 * @date 25.10.2018
 */
@Component
public class UserMapper {

    public UserDTO toDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.firstName = user.getFirstName();
        userDTO.lastName = user.getLastName();
        userDTO.id = user.getId();
        return userDTO;
    }

    public List<UserDTO> toDtos(Iterable<User> users) {
        List<UserDTO> userDTOS = new ArrayList<>();
        users.forEach(u -> userDTOS.add(toDto(u)));
        return userDTOS;
    }

}
