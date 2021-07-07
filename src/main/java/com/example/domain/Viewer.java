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
@Table(name="tbl_viewer")
@EqualsAndHashCode(of="vid")
public class Viewer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vid;
	//private String vpw;
	private String vnickname;
	
	//private int vcount;
	
	//private Timestamp expiredate;
	
	@CreationTimestamp
	private Timestamp latestdate;
	
	@CreationTimestamp
	private Timestamp createdate;
	@UpdateTimestamp
	private Timestamp updatedate;
}
