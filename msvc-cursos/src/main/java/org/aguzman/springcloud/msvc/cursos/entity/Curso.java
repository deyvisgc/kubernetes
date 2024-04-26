package org.aguzman.springcloud.msvc.cursos.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cursos")

public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCurso")
    @SequenceGenerator(name = "seqCurso", allocationSize = 1, sequenceName = "SEQ_CURSO")
    private Long id;
    @NotEmpty
    @Column(unique = true)
    private String nombre;
}
