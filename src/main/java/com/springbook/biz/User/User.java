package com.springbook.biz.User;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name="TB_User")
public class User {
	
	@GeneratedValue(strategy = GenerationType.AUTO) // 레코드 추가할때마다 자동으로 1 씩 증가함
	@Id
	private Integer userCode;         
	private String id;               
	private String pw;               
	private String email;           
	private String userImage;        
	private String name;             
	private String birth;            
	private String postNum;          
	private String phoneCd;         
	private String phoneNum;         
	private String address;          
	private String entDate;          
	private String grade;		
	
	@PrePersist 
	public void prePersist() {
		this.entDate = this.entDate == null ? new SimpleDateFormat("yyyy-MM-dd").format(new Date()) : this.entDate;
	}
	
}
