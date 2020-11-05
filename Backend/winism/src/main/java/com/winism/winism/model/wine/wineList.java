package com.winism.winism.model.wine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="wine2")
public class wineList{

    @Id
    @Column(name="wid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int wid;

    @Column(name = "KONAME")
    private String KONAME;
    
    @Column(name = "ENNAME")
    private String ENNAME;

    @Column(name = "KOMAKER")
    private String KOMAKER;

    @Column(name = "ENMAKER")
    private String ENMAKER;

    @Column(name = "LOCAL")
    private String LOCAL;


    @Column(name = "SWEETNESS")
    private String SWEETNESS;

    @Column(name = "ACIDITY")
    private String ACIDITY;

    @Column(name = "BODY")
    private String BODY;

    @Column(name = "TANNIN")
    private String TANNIN;

    @Column(name = "LAESTDEGREE")
    private String LAESTDEGREE;

    @Column(name = "\"USE\"")
    private String USE;

    @Column(name = "RECOMMANDATION")
    private String RECOMMANDATION;

    @Column(name = "GRAPE")
    private String GRAPE;

    @Column(name = "TEMPERATURE")
    private String TEMPERATURE;
    
    @Column(name = "CAPACITY")
    private String CAPACITY;

    @Column(name = "GRADE")
    private String GRADE;
    
    @Column(name = "TYPE")
    private String TYPE;

    @Column(name = "COST")
    private String COST;

    @Column(name = "\"YEAR\"")
    private String YEAR;
    

    @Column(name = "SPLITNAME")
    private String SPLITNAME;

}