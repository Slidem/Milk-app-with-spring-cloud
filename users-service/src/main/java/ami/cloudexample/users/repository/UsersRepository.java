package ami.cloudexample.users.repository;

import ami.cloudexample.users.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Mihai Alexandru
 * @date 25.10.2018
 */
@Repository
public interface UsersRepository extends CrudRepository<User, Integer> {

}
