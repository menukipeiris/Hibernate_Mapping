package org.example;


import config.FactoryConfiguration;
import entity.Laptop;
import entity.Student;
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
        laptop.setLid(2);
        laptop.setModel("dell");

        List<Laptop> laptopList=new ArrayList<>();
        laptopList.add(laptop);
        laptopList.add(laptop1);

        Student student=new Student();
        student.setId(1);
        student.setName("menuki");
        student.setAddress("homagama");
        student.setLaptops(laptopList);

        laptop.setStudent(student);
        laptop1.setStudent(student);


        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction =session.beginTransaction();

        session.save(laptop);
        session.save(laptop1);
        session.save(student);


        transaction.commit();
        session.close();

    }
}