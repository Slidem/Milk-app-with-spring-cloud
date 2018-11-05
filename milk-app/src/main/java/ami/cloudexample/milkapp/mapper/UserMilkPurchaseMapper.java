package ami.cloudexample.milkapp.mapper;

import ami.cloudexample.milkapp.client.dto.MilkPurchaseDto;
import ami.cloudexample.milkapp.dto.UserDto;
import ami.cloudexample.milkapp.dto.UserMilkPurchaseDto;
import ami.cloudexample.milkapp.objects.MilkPurchase;
import ami.cloudexample.milkapp.objects.UserMilkPurchase;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author Mihai Alexandru
 * @date 31.10.2018
 */
@Component
public class UserMilkPurchaseMapper {

    public UserMilkPurchaseDto toDto(UserMilkPurchase userMilkPurchase) {
        UserDto userDto = new UserDto();
        userDto.id = userMilkPurchase.getUser().getId();
        userDto.firstName = userMilkPurchase.getUser().getFirstName();
        userDto.lastName = userMilkPurchase.getUser().getLastName();
        List<MilkPurchaseDto> milkPurchaseDtos = getMilkPurchaseDtos(userMilkPurchase.getMilkPurchases());

        UserMilkPurchaseDto userMilkPurchaseDto = new UserMilkPurchaseDto();
        userMilkPurchaseDto.user = userDto;
        userMilkPurchaseDto.purchases = milkPurchaseDtos;

        return userMilkPurchaseDto;
    }

    public List<UserMilkPurchaseDto> toDtos(Collection<UserMilkPurchase> userMilkPurchases) {
        return userMilkPurchases.stream().map(this::toDto).collect(toList());
    }

    // ---------------------------------------------------------------------------------

    private MilkPurchaseDto getMilkPurchaseDto(MilkPurchase milkPurchase) {
        MilkPurchaseDto milkPurchaseDto = new MilkPurchaseDto();
        milkPurchaseDto.buyDate = milkPurchase.getPurchaseDate();
        milkPurchaseDto.quantity = milkPurchase.getQuantity();
        return milkPurchaseDto;
    }

    private List<MilkPurchaseDto> getMilkPurchaseDtos(Collection<MilkPurchase> purchases) {
        return purchases.stream().map(this::getMilkPurchaseDto).collect(toList());
    }


}
