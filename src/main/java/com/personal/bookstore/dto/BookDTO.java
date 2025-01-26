package com.personal.bookstore.dto;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@Getter
@Setter
@Entity
public class BookDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String title;
    private String description;
    private String kind;
    private String ageGroup;
    private Double price;
    private String author;

    public BookDTO(){

    }

    public BookDTO(String title, String description, String kind, String ageGroup, Double price, String author) {
        this.title = title;
        this.description = description;
        this.kind = kind;
        this.ageGroup = ageGroup;
        this.price = price;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static class Builder {

        private String title;

        private String description;
        private String kind;
        private String ageGroup;
        private Double price;
        private String author;

        public Builder (String title){
            this.title = title;
        }

        public BookDTO build(){
            return new BookDTO(title, description, kind, ageGroup, price, author);
        }

    }
}
