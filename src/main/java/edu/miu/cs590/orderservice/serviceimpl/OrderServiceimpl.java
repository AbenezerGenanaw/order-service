package edu.miu.cs590.orderservice.serviceimpl;

import edu.miu.cs590.orderservice.dto.OrderDto;
import edu.miu.cs590.orderservice.entity.Order;
import edu.miu.cs590.orderservice.mapper.OrderMapper;
import edu.miu.cs590.orderservice.repository.OrderRepository;
import edu.miu.cs590.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceimpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public OrderDto getById(Long id) {
        return orderMapper.toOrderDto(orderRepository.findById(id).orElseThrow());
    }

    @Override
    public List<OrderDto> getAllOrders() {
        try{
            List<Order> orders = orderRepository.findAll();
//            return orderMapper.toOrderDtos(orders);
            return null;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public OrderDto save(OrderDto order) {

        return orderMapper.toOrderDto(orderRepository.save(orderMapper.dtoToOrder(order)));
    }

//    @Override
//    public ProductDto addProduct(ProductDto product) {
//        return  productMapper.toProductDto(productRepository.save(productMapper.dtoToEntity(product))) ;
//    }


    @Override
    public OrderDto updateOrder(OrderDto orderDto) {

        Order ord = orderMapper.dtoToOrder(orderDto);
                if(ord != null){
                    return orderMapper.toOrderDto(orderRepository.save(ord));
                }
                return null;
    }


    @Override
    public void deleteOrder(Long id) {
      orderRepository.deleteById(id);
    }
}

