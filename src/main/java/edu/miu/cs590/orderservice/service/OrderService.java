package edu.miu.cs590.orderservice.service;

import edu.miu.cs590.orderservice.dto.OrderDto;

import java.util.List;


public interface OrderService {
    OrderDto getById(Long id);
    List<OrderDto> getAllOrders();
    OrderDto save(OrderDto order);
    OrderDto updateOrder(OrderDto orderDto);

     void deleteOrder(Long id);

}
