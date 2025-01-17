package com.raghugannaram.reelvault.repository;

import com.raghugannaram.reelvault.model.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MovieRepository extends JpaRepository<MovieModel, Long> {
    List<MovieModel> findByTitle(String title);
}