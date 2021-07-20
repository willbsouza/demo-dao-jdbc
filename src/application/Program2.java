package application;

import java.util.List;
import java.util.Scanner;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
		Department dep = depDao.findById(3);
		System.out.println("=== TEST 1: department findById ===");
		System.out.println(dep);
		
		System.out.println("\n=== TEST 2: department findAll ===");		
		List<Department> list = depDao.findAll();
		for (Department aux : list) {
			System.out.println(aux);
		}
		
		System.out.println("\n=== TEST 3: department insert ===");
		Department newDepartment = new Department(null, "Music");
		depDao.insert(newDepartment);
		System.out.println("Inserted! New Id = " + newDepartment.getId());
		
		System.out.println("\n=== TEST 4: department update ===");
		dep = depDao.findById(1);
		dep.setName("Computers");
		depDao.update(dep);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 5: department delete ===");	
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		depDao.deleteById(id);
		System.out.println("Delete completed");
				
	}

}
