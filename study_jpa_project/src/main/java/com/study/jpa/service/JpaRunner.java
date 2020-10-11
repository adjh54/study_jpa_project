package com.study.jpa.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

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
        Account account = new Account();
        account.setUsername("saelobi");
        account.setPassword("jpa");
//
        //
        Study study = new Study();
        study.setName("Spring Data JPA");
        account.addStudy(study);
        
        entityManager.persist(account);
        entityManager.persist(study);
    }
}
