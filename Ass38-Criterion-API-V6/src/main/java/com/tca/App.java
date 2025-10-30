package com.tca;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entity.Student;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.Root;

public class App 
{
    public static void main(String[] args) 
    {
        Configuration configuration=null;
        SessionFactory sessionFactory=null;
        Session session=null;
        Transaction transaction=null;
        
        try
        {
        	configuration=new Configuration();
        	configuration.configure();
        	
        	sessionFactory=configuration.buildSessionFactory();
        	session=sessionFactory.openSession();
        	transaction=session.beginTransaction();
        	
        	/*
        	//SELECT * FROM Student
        	
        	CriteriaBuilder cb=session.getCriteriaBuilder();
        	
        	CriteriaQuery<Student> cq=cb.createQuery(Student.class);
        	Root<Student> root=cq.from(Student.class);
        	cq.select(root);
        	
        	Query<Student> query =session.createQuery(cq);
    		
    		List<Student> L =  query.list();
    		
    		for(Student S : L)
    		{
    			System.out.println(S.getRno() + " " + S.getName() + " " + S.getPer() + " " + S.getCity());
    		}
        	
        	*/
        	
        	/*
    		// select * from student order by per desc 

        	CriteriaBuilder cb=session.getCriteriaBuilder();
        	
        	CriteriaQuery<Student> cq=cb.createQuery(Student.class);
        	Root<Student> root=cq.from(Student.class);
        	cq.select(root);
        	
        	cq.select(root).orderBy(cb.desc(root.get("per")));
    		
    		
    		Query<Student> query =session.createQuery(cq);
    		
    		List<Student> L = query.list();
    		
    		for(Student S : L)
    		{
    			System.out.println(S.getRno() + " " + S.getName() + " " + S.getPer() + " " + S.getCity());
    		}
    		
    		*/
        	
        	/*
    		// select * from student where per>=70 and per<=90
    		
    		CriteriaBuilder cb = session.getCriteriaBuilder(); 
    		
    		CriteriaQuery<Student> cq = cb.createQuery(Student.class);
    		Root<Student> root = cq.from(Student.class);
    		
    		Predicate p1 = cb.greaterThanOrEqualTo(root.get("per") , 70.0);
    		Predicate p2 = cb.lessThanOrEqualTo(root.get("per"), 90.0);
    		
    		cq.select(root).where(cb.and(p1,p2));
    		
    		Query<Student> query =session.createQuery(cq);
    		
    		List<Student> L = query.list();
    		
    		for(Student S : L)
    		{
    			System.out.println(S.getRno() + " " + S.getName() + " " + S.getPer() + " " + S.getCity());
    		}
*/
    		
        	/*
        	
    		// Specific Column - select name,city,per from student;
    		// Tuple (stud_name:AAA, city:PUNE, per:70), (BBB,BANGLORE,90)
    		
    		CriteriaBuilder cb = session.getCriteriaBuilder();
    		CriteriaQuery<Tuple> cq = cb.createTupleQuery();
    		
    		Root<Student> root = cq.from(Student.class);
    		
    		cq.multiselect(root.get("name").alias("stud_name"), root.get("city").alias("city"), root.get("per").alias("per"));
    		
    		Query<Tuple> query = session.createQuery(cq);
    		
    		List<Tuple> result =query.getResultList();
    		
    		for(Tuple t : result)
    		{
    			System.out.println(t.get("stud_name") + " " + t.get("city") + " " + t.get("per") );
    		}
    		
        	*/
        	
        	
        	/*
        	// Select * from student where city like 'P%';
        	
        	CriteriaBuilder cb=session.getCriteriaBuilder();
        	
        	CriteriaQuery<Student> cq=cb.createQuery(Student.class);
        	Root<Student> root=cq.from(Student.class);
        	cq.select(root)
        	  .where(cb.like(root.get("city"),"P%"));
        	
        	
        	//Query<Student> query=session.createQuery(cq);
        	//List<Student> L=query.list();
        	
        	List<Student> L=session.createQuery(cq)
        							.list();
        	
        	for(Student S:L)
        	{
    			System.out.println(S.getRno() + " " + S.getName() + " " + S.getPer() + " " + S.getCity());

        	}
        	
        	*/
        	
        	
        	/*
    		// Select max(per) from student;

        	CriteriaBuilder cb=session.getCriteriaBuilder();
        	
        	CriteriaQuery<Double> cq=cb.createQuery(Double.class);
        	Root<Student> root=cq.from(Student.class);
        	
        	cq.select(cb.max(root.get("per")));
        	
        	Query<Double> query = session.createQuery(cq);
    		
    		Double ans = query.getSingleResult();
    		
    		System.out.println("Maximum Percentage : " +  ans);
        	*/
        	
        	/*
        	
    		// Select city, count() from student group by city having count()>=2;

        	CriteriaBuilder cb=session.getCriteriaBuilder();
        	
        	CriteriaQuery<Object[]> cq=cb.createQuery(Object[].class);
        	Root<Student> root=cq.from(Student.class);
        	
    		Expression exp=(Expression) cb.count(root);
        	
    		cq.multiselect(root.get("city"), exp );
    		cq.groupBy(root.get("city"));
    		cq.having(cb.ge(exp,1));
    		
    		
    		Query<Object[]> query = session.createQuery(cq);
    		
    		List<Object[]> list = query.getResultList();
    		
    		for(Object[] row : list)
    		{
    			System.out.println(row[0] + " -->" + row[1]);
    		}
        			
        	*/
        	
        	/*
        	
        	//Update Student set city='Poona' Where city='PUNE'
        	
        	CriteriaBuilder cb=session.getCriteriaBuilder();
        	CriteriaUpdate cu=cb.createCriteriaUpdate(Student.class);
        	
        	Root<Student> root=cu.from(Student.class);
        	
        	cu.set("city","POONA");
        	cu.where(cb.equal(root.get("city"),"PUNE"));
        	
        	MutationQuery query=session.createMutationQuery(cu);
        	
        	int rowcount=query.executeUpdate();
        	
        	System.out.println("No.of.rows.Modified :"+rowcount);
        	
        	*/
        	
        	
        	// DELETE FROM Student WHERE rno=1;
        	
        	CriteriaBuilder cb=session.getCriteriaBuilder();
        	CriteriaDelete cd=cb.createCriteriaDelete(Student.class);
        	
        	Root<Student> root=cd.from(Student.class);
        	cd.where(cb.equal(root.get("rno"), 109));
        	
        	int rowCount=session.createMutationQuery(cd).executeUpdate();
        	
        	System.out.println("No.of.rows.Remove :"+rowCount);

        	
        	transaction.commit();
        	System.out.println("Work is Done.!!!");
		}
		catch(Exception e)
		{
			if(transaction!=null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
        finally
        {
        	session.close();
			sessionFactory.close();
			
		}
    }
}
