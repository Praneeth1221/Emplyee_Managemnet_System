package edu.icet.repository;

import edu.icet.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {
    List<EmployeeEntity> findByName(String name);
}
