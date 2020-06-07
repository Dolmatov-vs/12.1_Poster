package ru.netology.manager;

import lombok.Data;
import ru.netology.domain.Movie;

@Data
public class MovieManager {
    private Movie[] movies = new Movie[0];
    private int count;

    public void addMovie(Movie movie) {
        int length = movies.length + 1;

        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Movie[] getAll() {
        Movie[] result = new Movie[0];
        if (count == 0 & movies.length < 11) {
            result = new Movie[movies.length];
            for (int i = 0; i < result.length; i++) {
                int index = movies.length - i - 1;
                result[i] = movies[index];
            }
        }
        if (count == 0 & movies.length >= 11) {
            result = new Movie[10];
            for (int i = 0; i < result.length; i++) {
                int index = movies.length - i - 1;
                result[i] = movies[index];
            }
        }
        if (count != 0) {
            result = new Movie[count];
            for (int i = 0; i < result.length; i++) {
                int index = movies.length - i - 1;
                result[i] = movies[index];
            }
        }
        return result;
    }
}