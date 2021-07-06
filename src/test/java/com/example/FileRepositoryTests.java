package com.example;

import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.File;
import com.example.domain.QFile;
import com.example.persistence.FileRepository;
import com.querydsl.core.BooleanBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileRepositoryTests {
	
	@Autowired
	private FileRepository fileRepo;

	@Test
	public void inspect() {
		System.out.println("TEST ");
		Class<?> clz = fileRepo.getClass();

		System.out.println(clz.getName());

		Class<?>[] interfaces = clz.getInterfaces();

		Stream.of(interfaces).forEach(inter -> System.out.println(inter.getName()));

		Class<?> superClasses = clz.getSuperclass();

		System.out.println(superClasses.getName());
	}

	@Test
	public void testInsert() {

		File file = new File();
		file.setTitle("파일의 제목");
		file.setDescription("OO설명회 자료....");
		file.setOwner("user00");

		fileRepo.save(file);

	}

	@Test
	public void testRead() {

		//Board board = boardRepo.findOne(1L);

		//System.out.println(board);
		
		fileRepo.findById(1L).ifPresent((board)->{
			System.out.println(board);
		});

	}

	@Test
	public void testUpdate() {

		System.out.println("Read First.........................");
		File file = fileRepo.findById(1L).get();

		System.out.println("Update Title.......................");
		file.setTitle("수정된 제목입니다");

		System.out.println("Call Save( ).......................");
		fileRepo.save(file);

	}
	@Test
	public void testInsert200() {

		for(int i = 1;i<=200; i++) {
		File file = new File();
		file.setTitle("파일의 제목");
		file.setDescription("OO설명회 자료"+i+"....");
		file.setOwner("user0"+(i%10));

		fileRepo.save(file);
		}
	}
	@Test
    public void testPredicate() {
        String type = "t";
        String keyword = "17";

        BooleanBuilder builder = new BooleanBuilder();

        QFile file = QFile.file;
        if (type.equals("t")) {
            builder.and(file.title.like("%" + keyword + "%"));
        }

        // bno > 0
        builder.and(file.fno.gt(0L));

        Pageable pageable = PageRequest.of(0, 10);

        Page<File> result = fileRepo.findAll(builder, pageable);

        System.out.println("PAGE SIZE: " + result.getSize());
        System.out.println("TOTAL PAGES: " + result.getTotalPages());
        System.out.println("TOTAL COUNT: " + result.getTotalElements());
        System.out.println("NEXT: " + result.nextPageable());

        List<File> list = result.getContent();

        list.forEach(b -> System.out.println(b));
    }
}
