package ami.cloudexample.milk.rest;

import ami.cloudexample.milk.dto.BuyMilkDto;
import ami.cloudexample.milk.dto.MilkPurchaseDto;
import ami.cloudexample.milk.entity.MilkPurchase;
import ami.cloudexample.milk.mapper.UserMilkInfoMapper;
import ami.cloudexample.milk.repository.UsersMilkInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import static java.util.Date.from;

/**
 * @author Mihai Alexandru
 * @date 23.10.2018
 */
@RestController
@RequestMapping("/milk/users/{userId}")
public class MilkServiceRestController {

    private UsersMilkInfoRepository repository;

    private UserMilkInfoMapper mapper;

    @Autowired
    public MilkServiceRestController(UsersMilkInfoRepository repository, UserMilkInfoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @GetMapping
    public List<MilkPurchaseDto> getInfo(@PathVariable(name = "userId") Integer userId, @RequestParam("after") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant after) {
        return mapper.toDtos(repository.findByUserIdAndBuyDateIsAfter(userId, from(after)));
    }

    @PostMapping
    public MilkPurchaseDto buyMilk(@PathVariable(name = "userId") Integer userId, @RequestBody BuyMilkDto buyMilkDto) {
        MilkPurchase milkPurchase = new MilkPurchase();
        milkPurchase.setBuyDate(new Date());
        milkPurchase.setUserId(userId);
        milkPurchase.setQuantity(buyMilkDto.quantity);
        return mapper.toDto(repository.save(milkPurchase));
    }

    @DeleteMapping
    public void deleteLastPurchase(@PathVariable(name = "userId") Integer userId) {
        repository.deleteByUserId(userId);
    }

}
