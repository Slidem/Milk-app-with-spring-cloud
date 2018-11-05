package ami.cloudexample.milkapp.controller;

import ami.cloudexample.milkapp.dto.BuyMilkRequestDto;
import ami.cloudexample.milkapp.dto.UserMilkPurchaseDto;
import ami.cloudexample.milkapp.mapper.UserMilkPurchaseMapper;
import ami.cloudexample.milkapp.objects.UserMilkPurchase;
import ami.cloudexample.milkapp.service.MilkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Mihai Alexandru
 * @date 03.11.2018
 */
@RestController
@RequestMapping("/purchases")
public class PurchasesRestController {

    private MilkService milkService;

    private UserMilkPurchaseMapper userMilkPurchaseMapper;

    @Autowired
    public PurchasesRestController(MilkService milkService, UserMilkPurchaseMapper userMilkPurchaseMapper) {
        this.milkService = milkService;
        this.userMilkPurchaseMapper = userMilkPurchaseMapper;
    }

    @GetMapping
    public List<UserMilkPurchaseDto> getPurchases(){
        List<UserMilkPurchase> purchases = milkService.getPurchases();
        return userMilkPurchaseMapper.toDtos(purchases);
    }

    @PostMapping
    public List<UserMilkPurchaseDto> addPurchase(@RequestBody BuyMilkRequestDto buyMilkRequestDto){
        milkService.purchase(buyMilkRequestDto.quantity, buyMilkRequestDto.userId);
        return getPurchases();
    }

}
