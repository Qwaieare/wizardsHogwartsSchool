package ru.hogwarts.school.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

// Класс является сущностью
@Entity
@Table(name="Faculty")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Faculty {
    // Поле первичного ключа
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String  name;

    @Column(name = "color", nullable = false)
    private String color;

    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL)
    private List<Student> students;


}
