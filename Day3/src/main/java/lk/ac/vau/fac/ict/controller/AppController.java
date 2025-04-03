package lk.ac.vau.fac.ict.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ac.vau.fas.ict.model.Student;

@RestController
@RequestMapping("/app")

public class AppController {

	Student s1 = new Student("2020ICT47","Maleesha",23,"ICT",3.66);
	Student s2 = new Student("2020CS31","Ruwini",24,"CS",3.80);
	Student s3 = new Student("2020ASB88","Nimna",23,"BIO Sceince",4.0);
	Student s4 = new Student("2020ICT56","Pabodha",21,"IT",3.59);
	Student s5 = new Student("2020ICT95","Saduni",30,"AMC",3.25);
	
	List<Student> students = new ArrayList<Student>();
	List<Student> studentsAge = new ArrayList<Student>();
	List<Student> sortedStudents = new ArrayList<>(students);
	
	
	public AppController ()
	{
		   students.add(s1);
		   students.add(s2);
		   students.add(s3);
		   students.add(s4);
		   students.add(s5);
	}
	
	@GetMapping("/msg")
	public String Mymessage()
	{
		return "Hello Spring Boot!";
	}
	
	@GetMapping("/age/{ag}")
	public String Myage(@PathVariable("ag") int age)
	{
		return "My age is " +age;
	}
    
	//a method  to return student
   @GetMapping("/student")
   public Student getStudent() {
	   return s1;
   }
   
   @GetMapping("/students")
   public List<Student> getStudents() {
	   
	   return students;
   }
   
 //return multiple students
   @GetMapping("/students/{rg}")
   public Student getStudentReg(@PathVariable("rg") String regNo)
   {
	   for(Student stu:students)
	   {
		   if(stu.getRegNo().equals(regNo))
		   {
			   return stu;
		   }
	   }
	   
	   return null;
   }
   
  //find the students whose age between 20-23
   @GetMapping("/ages")
   public List<Student> getStudentAge()
   {
	  for(Student stu:students)
	  {
		  if(stu.getAge() > 19 && stu.getAge() < 24)
		  {
			  studentsAge.add(stu);
		  }
	  }
	  return studentsAge;
   }
   
  //Sort the student by gpa
   @GetMapping("/students/gpa")
   public List<Student> getstudentGpa()
   {
	   for (int i = 0; i < sortedStudents.size() - 1; i++) 
	   {
	        for (int j = 0; j < sortedStudents.size() - i - 1; j++)
	        {
	            if (sortedStudents.get(j).getGpa() > sortedStudents.get(j + 1).getGpa())
	            {
	                Student temp = sortedStudents.get(j);
	                sortedStudents.set(j, sortedStudents.get(j + 1));
	                sortedStudents.set(j + 1, temp);
	            }
	        }
	    }
	    
	    return sortedStudents;
   }
	
	
}
