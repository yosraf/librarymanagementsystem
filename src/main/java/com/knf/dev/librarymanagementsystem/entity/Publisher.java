package com.knf.dev.librarymanagementsystem.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "publishers")
public class Publisher {

    @Id
    @SequenceGenerator(
            name = "id_seq",
            sequenceName = "id_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_seq")
    private Long id;

    @Column(name = "name", length = 100, nullable = false, unique = true)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "publishers")
    private Set<Book> books = new HashSet<Book>();
}
