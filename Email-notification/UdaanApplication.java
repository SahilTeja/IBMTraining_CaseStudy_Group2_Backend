package com.udaan;

import com.udaan.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class UdaanApplication implements CommandLineRunner{
	
	@Autowired
	private EmailService emailService;

	public static void main(String[] args) {
		SpringApplication.run(UdaanApplication.class, args);
	}
	
	@Override
	public void run(String... args) 
    {
        emailService.sendMail("dhulipalla16@iiitkottayam.ac.in", "Hi", "Ho ho ho");
    }

}
