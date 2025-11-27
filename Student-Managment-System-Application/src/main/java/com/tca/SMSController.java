package com.tca;

import java.util.List;
import java.util.Scanner;

import com.tca.entity.Course;
import com.tca.entity.Student;
import com.tca.factory.CourseServiceFactory;
import com.tca.factory.RegistrationServiceFactory;
import com.tca.factory.StudentServiceFactory;
import com.tca.service.CourseService;
import com.tca.service.RegistrationService;
import com.tca.service.StudentService;
import com.tca.util.HibernateUtil;

public class SMSController 
{
	public static void main(String args[])
	{
		//optionCancelRegistration();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("\n************** Welcome to Student Management Application ************ \n");

		
		try
		{
			while(true)
			{
				System.out.println("Menu");
				 
	    		System.out.println("1. Save Student Record ");
	    		System.out.println("2. Fetch Student By Id ");
	    		System.out.println("3. Fetch Student By name ");
	    		System.out.println("4. Fetch Student By city ");
	    		System.out.println("5. Update Student");
	    		System.out.println("6. Delete Student");
	    		System.out.println("7. All Student ");
	    		System.out.println("8. Add Course Information ");
	    		System.out.println("9. All Course Information ");
	    		System.out.println("10. Fetch Course By Id");
	    		System.out.println("11.Fetch Course By Name");
	    		System.out.println("12.Update Course Information");
	    		System.out.println("13.Delete Course Information");
	    		System.out.println("14. Register Student to Course");
		        System.out.println("15. Get Student Details From Course");
		        System.out.println("16. Get Course Details From Student");
		        System.out.println("17. Cancel Registration");
	    		System.out.println("18. Exit ");
	    		
	    		
	    		System.out.print("What is your choice : ");
	    	    int choice  = sc.nextInt();
	    	    
	    	    switch(choice)
	    	    {
		    	    case 1: optionSaveStudent();
							break;
				
					case 2 :optionFetchStudentById();
							break;
					case 3 : optionFetchStudentByName();
						 	break;
						 	
					case 4 :optionFetchStudentByCity();;
							break;
							
					case 5 :optionUpdateStudent();
						 	break;
						 	
					case 6 :optionDeleteStudent();
						 	break;
						 	
					case 7 :optionFecthAllStudent();
							break;
						
					case 8 :optionAddCourse();
							break;
							
					case 9 :optionFetchAllCourse();
							break;
					
					case 10:optionFechCourseById();
							break;
					
					case 11:optionFetchCourseByName();
							break;
					
					case 12:optionModifyCourse();
							break;
							
					case 13 :optionDeleteCourse();
							break;
							
					case 14 :optionRegistration();
							break;
					
					case 15 :optionGetStudentDetailsFromCourse();
							 break;
					
					case 16 :optionGetCourseDetailsFromStudent();
							 break;
					
					case 17 :optionCancelRegistration();
							 break;
		
					case 18 :
								HibernateUtil.closeSessionFactory();
								System.out.println("********** Shutdown System ************* !!!");
								System.exit(0);
					default:
							System.out.println("***** Invalid choice ! *****");
				    	    }
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Done !!!");

		}
		
		finally
		{
			HibernateUtil.closeSessionFactory();

		}
	
		
	}
	
	

	private static void optionCancelRegistration() 
	{
		RegistrationService service=RegistrationServiceFactory.getRegestrationServiceInstance();
		Scanner sc=new Scanner(System.in);

		try
		{
			System.out.print("Enter the Student id for cancel admission:");
			Integer sid=sc.nextInt();
			
			System.out.print("Enter the Course Id for cancel admission :");
			Integer cid=sc.nextInt();

			boolean status =service.removeRegistration(sid, cid);
			
			if(status)
			{
				System.out.println("Registration Cancel Successfull.!!!");
			}
			else
			{
				System.out.println("Registration Not Found!!!");

			}
		}
		catch(Exception e)
		{
			System.out.println("Problem During Registration Cnacelation !!!");
			e.printStackTrace();
			
		}

	}

	
	private static void optionRegistration() 
	{
		RegistrationService service=RegistrationServiceFactory.getRegestrationServiceInstance();
		Scanner sc=new Scanner(System.in);

		try
		{
			System.out.print("Enter the Student id:");
			Integer sid=sc.nextInt();
			
			System.out.print("Enter the Course Id :");
			Integer cid=sc.nextInt();

			boolean status =service.addRegistration(sid, cid);
			
			if(status)
			{
				System.out.println("Registration Successfull.!!!");
			}
			else
			{
				System.out.println("Registration Failed.!!!");

			}
		}
		catch(Exception e)
		{
			System.out.println("Problem During Registration !!!");
			e.printStackTrace();
			
		}

	}

	private static void optionGetStudentDetailsFromCourse()
	{
		RegistrationService service=RegistrationServiceFactory.getRegestrationServiceInstance();
		Scanner sc=new Scanner(System.in);
		
		try
		{
			
			System.out.print("Enter the Course Id to find which Students are registered: ");
			Integer cid=sc.nextInt();
			
			List<Student> list = service.fetchStudent(cid);

			
			if(list == null || list.isEmpty())
			{
			    System.out.println("No students found for this course.");
			}
			else
			{
			    System.out.println("Students registered in this course:");
			    
			    for(Student student : list)
			    {
			        System.out.println("ID: " +student.getRno()+", Name: " + student.getName() +", per: " + student.getPer());
			    }
			}

				
		}
		catch(Exception e)
		{
			System.out.println("Problem during Registration Student for Course.!!!");
		}
	}
	
	private static void optionGetCourseDetailsFromStudent()
	{
		RegistrationService service=RegistrationServiceFactory.getRegestrationServiceInstance();
		Scanner sc=new Scanner(System.in);
		
		try
		{
			
			System.out.print("Enter the Student Id to find which Course are registered: ");
			Integer sid=sc.nextInt();
			
			List<Course> list = service.fetchCourse(sid);

			
			if(list == null || list.isEmpty())
			{
			    System.out.println("No students found for this course.");
			}
			else
			{
			    System.out.println("Students registered in this course:");
			    
			    for(Course course : list)
			    {
			        System.out.println("ID: " +course.getCid()+", Course Name: " + course.getCname() +", Fees: " + course.getCfees());
			    }
			}

				
		}
		catch(Exception e)
		{
			System.out.println("Problem during Registration Student for Course.!!!");
		}
	}


	private static void optionSaveStudent()
	{
		StudentService service=StudentServiceFactory.getStudentServiceInstance();
		Scanner sc=new Scanner(System.in);
		try
		{
			
			System.out.print("Enter the Name       : ");	
			String name=sc.nextLine();
			
			System.out.print("Enter the percentage : ");
			Double per=sc.nextDouble();
			
			sc.nextLine(); //Clear Buffer
			
			System.out.print("Enter the City       : ");
			String city=sc.nextLine();
			
			Student student=new Student();
			student.setName(name);
			student.setPer(per);
			student.setCity(city);
			
			Integer id=service.addStudent(student);
			
			if(id==null)
			{
				System.out.println("Unable to Save Student Records !!");
			}
			else
			{
				System.out.println("Record is Saved Succesfullly !!");
				System.out.println("Resgitered ID : "  + id);
			}
		}
		catch(Exception e)
		{
			System.out.println("Problm During Registering User !!");

		}
	}
	
	private static void optionFetchStudentById()
	{
		Scanner sc=new Scanner(System.in);
		StudentService service=StudentServiceFactory.getStudentServiceInstance();
		
		try
		{
			System.out.print("Enter the Roll Number to Get Data : ");
			Integer rno=sc.nextInt();
			
			Student student=service.fetchStudentById(rno);
			
			if(student==null)
			{
				System.out.println("Record not found for Roll Numebr : " + rno);

			}
			else
			{
				System.out.println("** Record Found ** ");
				System.out.println("----------------------------");
				System.out.println("Roll Number : " + student.getRno());
				System.out.println("Name        : " + student.getName());
				System.out.println("Percentage  : " + student.getPer());
				System.out.println("City        : " + student.getCity());
				System.out.println("");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();

		}
		
	}
	
	private static void optionFetchStudentByName()
	{
		Scanner sc=new Scanner(System.in);
		StudentService service=StudentServiceFactory.getStudentServiceInstance();
		
		try
		{
			System.out.print("Enter the Name to Get Data : ");
			String name=sc.nextLine();
			
			List<Student> studentList=service.fetchStudentByName(name);
			
			if(studentList==null  || studentList.isEmpty())
			{
				System.out.println("Record not found for Name : " + name);

			}
			else
			{
				
				System.out.println("** Record Found ** ");
				System.out.println("----------------------------");
				
				for(Student student : studentList)
				{
				
					System.out.println("Roll Number : " + student.getRno());
					System.out.println("Name        : " + student.getName());
					System.out.println("Percentage  : " + student.getPer());
					System.out.println("City        : " + student.getCity());
					System.out.println("");
				
				}
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();

		}
		
	}
		
		private static void optionFetchStudentByCity()
		{
			Scanner sc=new Scanner(System.in);
			StudentService service=StudentServiceFactory.getStudentServiceInstance();
			
			try
			{
				System.out.print("Enter the City to Get Data : ");
				String city=sc.nextLine();
				
				List<Student> studentList=service.fetchStudentByCity(city);
				
				if(studentList==null  || studentList.isEmpty())
				{
					System.out.println("Record not found for Name : " + city);

				}
				else
				{
					
					System.out.println("** Record Found ** ");
					System.out.println("----------------------------");
					
					for(Student student : studentList)
					{
					
						System.out.println("Roll Number : " + student.getRno());
						System.out.println("Name        : " + student.getName());
						System.out.println("Percentage  : " + student.getPer());
						System.out.println("City        : " + student.getCity());
						System.out.println("");
					
					}
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();

			}
		
		
		}
		
	private static void optionFetchStudentByPer()
	{
		StudentService service=StudentServiceFactory.getStudentServiceInstance();
		Scanner sc=new Scanner(System.in);
		
		try
		{
			Double per;
			//Input Validation
			while(true)
			{
				System.out.print("Enter the percentage to Get Data : ");

				if(sc.hasNextDouble())
				{
					per=sc.nextDouble();
					break;

				}
				else
				{
					System.out.println("Invalid Input! Please enter a numeric percentage.");
	                sc.nextLine(); // clear invalid "AAA" or other text
				}
			}
			
			List<Student> studentList=service.fetchStudentByPer(per);
		
			if(studentList==null  || studentList.isEmpty())
			{
				System.out.println("Record not found for percentage : " + per);

			}
			else
			{
				
				System.out.println("** Record Found ** ");
				System.out.println("----------------------------");
				
				for(Student student : studentList)
				{
				
					System.out.println("Roll Number : " + student.getRno());
					System.out.println("Name        : " + student.getName());
					System.out.println("Percentage  : " + student.getPer());
					System.out.println("City        : " + student.getCity());
					System.out.println("");
				
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	private static void optionFecthAllStudent()
	{
		StudentService service=StudentServiceFactory.getStudentServiceInstance();
		
		try
		{
			List<Student> studentList=service.fetchAllStudent();
			if(studentList==null  || studentList.isEmpty())
			{
				System.out.println("** Record Not Found **");

			}
			else
			{
				
				System.out.println("** Record Found ** ");
				System.out.println("----------------------------");
				
				for(Student student : studentList)
				{
				
					System.out.println("Roll Number : " + student.getRno());
					System.out.println("Name        : " + student.getName());
					System.out.println("Percentage  : " + student.getPer());
					System.out.println("City        : " + student.getCity());
					System.out.println("");
				
				}
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private static void optionUpdateStudent()
	{
		StudentService service = StudentServiceFactory.getStudentServiceInstance();
		Scanner sc = new Scanner(System.in);
		
		try
		{
			System.out.print("Enter Student Id : ");
			int rno = sc.nextInt();
			
			boolean status = service.modifyStudent(rno);
			
			if(status)
			{
				System.out.println("Record is updated Successfully for Roll Number : " +  rno);
			}
			else
			{
				System.out.println("Record not Found for Roll Number : " +  rno);
			}
		}
		catch(Exception e)
		{
			System.out.println("Problem during Update Student !!");
			e.printStackTrace();
			
		}
		
	}
	
	private static void optionDeleteStudent()
	{
		StudentService service = StudentServiceFactory.getStudentServiceInstance();
		Scanner sc = new Scanner(System.in);
		
		try
		{
			System.out.print("Enter Student Id : ");
			int rno = sc.nextInt();
			
			boolean status = service.removeStudent(rno);
			
			if(status)
			{
				System.out.println("Record is Deleted Successfully for Roll Number : " +  rno);
			}
			else
			{
				System.out.println("Record not Found for Roll Number : " +  rno);
			}
		}
		catch(Exception e)
		{
			System.out.println("Problem during Delete Student !!");
			e.printStackTrace();
			
		}
		
	}
	
	private static void optionAddCourse()
	{
		Scanner sc=new Scanner(System.in);
		CourseService service=CourseServiceFactory.getCourseServiceInstance();
		
		try
		{
			System.out.print("Enter the Course Name : ");
			String name=sc.nextLine();
			
			System.out.print("Enter the Course Fees : ");
			Double fees=sc.nextDouble();
			
			Course course=new Course();
			course.setCname(name);
			course.setCfees(fees);
			
			Integer id=service.addCourse(course);
			
			if(id==null)
			{
				System.out.println("Unable to Save Course Information !!");
			}
			else
			{
				System.out.println("Course Information is Saved Succesfullly !!");
				System.out.println("Course ID : "  + id);
			}
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			System.out.println("Problem During Add Course .!!!");
		}
	}
	
	private static void optionFetchAllCourse()
	{
		Scanner sc=new Scanner(System.in);
		CourseService service=CourseServiceFactory.getCourseServiceInstance();
		
		try
		{
			List<Course> courseRecord=service.fetchAllCourse();
			
			if(courseRecord==null)
			{
				System.out.println("Course Record Not Found !!!");
			}
			else
			{
				System.out.println("Course Information");
				System.out.println("----------------------------");
				System.out.println();
				
				for(Course course:courseRecord)
				{
					System.out.println("Course Id   : "+course.getCid());
					System.out.println("Course Name : "+course.getCname());
					System.out.println("Course fees : "+course.getCfees());
					System.out.println();

				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private static void optionFechCourseById()
	{
		Scanner sc=new Scanner(System.in);
		CourseService service=CourseServiceFactory.getCourseServiceInstance();
		
		try
		{
			System.out.print("Enter the Roll Number to Get Data : ");
			Integer rno=sc.nextInt();
			
			Course course=service.fetchCourseById(rno);
			
			if(course==null)
			{
				System.out.println("Course Record Not Found For Id :"+rno);
			}
			else
			{
				System.out.println("Course Information");
				System.out.println("----------------------------");
				
				System.out.println("Course Id   : "+course.getCid());
				System.out.println("Course Name : "+course.getCname());
				System.out.println("Course fees : "+course.getCfees());
				System.out.println();

				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();

		}
		
	}

	private static void optionFetchCourseByName()
	{
		Scanner sc=new Scanner(System.in);
		CourseService service=CourseServiceFactory.getCourseServiceInstance();
		
		try
		{
			System.out.print("Enter the Course name to get the Data : ");
			String name=sc.nextLine();
			
			List<Course> courseRecord=service.fetchCourseByName(name);
			
			if(courseRecord==null || courseRecord.isEmpty())
			{
				System.out.println("Course Record Not Found !!!");
			}
			else
			{
				System.out.println("Course Information");
				System.out.println("----------------------------");
				System.out.println();
				
				for(Course course:courseRecord)
				{
					System.out.println("Course Id   : "+course.getCid());
					System.out.println("Course Name : "+course.getCname());
					System.out.println("Course fees : "+course.getCfees());
					System.out.println();

				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	private static void optionModifyCourse()
	{
		Scanner sc=new Scanner(System.in);
		CourseService service=CourseServiceFactory.getCourseServiceInstance();
		
		try
		{
			System.out.println("Enter the Course id to Modify Details : ");
			Integer id=sc.nextInt();
			
			if(service.modifyCourseDetails(id))
			{
				System.out.println("Course Information Updated Successfully.!!!");
			}
			else
			{
				System.out.println("Unalbe to Updete Course Information !!!");

			}
		}
		catch(Exception e)
		{
			System.out.println("Problem During Update the Course.!!!");
		}
	}
	
	
	
	private static void optionDeleteCourse()
	{
		Scanner sc=new Scanner(System.in);
		CourseService service=CourseServiceFactory.getCourseServiceInstance();
		
		try
		{
			System.out.print("Enter Course Id : ");
			int rno = sc.nextInt();
			
			boolean status = service.DeleteCourseDetails(rno);
			
			if(status)
			{
				System.out.println("Course is Deleted Successfully for Course Number : " +  rno);
			}
			else
			{
				System.out.println("Course Information not Found for Course Number : " +  rno);
			}
		}
		catch(Exception e)
		{
			System.out.println("Problem during DeleteCourse !!");
			e.printStackTrace();
			
		}
		
	}

}
