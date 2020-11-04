package com.winism.winism.dao.favoritelist;

import java.util.List;

import com.winism.winism.model.favoritelist.FavoritelistEntity;


import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritelistDAO  extends JpaRepository<FavoritelistEntity, Long>{
    public List<FavoritelistEntity> findByUid(String uid);
}
