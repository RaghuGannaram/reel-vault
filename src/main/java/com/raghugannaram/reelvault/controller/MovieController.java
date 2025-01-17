package com.raghugannaram.reelvault.controller;

import com.raghugannaram.reelvault.model.MovieModel;
import com.raghugannaram.reelvault.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<MovieModel> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieModel> getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id)
                .map(movie -> ResponseEntity.ok().body(movie))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public MovieModel addMovie(@Valid @RequestBody MovieModel movie) {
        return movieService.addMovie(movie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieModel> updateMovie(@PathVariable Long id, @Valid @RequestBody MovieModel movieDetails) {
        return movieService.updateMovie(id, movieDetails)
                .map(movie -> ResponseEntity.ok().body(movie))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }
}