package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("==== Test 1: department insert ====");
		Department dep = new Department(null, "Infra");
		departmentDao.insert(dep);
		System.out.println("Inserted! New id = " + dep.getId());
		
		
		System.out.println("==== Test 2: department update ====");
		dep = departmentDao.findById(1);
		dep.setName("Matematica");
		departmentDao.update(dep);
		System.out.println("Update completed");
		
		
		System.out.println("==== Test 3: department findById ====");
		dep = departmentDao.findById(8);
		System.out.println(dep);
		
		
		System.out.println("==== Test 4: department deleteById ====");
		System.out.print("Enter for id delete: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		
		
		System.out.println("==== Test 5: department findByAll ====");
		List<Department> list = departmentDao.findAll();
		for(Department all : list) {
			System.out.println(all);
		}
		
		sc.close();
	}

}
