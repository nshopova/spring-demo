package bg.proxiad.demo.spring.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Repository;

@Repository("studentRepository")
public class StudentRepositoryImpl implements StudentRepository {
	
	@Override
	public Collection<Student> findAllStudents() {
		Student student1 = new Student();
		student1.setName("Мария");
		student1.setCourseProject("Hangman");
		
		Student student2 = new Student();
		student2.setName("Иван");
		student2.setCourseProject("Pet store");
		
		Student student3 = new Student();
		student3.setName("Елена");
		student3.setCourseProject("Vaccines reservation system");
		
		Student student4 = new Student();
		student4.setName("Георги");
		
		List<Student> students = new ArrayList<>();
		students.add(student1);
		students.add(student2);
		students.add(student3);
		students.add(student4);
		
		return students;
	}

	@Override
	public Student getStudent(String name) {
		Optional<Student> student = findAllStudents().stream().filter(s -> s.getName().equals(name))
				.findFirst();
		return student.orElse(null);
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Init method for studentRepository");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Destroy method for studentRepository");
	}
}
