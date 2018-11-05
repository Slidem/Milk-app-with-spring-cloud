package ami.cloudexample.milkapp.client;

import ami.cloudexample.milkapp.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author Mihai Alexandru
 * @date 29.10.2018
 */
@FeignClient(name = "users-service")
public interface UsersClient {

    @GetMapping("/users-service/users")
    public List<UserDto> getUsers();

}
