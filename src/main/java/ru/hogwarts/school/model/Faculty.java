package ru.hogwarts.school.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

// Класс является сущностью
@Entity
@Table(name="Faculty")
@NoArgsConstructor
public class Faculty {
    // Поле первичного ключа
    @Id
    @GeneratedValue  // Автоинкремент
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String  name;

    @Column(name = "color", nullable = false)
    private String color;

    public Faculty(Long id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor() {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(id, faculty.id) && Objects.equals(name, faculty.name) && Objects.equals(color, faculty.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, color);
    }
}
