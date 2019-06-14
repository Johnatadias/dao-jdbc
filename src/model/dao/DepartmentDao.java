package model.dao;

import java.util.List;

import model.entities.Department;

public interface DepartmentDao {

	void insert(Department obj); //responsavel por insirir no db o obj department
	void update(Department obj); //responsavel por atualizar no db o obj department
	void deleteById(Integer id); //responsavel por deletar no db o obj department
	Department findById(Integer id); //responsavel por consultar no db um obj com esse id
	List<Department> findAll(); //responsavel por retornar todos departments
}
