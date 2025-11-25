package com.tca.service;

import java.util.List;
import java.util.Scanner;

import com.tca.dao.StudentDao;
import com.tca.entity.Student;
import com.tca.factory.StudentDaoFactory;

public class StudentServiceImpl implements StudentService
{

	@Override
	public Integer addStudent(Student student) 
	{
		StudentDao studentDao=StudentDaoFactory.getStudentDaoInstance();
		
		student.setName(student.getName().toLowerCase());
		student.setCity(student.getCity().toLowerCase());
		
		/*
		Integr id=studentDao.saveStudent(student);
		return  id
		*/		
		return studentDao.saveStudent(student);
	}

	@Override
	public Student fetchStudentById(Integer Id) 
	{
		
		StudentDao studentDao=StudentDaoFactory.getStudentDaoInstance();
		
		Student student=studentDao.findStudentById(Id);
		return student;
	}

	@Override
	public List<Student> fetchStudentByName(String name) 
	{
		StudentDao studentDao=StudentDaoFactory.getStudentDaoInstance();
		
		List<Student> student=studentDao.findStudentByName(name.toLowerCase());
		
		return student;
	}

	@Override
	public List<Student> fetchStudentByCity(String city) 
	{
		StudentDao studentDao=StudentDaoFactory.getStudentDaoInstance();
		
		
		return studentDao.findStudentByCity(city.toLowerCase());
	}

	@Override
	public List<Student> fetchStudentByPer(Double per) 
    {
		StudentDao studentDao=StudentDaoFactory.getStudentDaoInstance();

		
		return studentDao.findStudentByPer(per);
	}

	@Override
	public List<Student> fetchAllStudent() 
	{
		StudentDao studentDao=StudentDaoFactory.getStudentDaoInstance();

		return studentDao.fetchAllStudent();
	}

	@Override
	public boolean modifyStudent(Integer Id) 
	{
		StudentDao studentDao=StudentDaoFactory.getStudentDaoInstance();
		
		Student student=studentDao.findStudentById(Id);// get Student Object
		
		if(student==null )
		{
			return false;
		}
		else
		{
			Scanner sc = new Scanner(System.in);
			
			String updatedName="";
			
			while(true)
			{
				System.out.print("[ Old Name : " + student.getName() +"] Enter New Name : ");
				updatedName = sc.nextLine().toLowerCase();
			
				if(updatedName.isBlank()) 
				{
					System.out.println("*** Name should not be blank ! ");
					continue;
				}
				else
					break;
			}
			
			System.out.print("[ Old City  : " + student.getCity() + "] Enter New City :");
			String updatedCity = sc.nextLine().toLowerCase();
			
			System.out.print("[ Percentage: "+ student.getPer() + "] Enter New Percentage : ");
			double updatedPer = sc.nextDouble();
			
			student.setName(updatedName);
			student.setCity(updatedCity);
			student.setPer(updatedPer);
			
			boolean status = studentDao.updateStudent(student);
					
			return status;
		
		}
	}

	@Override
	public boolean removeStudent(Integer Id) 
	{
		StudentDao studentDao=StudentDaoFactory.getStudentDaoInstance();
		Student student=studentDao.findStudentById(Id);

		if(student==null)
		{
			return false;
		}
		else
		{
			boolean status=studentDao.deleteStudent(student);
			return status;
		}
		
	}

}
