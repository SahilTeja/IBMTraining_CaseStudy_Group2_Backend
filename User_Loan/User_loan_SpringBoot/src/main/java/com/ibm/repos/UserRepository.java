package com.ibm.repos;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ibm.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
		
	@Transactional
	@Modifying
	@Query("update User b set b.name = (?1),b.mobilenumber = (?2),b.aadress = (?3),b.email = (?4),b.aadhar = (?5),b.panCard = (?6),b.salary = (?7),b.state = (?8),b.country = (?9),b.dateofbirth=(?10) where b.userId = (?11)")
	void updateProfile(@Param("name")String name,@Param("mobilenumber")String mobilenumber,@Param("aadress")String aadress,@Param("email")String email,@Param("aadhar")String aadhar,@Param("panCard")String panCard,@Param("salary") double salary,@Param("state")String state,@Param("country")String country,@Param("dateofbirth") LocalDate dateofbirth, @Param("userId") int userId);

}
