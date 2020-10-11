package com.study.jpa.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.study.book.entity.BookEntity;
import com.study.book.entity.BookRentalEntity;
import com.study.jpa.vo.Account;
import com.study.jpa.vo.Study;


@Component
@Transactional
public class JpaRunner implements ApplicationRunner{

	/**
	 * EntityManager: 인터페이스의 구현체를 통해서 DB와 자바 객체 사이의 데이터 교환
	 */
    @PersistenceContext
    EntityManager entityManager;

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
        
        
        
        
        System.out.println("----------------------QueryDSL Test Start--------------------------------");
        // QueryDSL Test Table-1
        BookEntity bookEntity = new BookEntity();
        
        // QueryDSL Test Table-2
        BookRentalEntity bookRentalEntity = new BookRentalEntity();
        
        entityManager.persist(bookEntity);
        entityManager.persist(bookRentalEntity);
        System.out.println("----------------------QueryDSL Test End--------------------------------");
    }
}
