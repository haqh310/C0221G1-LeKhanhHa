package com.codegym.model.entity;

import javax.persistence.*;

@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String score;
    private String author;
    private String feedback;
    @Column(name = "date", columnDefinition = "DATE")
    private String date;
    private int likes;

    public Comment() {
    }

    public Comment(int id, String score, String author, String feedback, String date,int likes) {
        this.id = id;
        this.score = score;
        this.author = author;
        this.feedback = feedback;
        this.date = date;
        this.likes = likes;
    }

    public Comment(String score, String author, String feedback) {
        this.score = score;
        this.author = author;
        this.feedback = feedback;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
