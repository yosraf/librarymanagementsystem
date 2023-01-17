package com.knf.dev.librarymanagementsystem.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "roles")
public class Role {

    @Id
    @SequenceGenerator(
            name = "id_seq",
            sequenceName = "id_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_seq")
    private Long id;
    private String name;
}