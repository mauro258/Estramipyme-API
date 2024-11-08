package com.estramipyme.estramipyme_API.models;

import jakarta.persistence.*;
import lombok.Data;
import org.w3c.dom.Text;

@Entity
@Table
@Data
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTest;
    private String name_Test;
    @Lob //indica que description es un tipo de datos de Hibernate para texto, permite almacenar texto de gran tamaño
    private String description;
}
