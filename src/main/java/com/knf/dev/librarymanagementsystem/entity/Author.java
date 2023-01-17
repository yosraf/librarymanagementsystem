package com.knf.dev.librarymanagementsystem.entity;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Data
@Table(name = "authors")
public class Author {

	@Id
	@SequenceGenerator(
			name = "id_seq",
			sequenceName = "id_seq")
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "id_seq")
	private Long id;

	@Column(name = "name", length = 100, nullable = false, unique = true)
	private String name;

	@Column(name = "description", length = 250, nullable = false)
	private String description;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE }, mappedBy = "authors")
	private Set<Book> books = new HashSet<Book>();
}
