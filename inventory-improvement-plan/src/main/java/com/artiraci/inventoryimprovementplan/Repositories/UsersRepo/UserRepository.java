package com.artiraci.inventoryimprovementplan.Repositories.UsersRepo;

import com.artiraci.inventoryimprovementplan.Models.Orders.RequestedOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<RequestedOrder,Long> {
}
