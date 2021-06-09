package com.ibm.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.entity.Admin;
/**
 * 
 * @author Harsh Anand
 *
 */
public interface AdminRepository extends JpaRepository<Admin, String>{


}
