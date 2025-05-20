package oneToOne;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "STUDENT01")
public class Student {

    @Id
    private Long id;

    @Column(name = "STUDENT_NUMBER")
    private Integer number;

    @Column(name = "STUDENT_NAME")
    private String name;

    @OneToOne
    private Computer computer;

    public Student(Long id, Integer number, String name) {
        this.id = id;
        this.number = number;
        this.name = name;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", computer=" + computer +
                '}';
    }
}
