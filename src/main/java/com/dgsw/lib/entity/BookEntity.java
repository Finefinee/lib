package com.dgsw.lib.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="books")
public class BookEntity {
    @Id
    private String bookID;
    private String bookName;
    private String author;
    private Boolean isLoaned;
}
