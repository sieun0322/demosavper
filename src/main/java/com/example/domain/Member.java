package com.example.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="tbl_member")
@EqualsAndHashCode(of="uid")
public class Member {
	
	@Id
	private String uid;
	private String upw;
	private String uname;
	
	
	@CreationTimestamp
	private Timestamp regdate;
	@CreationTimestamp
	private Timestamp createdate;
	@UpdateTimestamp
	private Timestamp updatedate;
}
