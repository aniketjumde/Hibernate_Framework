package com.tca;

import java.util.List;
import java.util.Scanner;

import com.tca.entity.Student;
import com.tca.factory.StudentServiceFactory;
import com.tca.service.StudentService;
import com.tca.util.HibernateUtil;

public class SMSController 
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);
		System.out.println("\n************** Welcome to Student Management Application ************ \n");

		
		try
		{
			while(true)
			{
				System.out.println("Menu");
				 
	    		System.out.println("1. Save ");
	    		System.out.println("2. Fetch By Id ");
	    		System.out.println("3. Fetch By name ");
	    		System.out.println("4. Fetch By city ");
	    		System.out.println("5. Update ");
	    		System.out.println("6. Delete ");
	    		System.out.println("7. All Student ");
	    		System.out.println("8. Exit ");
	    		
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
							
					case 8 :
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
	
	private static void While(boolean b) {
		// TODO Auto-generated method stub
		
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


}
