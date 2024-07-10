package com.trade.autioneaseproject.DAO;

import com.trade.autioneaseproject.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WarehouseDAO extends JpaRepository<Warehouse, Integer> {
    @Query("SELECT w FROM Warehouse w WHERE w.delflag = false")
    List<Warehouse> findAllActive();

    @Query("SELECT w FROM Warehouse w WHERE w.warehouseId = :id AND w.delflag = false")
    Optional<Warehouse> findActiveById(Integer id);
}
