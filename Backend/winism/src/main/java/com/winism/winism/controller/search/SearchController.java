package com.winism.winism.controller.search;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.security.auth.kerberos.KeyTab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.winism.winism.dao.search.SearchDAO;
import com.winism.winism.model.wine.wineList;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javassist.compiler.ast.Keyword;

import com.winism.winism.model.BasicResponse;

@ApiResponses(value = {
    @ApiResponse(
        code = 401,
        message = "Unauthorized",
        response = BasicResponse.class
    ),
    @ApiResponse(code = 403, message = "Forbidden", response = BasicResponse.class),
    @ApiResponse(code = 404, message = "Not Found", response = BasicResponse.class),
    @ApiResponse(code = 500, message = "Failure", response = BasicResponse.class)
})

@CrossOrigin(origins = { "*" })
@RestController
public class SearchController {

	@Autowired
	SearchDAO searchDao;

	@GetMapping("/search")
    @ApiOperation(value = "게시글 리스트 불러오기")
    public Object listWine(
        @RequestParam(required = false)final String page,
        @RequestParam(required = false)final String keyword
    )throws IOException {
        //pagination
		int pageInt=0;
		if(page != null){
			pageInt = Integer.parseInt(page);
        }
        Pageable pageable = PageRequest.of(pageInt,10);
        
        Page<wineList> list = null;
        if(keyword == null){
            list = searchDao.findAll(pageable);
        }else{
            list = searchDao.findByKONAMEContainingOrENNAMEContaining(pageable,keyword,keyword);
        }
        
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // @PostMapping("/search")
    // @ApiOperation(value = "고급 검색")
    // public Object advancedSearch (
    //     @RequestParam(required = false)final String page,
    //     @RequestParam(required = false)final String keyword,
    //     @RequestParam(required = false)final String type,
    //     @RequestParam(required = false)final String price,
    //     @RequestParam(required = false)final String sweetness,
    //     @RequestParam(required = false)final String acidity,
    //     @RequestParam(required = false)final String tannin,
    //     @RequestParam(required = false)final String body
    // )throws IOException {
    //     //pagination
	// 	int pageInt=0;
	// 	if(page != null){
	// 		pageInt = Integer.parseInt(page);
    //     }
    //     Pageable pageable = PageRequest.of(pageInt,10);
    //     String[] s = new String[8];
    //     if(keyword==null){
    //         s[0]="%%";
    //     }
    //     if(type==null){
    //         s[1]="%%";
    //     }
    //     if(price==null){
    //         s[2]="%%";
    //     }
    //     if(sweetness==null){
    //         s[3]="%%";
    //     }
    //     if(acidity==null){
    //         s[4]="%%";
    //     }
    //     if(tannin==null){
    //         s[5]="%%";
    //     }
    //     if(body==null){
    //         s[6]="%%";
    //     }

        
    //     Page<wineList> list = searchDao.findByKONAMEContainingOrENNAMEContaining(pageable,keyword,keyword);
        
    //     return new ResponseEntity<>(list, HttpStatus.OK);
    // }




}