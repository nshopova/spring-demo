package bg.proxiad.demo.spring.logic;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import bg.proxiad.demo.spring.model.StudentRepository;

@Service("studentService")
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class StudentServiceImpl implements StudentService{
//	@Autowired
	private StudentRepository studentRepository;
	private EmailService emailService;
	
	public StudentServiceImpl(StudentRepository studentRepository, EmailService emailService) {
		this.studentRepository = studentRepository;
		this.emailService = emailService;
		System.out.println("Constructor for studentService");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Init method for studentService");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Destroy method for studentService");
	}
	
	@Override
	public String getProject (String studentName) {
		return studentRepository.getStudent(studentName).getCourseProject();
	}
	
	@Override
	public void notifyStudentsWithoutProjects() {
		studentRepository.findAllStudents().stream().filter(student -> student.getCourseProject() == null)
			.forEach(student -> emailService.sendNotification(student));
	}
//	
//	@Autowired
//	public void setStudentRepository(StudentRepository studentRepository) {
//		this.studentRepository = studentRepository;
//	}
}
