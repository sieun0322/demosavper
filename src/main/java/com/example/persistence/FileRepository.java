package com.example.persistence;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.domain.File;

public interface FileRepository extends CrudRepository<File, Long>{

	/*
	 * @Query("SELECT b FROM File f WHERE f.title LIKE %?1% AND f.fno > 0 ORDER BY f.fno DESC"
	 * ) public List<File> findFileByTitle(String title);
	 * 
	 * @Query("SELECT b FROM File f WHERE f.description LIKE %:description% AND f.fno > 0 ORDER BY f.fno DESC"
	 * ) public List<File> findFileByDescription(@Param("description") String
	 * description);
	 * 
	 * //@
	 * Query("SELECT b FROM #{#entityName} f WHERE f.description LIKE %:description% AND f.fno > 0 ORDER BY f.fno DESC"
	 * ) //public Collection<File> findByOwner(String owner);
	 * 
	 * public Collection<File> findByOwnerContaining(String owner); public
	 * Collection<File> findByTitleContainingorDescriptionContaining(String
	 * title,String description); public Collection<File>
	 * findByTitleContainingAndFnoGreaterThan(String keywords,Long num); public
	 * Collection<File> findByFnoGreaterThanOrderByFnoDesc(Long fno); //페이징 public
	 * List<File> findByFnoGreaterThanOrderByFnoDesc(Long fno, Pageable paging);
	 * //PageRequest()로 정렬 //ex)Pageable paging =
	 * PageRequest.of(0,10,Sort.direction.ASC,"fno") //public List<File>
	 * findByFnoGreaterThan(Long fno, Pageable paging); //List 대신 Page를 사용, 필요한 데이터
	 * 사용가능(데이터 개수, 현재페이지 정보...) public Page<File> findByFnoGreaterThan(Long fno,
	 * Pageable paging);
	 */
	@Modifying
	@Query("UPDATE FROM Viewer v set v.vnickname =?2 WHERE v.vid=?1")
	public int updateViewer(Long vid, String newNickname);
	}

