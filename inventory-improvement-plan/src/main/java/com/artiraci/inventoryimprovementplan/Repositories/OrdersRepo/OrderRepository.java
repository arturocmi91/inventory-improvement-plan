package com.artiraci.inventoryimprovementplan.Repositories.OrdersRepo;

import com.artiraci.inventoryimprovementplan.Models.Orders.Order;
import com.artiraci.inventoryimprovementplan.Models.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<User,Long> {


}
