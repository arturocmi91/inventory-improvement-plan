package com.artiraci.inventoryimprovementplan.Repositories.OrdersRepo;

import com.artiraci.inventoryimprovementplan.Models.Orders.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder,Long> {

}
