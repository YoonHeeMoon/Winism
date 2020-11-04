package com.winism.winism.controller.favoritelist;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.winism.winism.dao.search.SearchDAO;
import com.winism.winism.model.favoritelist.FavoritelistEntity;
import com.winism.winism.model.wine.wineList;
import com.winism.winism.service.favoritelist.FavoritelistService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "*" },maxAge = 6000)

@RestController
public class FavoritelistController {
    @Autowired
    FavoritelistService flservice;

  

    @PostMapping("/favorite/add")
    public ResponseEntity<String> add(FavoritelistEntity fl){
        System.out.println("1");
        ArrayList<wineList> ar =  (ArrayList)flservice.findByUid(fl.getUid()).get("list");
        System.out.println("1");
        boolean flag = false;

        if(!ar.isEmpty()){
            System.out.println("1");
            for(wineList arunit : ar){
                System.out.println("들어감");
                if(arunit.getWid() == fl.getWid()){
                    flag = true;
                    break;
                }
            }
            if(flag){
                return new ResponseEntity<>("fail", HttpStatus.OK);
            }
            else{
                flservice.add(fl);
                return new ResponseEntity<>("success", HttpStatus.OK);
            }
        }
        else{
            flservice.add(fl);
            return new ResponseEntity<>("success", HttpStatus.OK);
        }
    }

    @PostMapping("/favorite/remove")
    public ResponseEntity<String> remove(FavoritelistEntity fl){
        flservice.remove(fl);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
    
    
    @PostMapping("/favorite/getbyid")
    public ResponseEntity<HashMap<String,Object>  > getbyid(String uid){
        return new ResponseEntity<>(flservice.findByUid(uid), HttpStatus.OK);
    }

    





}
