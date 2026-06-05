package entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "rollnumber", length = 50)
    private String rollnumber;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "age")
    private int age;

    public Student() {}

    public Student(String rollnumber, String name, String email, int age) {
        this.rollnumber = rollnumber;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    // Getters and Setters
    public String getRollnumber() { return rollnumber; }
    public void setRollnumber(String rollnumber) { this.rollnumber = rollnumber; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}
