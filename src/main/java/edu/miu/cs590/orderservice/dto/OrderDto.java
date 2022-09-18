package edu.miu.cs590.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDto {

    private Long id;
    private String userId;
    private String status;
    private List<ItemsDto> items;
//    private Long shippingAddressId;

}
