package com.study.jpa.config;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.study.jpa.vo.Account;
import com.study.jpa.vo.Study;
import com.study.user.entity.User;
import com.study.user.repository.UserRepository;


@Component
@Transactional
public class JpaRunner implements ApplicationRunner{

	/**
	 * EntityManager: 인터페이스의 구현체를 통해서 DB와 자바 객체 사이의 데이터 교환
	 */
    @PersistenceContext
    EntityManager entityManager;
    
    @Autowired
    UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
    	System.out.println("----------------------ApplicationRunner Start--------------------------------");
    	System.out.println("----------------------JPA Test Start--------------------------------");
        // JPA Test Table - 1
    	Account account = new Account();
        account.setUsername("saelobi");
        account.setPassword("jpa");

        // JPA Test Table -2
        Study study = new Study();
        study.setName("Spring Data JPA");
        account.addStudy(study);
        
        entityManager.persist(account);
        entityManager.persist(study);
        
        System.out.println("----------------------JPA Test End--------------------------------");
        System.out.println("==================================================================");
        
        /**
         * 	API URL: 
         *  - https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
         *  [CrudRepository] userRepository.save() 		- 데이터 저장
         *	[CrudRepository] userRepository.findAll() 	- 데이터 모두 조회
         *	[CrudRepository] userRepositor.delete(컬럼) - 특정 컬럼에 대해서 데이터를 삭
         *	[CrudRepository] userRepository.deleteAll() - 데이터 모두 삭제
         *
         */
        
        // 생성자로 데이터 저장
        userRepository.save(new User("영희", 20, "adjh54@naver.com"));
		userRepository.save(new User("철수", 25, "adjh54ir@gmail.com"));
		userRepository.save(new User("민수", 27,  "ckask123@naver.com"));
		userRepository.save(new User("경민", 28,  "adjh54@kakao.com"));
		
		/*
		 * SELECT 문 Example
		 */
		System.out.println("====================select문 처리 Method. START=====================");

		// CASE1: 테이블 내 모든 데이터 조회
		Iterable<User> list1 = userRepository.findAll(); // 데이터 모두 검색
		
		for( User m : list1){
			System.out.println(m.getUsername());
			System.out.println(m.getAge());
		}
		
		// CASE2: 테이블 내 일부 데이터 조회
		User selectUserById = userRepository.findByUserEmail("adjh54@naver.com");
		System.out.println("selectUserById >>>>"+ selectUserById.toString());

		
		
		
		System.out.println("====================select문 처리 Method. END=====================");
		
		
		
		System.out.println("=====================findByUserName() Method. START=====================");

		List<User> list2 = userRepository.findByUserName("영희");
	
		for( User m : list2){
			System.out.println(m.getAge());
		}
			System.out.println("=====================findByUserName() Method. END=====================");
		

		/**
		 * UPDATE문 example
		 */
		
		
		
		
		userRepository.deleteAll();
		
    }
}