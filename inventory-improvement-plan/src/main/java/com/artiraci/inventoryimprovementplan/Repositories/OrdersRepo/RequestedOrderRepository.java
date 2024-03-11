package com.artiraci.inventoryimprovementplan.Repositories.OrdersRepo;

import com.artiraci.inventoryimprovementplan.Models.Orders.Order;
import com.artiraci.inventoryimprovementplan.Models.Orders.RequestedOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestedOrderRepository extends JpaRepository<RequestedOrder,Long> {
}
