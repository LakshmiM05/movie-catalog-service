package com.mov.cat.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mov.cat.entity.MovieInfo;

@Repository
public interface MovieCatalogRepository extends JpaRepository<MovieInfo, Long> {
 
	//MovieInfo save(List<MovieInfo> movieInfoList);
}
