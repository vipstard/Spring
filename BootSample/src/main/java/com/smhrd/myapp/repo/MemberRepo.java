package com.smhrd.myapp.repo;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smhrd.myapp.domain.Member;

@Repository
public interface MemberRepo extends JpaRepository<Member, String>{
	
	@Query("SELECT m FROM WEB_MEMBER m WHERE m= :id")
	public Member findAdmin(@Param("id") String id);

}
