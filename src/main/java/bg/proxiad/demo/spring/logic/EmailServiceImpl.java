package bg.proxiad.demo.spring.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.proxiad.demo.spring.model.Student;
import bg.proxiad.demo.spring.model.StudentRepository;

@Service("emailService")
public class EmailServiceImpl implements EmailService {
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StudentService studentService;
	
	@Override
	public void sendNotification(Student student) { 
		if (student != null) {
			System.out.println("Sending notification to " + student.getName());
		}
	}
	
	@Override
	public void sentNotificationToAllStudents() {
		studentRepository.findAllStudents().stream().filter(student -> student.getCourseProject() != null)
			.map(student -> "Congratulations! Your project was reviwed " + studentService.getProject(student.getName()))
			.forEach(System.out::println);
	}

}
