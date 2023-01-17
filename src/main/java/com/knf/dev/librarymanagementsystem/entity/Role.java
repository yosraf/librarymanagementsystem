package com.knf.dev.librarymanagementsystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @SequenceGenerator(
            name = "id_seq",
            sequenceName = "id_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_seq")
    private Long id;
    private String name;

    public Role() {

    }

    public Role(String name) {
        super();
        this.name = name;
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

    public void setName(String name) {
        this.name = name;
    }
}