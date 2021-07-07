package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Cliper;
import com.example.domain.Member;
import com.example.persistence.CliperRepository;
import com.example.persistence.MemberRepository;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class CliperRepositoryTests {
	@Autowired
	MemberRepository memberRepo;

	@Autowired
	CliperRepository cliperRepo;
	
	@Test
	public void testInsertMembers() {

		IntStream.range(1, 101).forEach(i -> {
			Member member = new Member();
			member.setUid("user" + i);
			member.setUpw("pw" + i);
			member.setUname("사용자" + i);

			memberRepo.save(member);

		});	

	}// end method
	@Test
	public void testInsertCliper() {

		Member member = new Member();
		member.setUid("user1");

		for (int i = 1; i < 5; i++) {

			Cliper cliper1 = new Cliper();
			cliper1.setCname("docu" + i + ".jpg");

			if (i == 1) {
				cliper1.setUseYn(true);
			}

			cliper1.setMember(member);

			cliperRepo.save(cliper1);

		}
	}
	@Test
	public void testFetchJoin1() {

		List<Object[]> result = memberRepo.getMemberWithCliperCount("user1");

		result.forEach(arr -> System.out.println(Arrays.toString(arr)));

	}
}
