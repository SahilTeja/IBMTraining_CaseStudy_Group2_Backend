package com.ibm.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.entity.User;
/**
 * 
 * @author Harsh Anand
 *
 */
public interface UserRepository extends JpaRepository<User, Integer>{

}
