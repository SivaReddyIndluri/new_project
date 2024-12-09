package simpleProject.service;

import java.util.List;

import simpleProject.dto.Employee;
import simpleProject.entity.EmployeeEntity;

public interface EmpService {
	
	public EmployeeEntity createEmp(Employee employee);
	public EmployeeEntity getid(Long id);
	public List<Employee> findAll();
	public EmployeeEntity updateEmpDetails(EmployeeEntity employeeUpdate, Long id);
	public EmployeeEntity deleteId(long id);
}
