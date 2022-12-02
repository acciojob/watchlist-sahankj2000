package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovieService(Movie movie){
        movieRepository.addMovieToDB(movie);
        return "Success";
    }

    public String addDirectorService(Director director){
        movieRepository.addDirectorToDB(director);
        return "Success";
    }

    public String addMovieDirectorPairService(String movieName,String directorName){
        movieRepository.addMovieDirectorPairToDB(movieName,directorName);
        return "Success";
    }

    public Movie getMovieByNameService(String movieName){
        return movieRepository.getMovieByNameDB(movieName);
    }

    public Director getDirectorByNameService(String directorName){
        return movieRepository.getDirectorByNameDB(directorName);
    }

    public List<String> getMoviesByDirectorNameService(String directorName){
        return movieRepository.getMoviesByDirectorName(directorName);
    }

    public List<String> findAllMoviesService(){
        return movieRepository.findAllMoviesDB();
    }

    public String deleteDirectorByNameService(String directorName){
        movieRepository.deleteDirectorByNameDB(directorName);
        return "Success";
    }

    public String deleteAllDirectorsService(){
        movieRepository.deleteAllDirectorsDB();
        return "Success";
    }
}
