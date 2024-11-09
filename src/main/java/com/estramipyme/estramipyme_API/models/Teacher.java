package com.estramipyme.estramipyme_API.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="teachers")
@Data

public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private  String name;
    private  String surname;
    private String email;
    private  String telephone;
    private String password;
    /*
    @ManyToOne(optional = false)
    @joinColumn(name="company_id")
    private Company company;

    @ManyToOne(optional = false)
    @joinColumn(name="type_user")
    private Type_User;

     */
}
