package com.mov.cat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mov.cat.entity.MovieInfo;
import com.mov.cat.repository.MovieCatalogRepository;

//import com.mov.cat.entity.MovieInfo;
//import com.mov.cat.repository.MovieCatalogRepository;


@RestController
public class MovieCatalogController {
	
	@Autowired
	public MovieCatalogRepository movieCatalogRepository;
	
	@PostMapping("/movie-info/save/moviecatalog")
	public String saveMovieCatalog(@RequestBody List<MovieInfo> movieInfo) {
		movieCatalogRepository.saveAll(movieInfo);
		return "saved successfully";		
	}
	
	@GetMapping("/movie-info/list")
    public List<MovieInfo> getAll() {
		//movieCatalogRepository.findAll().size();
        return movieCatalogRepository.findAll();
    }

    @GetMapping("/movie-info/find-path-by-id/{movieInfoId}")
    public String findPathById(@PathVariable Long movieInfoId) {
        var videoInfoOptional = movieCatalogRepository.findById(movieInfoId);
        return videoInfoOptional.map(MovieInfo::getPath).orElse(null);
    }

}
