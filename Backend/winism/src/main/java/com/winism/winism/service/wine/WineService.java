package com.winism.winism.service.wine;

import java.util.List;

import com.winism.winism.dao.wine.WineDAO;
import com.winism.winism.model.wine.wineList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WineService {
    @Autowired
    WineDAO winedao;

    public wineList getbyid(int wid){
        return winedao.findByWid(wid);
    }

    public List<wineList> findTop10ByEnnameLike(String keyword){
        return winedao.findTop10ByENNAMELike(keyword);
    }

    public List<wineList> findall(){
        return winedao.findAll();
    }

    public void update(wineList wl){
        winedao.save(wl);
    }
}
