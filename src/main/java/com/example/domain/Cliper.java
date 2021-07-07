package com.example.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude="member")
@Entity
@Table(name="tbl_cliper")
@EqualsAndHashCode(of="cno")
public class Cliper {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cno;
	private String cname;
	private boolean useYn;
	
	@ManyToOne
	private Member member;
	@CreationTimestamp
	private Timestamp createdate;
	
	@UpdateTimestamp
	private Timestamp updatedate;
}
