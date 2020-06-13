package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.repository.MoviesRepository;

public class MovieManager {
    private int posterSize;
    private int defaultOutput = 10;
    private MoviesRepository repository;

    public MovieManager(MoviesRepository repository) {
        this.repository = repository;
    }

    public void add (Movie movie){
        repository.save(movie);
    }

    public void removeAll (Movie movie){
        repository.removeAll();
    }

    public Movie[] getAll (){
        Movie[] movies = repository.findAll();
        Movie[] result = new Movie[movies.length];

        if (posterSize == 0 & movies.length <= defaultOutput) {
            result = new Movie[movies.length];
            for (int i = 0; i < result.length; i++) {
                int index = movies.length - i - 1;
                result[i] = movies[index];
            }
        }
        if (posterSize == 0 & movies.length >= defaultOutput++) {
            result = new Movie[10];
            for (int i = 0; i < result.length; i++) {
                int index = movies.length - i - 1;
                result[i] = movies[index];
            }
        }
        if (posterSize != 0) {
            result = new Movie[posterSize];
            for (int i = 0; i < result.length; i++) {
                int index = movies.length - i - 1;
                result[i] = movies[index];
            }
        }
        return result;
    }

    public void removeById (int id){
        repository.removeById(id);
    }

    public Movie[] findById(int id) {
        return repository.findById(id);
    }
}