package ru.netology.manager;


import lombok.NoArgsConstructor;
import ru.netology.domain.Movie;

@NoArgsConstructor
public class MovieManager {
    private Movie[] movies = new Movie[0];
    private int defaultOutput = 10;
    private int posterSize;

    public void setPosterSize(int posterSize) {
        this.posterSize = posterSize;
    }

    public MovieManager(int posterSize) {
        this.posterSize = posterSize;
    }

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
}