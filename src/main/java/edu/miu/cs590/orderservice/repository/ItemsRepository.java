package edu.miu.cs590.orderservice.repository;

import edu.miu.cs590.orderservice.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends JpaRepository<Items,Long> {
}
