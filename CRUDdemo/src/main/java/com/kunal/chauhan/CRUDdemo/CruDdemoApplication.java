package com.kunal.chauhan.CRUDdemo;

import com.kunal.chauhan.CRUDdemo.dao.StudentDAO;
import com.kunal.chauhan.CRUDdemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruDdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruDdemoApplication.class, args);
	}




	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){ //injecting studentDAO
		return runner -> {
//			createStudent(studentDAO);
//			readStudent(studentDAO);
//			getAllStudentData(studentDAO);
			findStudentByName(studentDAO);
		};
	}

	private void findStudentByName(StudentDAO studentDAO) {

		// get list of student

		List<Student> list = studentDAO.findByLastName("Chauhan");

		// print the result

		for(Student s :  list){
			System.out.println(s);
		}
	}

	private void getAllStudentData(StudentDAO studentDAO) {

		// get list of all the students

		List<Student> list = studentDAO.findAll();

		// print the student details

		for(Student s : list){
			System.out.println(s);
		}
	}


	private void readStudent(StudentDAO studentDAO){
		Student myStudent = studentDAO.findById(1);
		System.out.println("Found Student!!!!");
		System.out.println(myStudent.toString());
	}



	private void createStudent(StudentDAO studentDAO) {

		// create a student object

		System.out.println("Creating a student Object");
		Student tempStudent = new Student("Kunal", "Chauhan" , "kunalchauhanlion@gmail.com");

		// save the student object

		System.out.println("saving the student");
		studentDAO.save(tempStudent);

		// display the id of the saved student

		System.out.println("Saved Student id : "+tempStudent.getId());

	}

// making an command line runner
//	@Bean
//	public CommandLineRunner commandLineRunner(String[] args){
//		return runner -> {
//			System.out.println("Hello World!");
//		};
//	}


// without using lambda expression
//	@Bean
//	public CommandLineRunner commandLineRunner(String[] args){
//		return new CommandLineRunner() {
//			@Override
//			public void run(String... args) throws Exception {
//				System.out.println("Hello World!");
//			}
//		};
//	}



}
