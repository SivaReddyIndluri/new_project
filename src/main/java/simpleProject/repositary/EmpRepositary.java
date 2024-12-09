package simpleProject.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import simpleProject.entity.EmployeeEntity;

@Repository
public interface EmpRepositary extends JpaRepository<EmployeeEntity, Long>{

}
