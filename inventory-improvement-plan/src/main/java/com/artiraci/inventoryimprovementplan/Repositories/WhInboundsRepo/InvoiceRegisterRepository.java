package com.artiraci.inventoryimprovementplan.Repositories.WhInboundsRepo;

import com.artiraci.inventoryimprovementplan.Models.Users.User;
import com.artiraci.inventoryimprovementplan.Models.WhInbound.InvoiceRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRegisterRepository extends JpaRepository<InvoiceRegister,Long> {
}
