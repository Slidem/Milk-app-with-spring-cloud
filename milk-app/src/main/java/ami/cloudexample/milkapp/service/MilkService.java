package ami.cloudexample.milkapp.service;

import ami.cloudexample.milkapp.client.MilkClient;
import ami.cloudexample.milkapp.client.UsersClient;
import ami.cloudexample.milkapp.client.dto.BuyMilkDto;
import ami.cloudexample.milkapp.client.dto.MilkPurchaseDto;
import ami.cloudexample.milkapp.dto.UserDto;
import ami.cloudexample.milkapp.objects.MilkPurchase;
import ami.cloudexample.milkapp.objects.User;
import ami.cloudexample.milkapp.objects.UserMilkPurchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import static ami.cloudexample.milkapp.objects.User.UserBuilder.anUser;

/**
 * @author Mihai Alexandru
 * @date 30.10.2018
 */
@Service
public class MilkService {

    private static final Duration MAX_SEARCH_RANGE = Duration.ofDays(60);

    private MilkClient milkClient;

    private UsersClient usersClient;

    @Autowired
    public MilkService(MilkClient milkClient, UsersClient usersClient) {
        this.milkClient = milkClient;
        this.usersClient = usersClient;
    }

    public List<UserMilkPurchase> getPurchases() {
        return usersClient.getUsers().stream().map(this::getUserMilkPurchase).collect(Collectors.toList());
    }

    public void purchase(Integer quantity, Integer userId) {
        BuyMilkDto buyMilkDto = new BuyMilkDto();
        buyMilkDto.quantity = quantity;
        milkClient.buyMilk(userId, buyMilkDto);
    }

    public void deleteUserLastPurchase(Integer userId) {
        deleteUserLastPurchase(userId);
    }

    // --------------------------------------------------------------------------

    private UserMilkPurchase getUserMilkPurchase(UserDto userDto) {

        Instant after = Instant.now().minus(MAX_SEARCH_RANGE);

        List<MilkPurchaseDto> purchasesDto = milkClient.getPurchases(userDto.id, after);
        List<MilkPurchase> milkPurchases = purchasesDto.stream().map(this::getMilkPurchase).collect(Collectors.toList());

        User user = anUser()
                .withId(userDto.id)
                .withFirstName(userDto.firstName)
                .withLastName(userDto.lastName)
                .build();

        return new UserMilkPurchase.UserMilkPurchaseBuilder()
                .withUser(user)
                .withMilkPurchases(milkPurchases)
                .build();
    }

    private MilkPurchase getMilkPurchase(MilkPurchaseDto milkPurchaseDto) {
        return new MilkPurchase.MilkPurchaseBuilder()
                .withPurchaseDate(milkPurchaseDto.buyDate)
                .withQuantity(milkPurchaseDto.quantity)
                .build();
    }

}
