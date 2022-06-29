package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "STUDENT")
public class Student {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(nullable = false)
    Date birthday;

    @Column(name = "class_name", nullable = false)
    String className;

    @Column(nullable = false)
    String major;

    @Column(nullable = false)
    String gender;

    @Column(name = "average_mark",nullable = false)
    String averageMark ;

}
