package com.winism.winism.model.review;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "review")
public class ReviewEntity {

    @Id
    @Column(name="rid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int rid;

    @Column(name="title")
    String title;

    @Column(name="rating")
    String rating;
    
    @Column(name="date")
    String date;

    @Column(name="userid")
    String userid;

    @Column(name="content")
    String content;

    @Column(name="winename")
    String winename;

    @Column(name = "wid")
    int wid;

}
