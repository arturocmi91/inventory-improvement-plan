package com.artiraci.inventoryimprovementplan.Repositories;

import com.artiraci.inventoryimprovementplan.Models.Customer;
import com.artiraci.inventoryimprovementplan.Models.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {
    //
}
