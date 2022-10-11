package com.jpabook.jpashop.domain.item;

import lombok.ToString;

import javax.persistence.*;

@Entity
@DiscriminatorValue("B")
@ToString
public class Book extends Item {

    private String author;

    private String isbn;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
