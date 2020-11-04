package com.winism.winism.model.favoritelist;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.winism.winism.model.wine.wineList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "favoritelist")
public class FavoritelistEntity {

    @Id
    @Column(name="fid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int fid;

    @Column(name="wid")
    int wid;

    @Column(name="uid")
    String uid;

}




