package com.raghugannaram.reelvault.service;

import com.raghugannaram.reelvault.model.MovieModel;
import com.raghugannaram.reelvault.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<MovieModel> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<MovieModel> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public MovieModel addMovie(MovieModel movie) {
        return movieRepository.save(movie);
    }

    public Optional<MovieModel> updateMovie(Long id, MovieModel movieDetails) {
        MovieModel movie = movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));
        movie.setTitle(movieDetails.getTitle());
        movie.setGenre(movieDetails.getGenre());
        movie.setDirector(movieDetails.getDirector());
        movie.setReleaseDate(movieDetails.getReleaseDate());
        movie.setRating(movieDetails.getRating());
        movie.setDescription(movieDetails.getDescription());
        movie.setDuration(movieDetails.getDuration());
        movieRepository.save(movie);
        return Optional.of(movie);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}