package com.project.shopapp.repositories;

import com.project.shopapp.model.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Integer> {

    List<OrderDetailEntity> findByOrderId(int id);
}
