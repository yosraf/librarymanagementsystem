package com.knf.dev.librarymanagementsystem.entity;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Data
@Table(name = "books")
public class Book {

	@Id
	@SequenceGenerator(
			name = "id_seq",
			sequenceName = "id_seq")
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "id_seq")	private Long id;

	@Column(name = "isbn", length = 50, nullable = false, unique = true)
	private String isbn;

	@Column(name = "name", length = 100, nullable = false)
	private String name;

	@Column(name = "serialName", length = 50, nullable = false)
	private String serialName;

	@Column(name = "description", length = 250, nullable = false)
	private String description;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	@JoinTable(name = "books_authors", joinColumns = { @JoinColumn(name = "book_id") }, inverseJoinColumns = {
			@JoinColumn(name = "author_id") })
	private Set<Author> authors = new HashSet<Author>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "books_categories", joinColumns = { @JoinColumn(name = "book_id") }, inverseJoinColumns = {
			@JoinColumn(name = "category_id") })
	private Set<Category> categories = new HashSet<Category>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "books_publishers", joinColumns = { @JoinColumn(name = "book_id") }, inverseJoinColumns = {
			@JoinColumn(name = "publisher_id") })
	private Set<Publisher> publishers = new HashSet<Publisher>();
}
