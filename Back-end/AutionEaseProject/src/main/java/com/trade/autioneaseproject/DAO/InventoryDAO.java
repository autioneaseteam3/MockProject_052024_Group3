package com.trade.autioneaseproject.DAO;

import com.trade.autioneaseproject.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryDAO extends JpaRepository<Inventory, Integer> {
    @Query("SELECT i FROM Inventory i WHERE i.delflag = false")
    List<Inventory> findAllActive();

    @Query("SELECT i FROM Inventory i WHERE i.inventoryID = :id AND i.delflag = false")
    Optional<Inventory> findActiveById(Integer id);
}
