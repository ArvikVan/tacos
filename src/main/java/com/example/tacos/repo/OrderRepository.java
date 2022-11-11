package com.example.tacos.repo;

import com.example.tacos.model.TacoOrder;
import org.springframework.stereotype.Repository;

public interface OrderRepository {
    TacoOrder save(TacoOrder tacoOrder);
}
