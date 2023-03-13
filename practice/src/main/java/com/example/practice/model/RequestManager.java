package com.example.practice.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="request_table")
@Data
public class RequestManager {


	@Id
	@SequenceGenerator(name = "request_table_seq", sequenceName = "request_table_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator =  "request_table_seq")
	@Column(name="request_id")
	private long request_id;
	
	@Column(name="request_status")
	private String requestStatus="N";
	
	@Column(name="provider_id")
	private String providerId;
	
	@Column(name="provider_name")
	private String providerName;

	@Column(name="comments")
	private String comments;
	
	@Column(name="latest_updated_date")
	private Timestamp latestUpdatedDate = Timestamp.valueOf(LocalDateTime.now());
	
	@Column(name="approvedby")
	private String approvedBy = null;
	
	@Column(name="latest_requested_date")
	private Timestamp latestRequestedDate;
	
	@Column(name="latest_approved_date")
	private Timestamp latestApprovedDate;
	
	
	
}
