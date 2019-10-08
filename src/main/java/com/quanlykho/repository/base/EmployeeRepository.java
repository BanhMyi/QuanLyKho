package com.quanlykho.repository.base;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.quanlykho.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee	, Integer>{
//	@Query("select * from employee u where u.user_name = :username", nativeQuery = true)
	public Employee findByUserName(String userName);

	@Query(value = "SELECT * from EMPLOYEE WHERE user_name LIKE CONCAT('%', :user_name, '%')", nativeQuery = true)
	public List<Employee> searchByName(@Param("user_name") String term);

	@Transactional
	@Modifying
	@Query(value = "UPDATE EMPLOYEE SET status = 'deactive' WHERE id = :id", nativeQuery = true)
	public void deactiveEmployee(@Param("id") Integer id);
}
