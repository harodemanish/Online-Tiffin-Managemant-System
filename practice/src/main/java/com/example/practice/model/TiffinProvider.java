package com.example.practice.model;

import java.sql.Date;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tiffin_provider")
@Data
public class TiffinProvider {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="provider_id")
	private long provider_id;
	
	@Column(name="provider_phone_number")
	private String phoneNumber;
	
	@Column(name="provider_email")
	private String email;
	
	@Column(name="provider_name")
	private String providerName;
	
	@Column(name="provider_address")
	private String providerAddress;
	
	@Column(name="isApproved")
	private String isApproved = "N";
	
	@Column(name="provider_admin_login_id")
	private String providerAdminLoginId;
	
	@Column(name="provider_admin_password")
	private String password;
	
	
}
