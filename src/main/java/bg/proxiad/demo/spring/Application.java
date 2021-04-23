package bg.proxiad.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bg.proxiad.demo.spring.logic.EmailService;
import bg.proxiad.demo.spring.logic.StudentService;

public class Application {
   public static void main(String[] args) {
	   AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
	   
	   StudentService studentService = context.getBean("studentService", StudentService.class);
	   
	   studentService.notifyStudentsWithoutProjects();
	   
	   System.out.println(studentService);
	   
	   EmailService emailService = context.getBean("emailService", EmailService.class);
	   emailService.sentNotificationToAllStudents();
	   
	   
	   context.close();
   }
}