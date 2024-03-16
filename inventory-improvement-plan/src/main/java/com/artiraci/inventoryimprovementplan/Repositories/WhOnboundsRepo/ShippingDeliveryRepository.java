package com.artiraci.inventoryimprovementplan.Repositories.WhOnboundsRepo;

import com.artiraci.inventoryimprovementplan.Models.Users.User;
import com.artiraci.inventoryimprovementplan.Models.WhOutbound.ShippingDelivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingDeliveryRepository extends JpaRepository<ShippingDelivery,Long> {
}
