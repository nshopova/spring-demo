package bg.proxiad.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import bg.proxiad.demo.spring.logic.StudentService;
import bg.proxiad.demo.spring.logic.StudentServiceImpl;
import bg.proxiad.demo.spring.model.StudentRepository;
import bg.proxiad.demo.spring.model.StudentRepositoryImpl;

@Configuration
@ComponentScan()
public class Config {
//	
//	@Bean("studentService")
//	public StudentService getStudentService() {
//		return new StudentServiceImpl(studentRepository());
//	}
//
//	@Bean(initMethod = "init")
//	public StudentRepository studentRepository() {
//		return new StudentRepositoryImpl();
//	}
}
