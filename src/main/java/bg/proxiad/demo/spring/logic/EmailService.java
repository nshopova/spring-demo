package bg.proxiad.demo.spring.logic;

import bg.proxiad.demo.spring.model.Student;

public interface EmailService {
	void sendNotification(Student student);

	void sentNotificationToAllStudents();
}
