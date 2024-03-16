package com.artiraci.inventoryimprovementplan.Repositories.UsersRepo;

import com.artiraci.inventoryimprovementplan.Models.Users.Employee;
import com.artiraci.inventoryimprovementplan.Models.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    //
}
