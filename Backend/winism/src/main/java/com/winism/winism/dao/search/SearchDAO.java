package com.winism.winism.dao.search;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.winism.winism.model.wine.wineList;


public interface SearchDAO extends JpaRepository<wineList, String> {
	Page<wineList> findAll(Pageable pageable);

	Page<wineList> findByKONAMEContainingOrENNAMEContaining(Pageable pageable,String koname,String enname);
	Page<wineList> findByTYPEAndPrice(Pageable pageable,String type,String price);

}