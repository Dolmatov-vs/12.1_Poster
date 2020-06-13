package ru.netology.repository;

import ru.netology.domain.Movie;

public class AfishaRepository {
    private Movie[] movies = new Movie[0];

    public Movie[] findAll() {
        return movies;
    }

    public void save(Movie movie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Movie[] findById(int id) {
        Movie[] findMove = new Movie[0];
        int index = 0;
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                findMove = new Movie[1];
                findMove[index] = movie;
                index++;
            }
        }
        return findMove;
    }

    public void removeById(int id) {
        int length = movies.length - 1;
        Movie[] tmp = new Movie[length];
        int index = 0;
        for (Movie movie : movies) {
            if (movie.getId() != id) {
                tmp[index] = movie;
                index++;
            }
        }
        movies = tmp;
    }

    public void removeAll() {
        Movie[] tmp = new Movie[0];
        movies = tmp;
    }

}
