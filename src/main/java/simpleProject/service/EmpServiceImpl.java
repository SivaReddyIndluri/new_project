package simpleProject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import simpleProject.dto.Employee;
import simpleProject.entity.EmployeeEntity;
import simpleProject.repositary.EmpRepositary;

@Service
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	public EmpRepositary empRepo;

	@Override
	public EmployeeEntity createEmp(Employee employee) {
		EmployeeEntity emp = new EmployeeEntity();
		///Employee emps = new Employee();
		emp.setEmpAddress(employee.getEmpAddress());
		emp.setEmpLocation(employee.getEmpLocation());
		emp.setEmpId(employee.getEmpId());
		emp.setEmpName(employee.getEmpName());
		return empRepo.save(emp);
	}

	@Override
	public EmployeeEntity getid(Long id) {
		return empRepo.findById(id).orElse(null);
	}

	@Override
	public EmployeeEntity deleteId(long id) {
		EmployeeEntity empEntity =   empRepo.findById(id).orElse(null);
		empRepo.delete(empEntity);
		return empEntity;
	}

	@Override
	public EmployeeEntity updateEmpDetails(EmployeeEntity employeeUpdate, Long id) {
		  EmployeeEntity empDta =  empRepo.findById(id).orElse(null);
		  empDta.setEmpId(employeeUpdate.getEmpId());
		  empDta.setEmpAddress(employeeUpdate.getEmpAddress());
		  empDta.setEmpLocation(employeeUpdate.getEmpLocation());
		  empDta.setEmpName(employeeUpdate.getEmpName());
		return empRepo.save(empDta);
	}
	
	@Override
	public List<Employee> findAll() {
		List<EmployeeEntity> empDetails =  empRepo.findAll();
		List<Employee>  list = new ArrayList<Employee>();
		for(EmployeeEntity emp : empDetails) {
			Employee emps = new Employee();
			emps.setEmpId(emp.getEmpId());
			emps.setEmpAddress(emp.getEmpAddress());
			emps.setEmpLocation(emp.getEmpLocation());
			emps.setEmpName(emp.getEmpName());
			list.add(emps);
		}
		return list;
	}


	
}
