package com.driver;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Component
public class MovieRepository {

    Map<String,Movie> movieMap = new HashMap<>();
    Map<String,Director> directorMap = new HashMap<>();
    Map<Director,List<Movie>> MDmap = new HashMap<>();

    public void addMovieToDB(Movie movie){
        movieMap.put(movie.getName(),movie);
    }

    public void addDirectorToDB(Director director){
        directorMap.put(director.getName(),director);
    }

    public void addMovieDirectorPairToDB(String movieName,String directorName){
        if(MDmap.containsKey(directorMap.get(directorName))){
            List<Movie> list = MDmap.get(directorMap.get(directorName));
            list.add(movieMap.get(movieName));
        }else{
            List<Movie> list = new ArrayList<>();
            list.add(movieMap.get(movieName));
            MDmap.put(directorMap.get(directorName),list);
        }
    }

    public Movie getMovieByNameDB(String movieName){
        return movieMap.get(movieName);
    }

    public Director getDirectorByNameDB(String directorName){
        return directorMap.get(directorName);
    }

    public List<String> getMoviesByDirectorName(String directorName){
        List<String> movieNameList = new ArrayList<>();
        for(Movie movie: MDmap.get(directorMap.get(directorName))) movieNameList.add(movie.getName());
        return movieNameList;
    }

    public List<String> findAllMoviesDB(){
        List<String> list = new ArrayList<>();
        for(String str:movieMap.keySet()) list.add(str);
        return list;
    }

    public void deleteDirectorByNameDB(String directorName){
        Director director = directorMap.get(directorName);
        directorMap.remove(directorName);
        for(Movie movie:MDmap.get(director)){
            movieMap.remove(movie.getName());
        }
    }

    public void deleteAllDirectorsDB(){
        for(Director director: directorMap.values()) deleteDirectorByNameDB(director.getName());
    }
}
