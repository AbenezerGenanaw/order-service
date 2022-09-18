package edu.miu.cs590.orderservice.serviceimpl;

import edu.miu.cs590.orderservice.dto.ItemsDto;
import edu.miu.cs590.orderservice.entity.Items;
import edu.miu.cs590.orderservice.mapper.ItemsMapper;
import edu.miu.cs590.orderservice.repository.ItemsRepository;
import edu.miu.cs590.orderservice.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    ItemsMapper itemsMapper;

    @Autowired
    ItemsRepository itemsRepository;

    @Override
    public ItemsDto getItemById(Long id) {
        return itemsMapper.toDto(itemsRepository.findById(id).orElseThrow(()->new RuntimeException("")));
    }

    @Override
    public List<Items> saveAll(List<Items> items) {
        return null;
    }


}
