package ami.cloudexample.milkapp.dto;

import ami.cloudexample.milkapp.client.dto.MilkPurchaseDto;

import java.util.List;

/**
 * @author Mihai Alexandru
 * @date 30.10.2018
 */
public class UserMilkPurchaseDto {

    public UserDto user;

    public List<MilkPurchaseDto> purchases;

}
