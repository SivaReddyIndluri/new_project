package simpleProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import simpleProject.dto.Employee;
import simpleProject.entity.EmployeeEntity;
import simpleProject.service.EmpServiceImpl;

@RestController
@RequestMapping("api")
public class EmpController {
	
	@Autowired
	EmpServiceImpl empServiceImpl;
	
	@PostMapping("/employee")
	public String m1(@RequestBody Employee emp) {
		empServiceImpl.createEmp(emp);
		System.out.println("Nothing is permanent");
		return "Data stored in Db";
	}
	
	@GetMapping("/employee/{id}")
	public EmployeeEntity m2( @PathVariable long id) {
		return empServiceImpl.getid(id);
	}
	
	@DeleteMapping("/employee/{id}")
	public String m3(@PathVariable long id) {
		  empServiceImpl.deleteId(id);
		return "Deleted one item";
	}
	@GetMapping("/employee")
	public List<Employee> m1(){
		return empServiceImpl.findAll();
	}
	
	

}
