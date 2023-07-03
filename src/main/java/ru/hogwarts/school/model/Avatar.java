package ru.hogwarts.school.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Entity
@Table(name = "Avatar")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Avatar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "filePath", nullable = false)
    private String filePath;
    @Column(name = "fileSize", nullable = false)
    private long fileSize;
    @Column(name = "mediaType", nullable = false)
    private String mediaType;

    @Lob
    private byte[] data;

    @OneToOne
    private Student student;


}
