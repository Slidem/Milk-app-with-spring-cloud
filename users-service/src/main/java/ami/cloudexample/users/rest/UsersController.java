package ami.cloudexample.users.rest;

import ami.cloudexample.users.dto.UserDTO;
import ami.cloudexample.users.mapper.UserMapper;
import ami.cloudexample.users.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Mihai Alexandru
 * @date 25.10.2018
 */
@RestController
@RequestMapping("/users")
public class UsersController {

    private UserMapper userMapper;

    private UsersRepository usersRepository;

    @Autowired
    public UsersController(UserMapper userMapper, UsersRepository usersRepository) {
        this.userMapper = userMapper;
        this.usersRepository = usersRepository;
    }

    @GetMapping
    public List<UserDTO> users() {
        return userMapper.toDtos(usersRepository.findAll());
    }

}
