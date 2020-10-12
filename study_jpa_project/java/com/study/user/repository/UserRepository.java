package com.study.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.study.user.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	
	@Query("select t from tb_user t where t.email=:email")
	User findByUserEmail(@Param("email") String email);
	
	@Query("select t from tb_user t where t.username=:username")
	List<User> findByUserName(@Param("username") String username);
	
//	List<User> findByNameAndAgeLessThan(String username, int age);
	
//	@Query("select t from tb_user t where username=:username and age < :age")
//	List<User> findByNameAndAgeLessThanSQL(@Param("username") String username, @Param("age") int age);
	
//	List<User> findByNameAndAgeLessThanOrderByAgeDesc(String username, int age);
	
}
