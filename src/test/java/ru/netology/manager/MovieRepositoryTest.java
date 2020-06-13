package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;

import static org.junit.jupiter.api.Assertions.*;

class MovieRepositoryIsNullTest {
    @Test
    void MoviesNoAdd() {
        MovieRepository repository = new MovieRepository();
        repository.findAll();

        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie [0];
        assertArrayEquals(expected, actual);
    }
}

class MovieRepositoryTest {
    MovieRepository repository = new MovieRepository();
    Movie one = new Movie(1, "Бладшот", "Боевик", "https://", "https://");
    Movie two = new Movie(2, "Вперёд", "Мультфильм", "https://", "https://");
    Movie three = new Movie(3, "Отель Белград", "комедия", "https://", "https://");
    Movie four = new Movie(4, "Джентельмены", "боевик", "https://", "https://");
    Movie five = new Movie(5, "Человек-невидимка", "ужасы", "https://", "https://");

    @BeforeEach
    public void sutUp() {
        repository.save(one);
        repository.save(two);
        repository.save(three);
        repository.save(four);
        repository.save(five);
    }

    @Test
    void addMovie() {
        repository.findAll();

        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{one, two, three, four, five};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindById() {
        int idToFind = 3;

        Movie[] actual = repository.findById(idToFind);
        Movie[] expected = new Movie[]{three};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindById() {
        int idToFind = 6;

        Movie[] actual = repository.findById(idToFind);
        Movie[] expected = new Movie[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveAll() {
        repository.removeAll();

        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        int idToRemove = 3;
        repository.removeById(idToRemove);

        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{one,two, four, five};
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeIdNotFind() {
        int idToRemove = 6;
        repository.removeById(idToRemove);

        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{one,two, three, four, five};
        assertArrayEquals(expected, actual);
    }
}