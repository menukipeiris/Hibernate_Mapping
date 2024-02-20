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

        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();


        Student student=session.get(Student.class,1);

        List<Laptop>laptopList=student.getLaptops();
        for (Laptop laptop:laptopList){
            System.out.println(laptop.getModel());
        }

        transaction.commit();
        session.close();

    }
}