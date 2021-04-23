package bg.proxiad.demo.spring.model;

import java.util.Collection;

public interface StudentRepository {
	Collection<Student> findAllStudents();
	Student getStudent(String name);
}
