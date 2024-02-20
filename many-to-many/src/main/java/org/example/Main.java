package org.example;


import org.example.config.FactoryConfiguration;
import org.example.entity.Laptop;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Laptop laptop=new Laptop();
        laptop.setLid(1);
        laptop.setModel("hp");

        Laptop laptop1=new Laptop();
        laptop1.setLid(2);
        laptop1.setModel("dell");

        List<Laptop>laptopList=new ArrayList<>();
        laptopList.add(laptop);
        laptopList.add(laptop1);

        Student student=new Student();
        student.setId(1);
        student.setName("menuki");
        student.setAddress("colombo");

        Student student1=new Student();
        student1.setId(2);
        student1.setName("aloka");
        student1.setAddress("colombo");

        List<Student>studentList=new ArrayList<>();
        studentList.add(student);
        studentList.add(student1);

        student.setLaptops(laptopList);
        student1.setLaptops(laptopList);

        laptop.setStudents(studentList);
        laptop1.setStudents(studentList);



        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        session.save(student);
        session.save(student1);
        session.save(laptop);
        session.save(laptop1);

        transaction.commit();
        session.close();
    }
}