package ami.cloudexample.milk.repository;

import ami.cloudexample.milk.entity.MilkPurchase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author Mihai Alexandru
 * @date 23.10.2018
 */
@Repository
public interface UsersMilkInfoRepository extends CrudRepository<MilkPurchase, Integer> {

    void deleteByUserId(Integer userId);

    List<MilkPurchase> findByUserIdAndBuyDateIsAfter(Integer userId, Date after);
}
