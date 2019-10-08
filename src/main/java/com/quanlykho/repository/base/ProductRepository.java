package com.quanlykho.repository.base;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.quanlykho.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Transactional
	@Modifying
	@Query(value = "UPDATE product set number = :number where id = :id", nativeQuery = true)
	public void updateNumberProduct(@Param("id")Integer id, @Param("number") Integer number);

	@Query(value = "SELECT  * from product  WHERE name_product LIKE CONCAT('%',:name,'%')",  nativeQuery = true)
	public List<Product> findByNameContaining(@Param("name")String term);
}
