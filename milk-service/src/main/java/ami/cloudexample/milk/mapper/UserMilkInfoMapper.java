package ami.cloudexample.milk.mapper;

import ami.cloudexample.milk.dto.MilkPurchaseDto;
import ami.cloudexample.milk.entity.MilkPurchase;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.ZoneOffset.UTC;

/**
 * @author Mihai Alexandru
 * @date 23.10.2018
 */
@Component
public class UserMilkInfoMapper {

    public MilkPurchase toEntity(MilkPurchaseDto userMilkInfoDTO, Integer userId) {
        MilkPurchase entity = new MilkPurchase();
        entity.setUserId(userId);
        entity.setQuantity(userMilkInfoDTO.quantity);
        entity.setBuyDate(getDate(userMilkInfoDTO.buyDate));
        return entity;
    }

    public MilkPurchaseDto toDto(MilkPurchase milkPurchase) {
        MilkPurchaseDto dto = new MilkPurchaseDto();
        dto.quantity = milkPurchase.getQuantity();
        dto.buyDate = getDate(milkPurchase.getBuyDate());
        return dto;
    }

    public List<MilkPurchaseDto> toDtos(Collection<MilkPurchase> purchases) {
        return purchases.stream().map(this::toDto).collect(Collectors.toList());
    }

    private Date getDate(ZonedDateTime zonedDateTime) {
        Instant instant = zonedDateTime.toInstant();
        return new Date(instant.toEpochMilli());
    }

    private ZonedDateTime getDate(Date buyDate) {
        return ZonedDateTime.ofInstant(buyDate.toInstant(), UTC);
    }

}
