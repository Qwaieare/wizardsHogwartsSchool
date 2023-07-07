package ru.hogwarts.school.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

// Класс является сущностью
// В БД отображается в таблицу с именем students
@Entity
@Table(name = "Student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    // Поле первичного ключа
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "age", nullable = false)
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id", insertable = false, updatable = false, nullable = false)
    private Faculty faculty;

    @OneToOne
    @JoinColumn(name = "avatar_id")
    private Avatar avatar;


}
