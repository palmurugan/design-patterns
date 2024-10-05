package com.pal.design.pattern.state.domain;

import com.pal.design.pattern.state.domain.enumeration.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "order_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

}
