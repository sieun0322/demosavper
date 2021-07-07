package com.example.persistence;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.domain.File;
import com.example.domain.Member;

public interface MemberRepository extends CrudRepository<Member, Long>{
	@Query("SELECT m.uid,count(c) FROM Member m LEFT OUTER JOIN Cliper c "+
			"ON m.uid = c.member WHERE m.uid =?1 GROUP BY m")
	public List<Object[]> getMemberWithCliperCount(String uid);
}
