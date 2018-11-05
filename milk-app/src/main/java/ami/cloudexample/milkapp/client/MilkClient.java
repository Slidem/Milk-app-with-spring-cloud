package ami.cloudexample.milkapp.client;

import ami.cloudexample.milkapp.client.dto.BuyMilkDto;
import ami.cloudexample.milkapp.client.dto.MilkPurchaseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

/**
 * @author Mihai Alexandru
 * @date 29.10.2018
 */
@FeignClient(name = "milk-service")
public interface MilkClient {

    @GetMapping("/milk-service/milk/users/{userId}")
    List<MilkPurchaseDto> getPurchases(@PathVariable("userId") Integer userId, @RequestParam("after") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant after);

    @PostMapping("/milk-service/milk/users/{userId}")
    MilkPurchaseDto buyMilk(@PathVariable("userId") Integer userId, @RequestBody BuyMilkDto buyMilkDto);

    @DeleteMapping("/milk-service/milk/users/{userId}")
    void deleteLastPurchase(@PathVariable("userId") Integer userId);

}

