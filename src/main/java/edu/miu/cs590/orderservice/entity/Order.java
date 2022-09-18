package edu.miu.cs590.orderservice.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "order_items",
            joinColumns={@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name="items_id")})
    private List<Items> items = new java.util.ArrayList<>();
//
//    @OneToOne(cascade = CascadeType.ALL)
//    private ShippingAddress shippingAddress;



}
