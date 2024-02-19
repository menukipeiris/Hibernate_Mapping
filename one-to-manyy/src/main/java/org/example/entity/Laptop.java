package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity

public class Laptop {
    @Id
    private int lid;
    private String model;

    @ManyToOne
    private Student student;


    public Laptop(){}

    public Laptop(int lid, String model, Student student) {
        this.lid = lid;
        this.model = model;
        this.student = student;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getLid() {
        return lid;
    }

    public String getModel() {
        return model;
    }

    public Student getStudent() {
        return student;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lid=" + lid +
                ", model='" + model + '\'' +
                ", student=" + student +
                '}';
    }
}
