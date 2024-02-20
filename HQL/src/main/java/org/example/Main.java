package org.example;

import org.example.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();



      /*  Query query=session.createQuery("insert into Student v")

        List<Student> studentList=query.list();
        for (Student s:studentList){
            System.out.println(s.getId());

        }*/

       /* Query query1=session.createQuery("from Student where name=?1");
        query1.setParameter(1,"Menuki");
        Student student= (Student) query1.uniqueResult();
        System.out.println(student.getName());
        transaction.commit();
        session.close();*/

      /*  Query query=session.createQuery("select id,name from Student where id=?1");
        query.setParameter(1,1);
        Object[]objects= (Object[]) query.uniqueResult();
        System.out.println(objects[0]);*/

        Query query=session.createQuery("select id,name from  Student ");
        List<Object[]>list=query.list();

        transaction.commit();
        session.close();

    }
}