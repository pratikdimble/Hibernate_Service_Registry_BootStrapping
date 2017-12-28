package com.pratik.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pratik.entity.EmpDetails;
import com.pratik.utility.HibernateUtil;

public class TestClient_Save {

	public static void main(String[] args) {
		Session ses=null;
		boolean flag=false;
		Transaction tx=null;
		EmpDetails details=null;
		int idVal=0;
		//get Session 
		ses=HibernateUtil.getSession();
		
		try{
		  tx=ses.beginTransaction();
		  //create domain class obj
		    details=new EmpDetails();
		    details.setNo(1008);
		    details.setFname("Pratik");
		    details.setLname("Dimble");
		    details.setMail("pd@gmail.com");
		    //save object
		    idVal=(int)ses.save(details);
		    System.out.println("Generated id value::"+idVal);
		  flag=true;
		}
		catch(HibernateException he){
			he.printStackTrace();
			flag=false;
		}
		catch(Exception e){
			e.printStackTrace();
			flag=false;
		}
		finally{
			if(flag==true){
				tx.commit();
				System.out.println("Object saved");
			}
			else{
				tx.rollback();
				System.out.println("Object not saved");
			}
			
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
