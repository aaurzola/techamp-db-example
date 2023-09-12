package org.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Book")
public class Libro {
    @Id
    @Column(name = "title")
    private String titulo;

    @Column(name = "author")
    private String autor;

    @Column(name = "notes")
    private String notas;
}
