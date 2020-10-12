package com.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.study.user.repository.UserRepository;

@SpringBootApplication
public class StudyJpaProjectApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(StudyJpaProjectApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

//			userRepository.save(new User("a", 10));
//			userRepository.save(new User("b", 15));
//			userRepository.save(new User("c", 10));
//			userRepository.save(new User("a", 5));
//			
//			Iterable<User> list1 = userRepository.findAll();
//			
//			System.out.println("findAll() Method.");
//			for( User m : list1){
//				System.out.println(m.getName());
//				System.out.println(m.getAge());
//			}
//			
//			System.out.println("findByNameAndAgeLessThan() Method.");
//			List<User> list2 = userRepository.findByNameAndAgeLessThan("a", 10);
//			for( User m : list2){
//				System.out.println(m.toString());
//			}
//			
//			System.out.println("findByNameAndAgeLessThanSQL() Method.");
//			List<User> list3 = userRepository.findByNameAndAgeLessThanSQL("a", 10);
//			for( User m : list3){
//				System.out.println(m.toString());
//			}
//			
//			System.out.println("findByNameAndAgeLessThanSQL() Method.");
//			List<User> list4 = userRepository.findByNameAndAgeLessThanOrderByAgeDesc("a", 15);
//			for( User m : list4){
//				System.out.println(m.toString());
//			}

			// userRepository.deleteAll();
	}
}

