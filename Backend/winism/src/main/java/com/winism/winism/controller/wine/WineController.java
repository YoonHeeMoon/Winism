package com.winism.winism.controller.wine;

import java.util.ArrayList;
import java.util.List;

import com.winism.winism.model.wine.wineList;
import com.winism.winism.service.wine.WineService;
import com.winism.winism.util.UnicodeHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "*" })
@RestController
public class WineController {

    @Autowired
    WineService wineservice;

    @Autowired
    UnicodeHandler uh;

    @PostMapping("/search/detail")
    public ResponseEntity<wineList> remove(int wid){
        return new ResponseEntity<>(wineservice.getbyid(wid), HttpStatus.OK);
    }

    @PostMapping("/search/auto")
    public ResponseEntity<List<wineList>> auto(String keyword){
        keyword += "%";
        List<wineList> result = new ArrayList<>();
        if (keyword.charAt(0)>='가' && keyword.charAt(0)<='힣'){
            System.out.println("한글");
            keyword = uh.splitHangeulToConsonant(keyword) + "%";
            System.out.println(keyword);
        }
        else{
            result = wineservice.findTop10ByEnnameLike(keyword);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/search/test")
    public void test(){
        List<wineList> list = wineservice.findall();

        for(wineList wine : list){
            System.out.println(wine);
        }
    }



}
