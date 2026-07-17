package com.railone.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="railone_otp")
public class OtpEntity
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
     private int id;
     private int otp;
     private String status;
  
     public int getId() {
		return id;
	}
	 public void setId(int id) {
		 this.id = id;
	 }
	 public int getOtp() {
		 return otp;
	 }
	 public void setOtp(int otp) {
		 this.otp = otp;
	 }
	 public String getStatus() {
		 return status;
	 }
	 public void setStatus(String status) {
		 this.status = status;
	 }
	 
}
