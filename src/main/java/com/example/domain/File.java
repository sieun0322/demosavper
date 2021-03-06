package com.example.domain;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name="tbl_file_mst")
@EqualsAndHashCode(of="fid")
public class File {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fid;
	private String fname;
	//private String owner;
	//private String description;
	
	//private Timestamp expiredate;
	
	@CreationTimestamp
	private Timestamp regdate;
	
	@CreationTimestamp
	private Timestamp createdate;
	@UpdateTimestamp
	private Timestamp updatedate;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="fno")
	private List<Viewer> viewers;
}
