package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/movies/add-movie") // working
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){
        return new ResponseEntity(movieService.addMovieService(movie), HttpStatus.CREATED);
    }

    @PostMapping("/movies/add-director") // working
    public ResponseEntity<String> addDirector(@RequestBody() Director director){
        return new ResponseEntity(movieService.addDirectorService(director), HttpStatus.CREATED);
    }

    @PutMapping("/movies/add-movie-director-pair") // working
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie name") String movieName,
                                                       @RequestParam("director name") String directorName){
        return new ResponseEntity(movieService.addMovieDirectorPairService(movieName,directorName), HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String movieName){
        return new ResponseEntity(movieService.getMovieByNameService(movieName), HttpStatus.FOUND);
    }

    @GetMapping("/movies/get-director-by-name/{name}") //working
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String directorName){
        return new ResponseEntity(movieService.getDirectorByNameService(directorName), HttpStatus.FOUND);
    }

    @GetMapping("/movies/get-movies-by-director-name/{director}") // working
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String directorName){
        return new ResponseEntity<>(movieService.getMoviesByDirectorNameService(directorName), HttpStatus.FOUND);
    }

    @GetMapping("/movies/get-all-movies") // working
    public ResponseEntity<List<String>> findAllMovies(){
        return new ResponseEntity(movieService.findAllMoviesService(),HttpStatus.FOUND);
    }

    @DeleteMapping("/movies/delete-director-by-name") // working
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name") String dirctorName){
        return new ResponseEntity(movieService.deleteDirectorByNameService(dirctorName), HttpStatus.OK);
    }

    @DeleteMapping("/movies/delete-all-directors") // working
    public ResponseEntity<String> deleteAllDirectors(){
        return new ResponseEntity(movieService.deleteAllDirectorsService(), HttpStatus.OK);
    }
}
