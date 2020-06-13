package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MovieManagerTest {

    @Mock
    AfishaRepository repository;

    @InjectMocks
    MovieManager movieManager;

    Movie one = new Movie(1, "Бладшот", "Боевик", "https://", "https://");
    Movie two = new Movie(2, "Вперёд", "Мультфильм", "https://", "https://");
    Movie three = new Movie(3, "Отель Белград", "комедия", "https://", "https://");
    Movie four = new Movie(4, "Джентельмены", "боевик", "https://", "https://");
    Movie five = new Movie(5, "Человек-невидимка", "ужасы", "https://", "https://");
    Movie six = new Movie(6, "Тролли. Мировой тур", "мультфильм", "https://", "https://");
    Movie seven = new Movie(7, "Номер один", "комедия", "https://", "https://");
    Movie eight = new Movie(8, "Хроники Хищных городов", "фантастика", "https://", "https://");
    Movie nine = new Movie(9, "Друзья", "сериал", "https://", "https://");
    Movie then = new Movie(10, "Южный парк", "мультфильм", "https://", "https://");
    Movie eleven = new Movie(11, "Футурама", "мультфильм", "https://", "https://");


    @Test
    void MoviesNoAdd() {
        Movie[] returned = new Movie [0];
        doReturn(returned).when(repository).findAll();

        Movie[] expected = new Movie [0];
        Movie[] actual = movieManager.getAll();

        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    void addMovie() {
        Movie[] returned = new Movie[]{one};
        doReturn(returned).when(repository).findAll();

        movieManager.add(one);
        Movie[] expected = new Movie[]{one};
        Movie[] actual = movieManager.getAll();

        assertArrayEquals(expected, actual);
        verify(repository).save(any());
        verify(repository).findAll();
    }

    @Test
    void addThenMovie() {
        Movie[] returned = new Movie[]{one, two, three, four, five, six, seven, eight, nine, then};
        doReturn(returned).when(repository).findAll();

        Movie[] actual = movieManager.getAll();
        Movie[] expected = new Movie[]{then,nine, eight, seven, six, five, four,three,two, one};

        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }


    @Test
    void addMoreThenMovie() {
        Movie[] returned = new Movie[]{one, two, three, four, five, six, seven, eight, nine, then, eleven};
        doReturn(returned).when(repository).findAll();

        Movie[] actual = movieManager.getAll();
        Movie[] expected = new Movie[]{eleven, then,nine, eight, seven, six, five, four,three,two};

        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    void showSpecificNumberFilms() {
        movieManager.setPosterSize(5);
        Movie[] returned = new Movie[]{one, two, three, four, five, six, seven, eight, nine, then, eleven};
        doReturn(returned).when(repository).findAll();

        Movie[] actual = movieManager.getAll();
        Movie[] expected = new Movie[]{eleven, then,nine, eight, seven};

        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

//    @Test
//    void shouldRemoveAll() {
//        Movie[] returnedFindAll = new Movie[0];
//        doReturn(returnedFindAll).when(repository).findAll();
//        doNothing().when(repository).removeAll();
//
//
//        movieManager.removeAll(any());
//
//        Movie[] actual = movieManager.getAll();
//        Movie[] expected = new Movie[0];
//
//        assertArrayEquals(expected, actual);
//        verify(repository).removeAll();
//    }

    @Test
    void shouldFindById() {
        int idToFind = 4;
        Movie[] returned = new Movie[]{four};
        doReturn(returned).when(repository).findById(idToFind);

        Movie[] actual = movieManager.findById(idToFind);
        Movie[] expected = new Movie[]{four};

        assertArrayEquals(expected, actual);
        verify(repository).findById(idToFind);
    }

    @Test
    void shouldIdNotFind() {
        int idToFind = 4;
        Movie[] returned = new Movie[0];
        doReturn(returned).when(repository).findById(idToFind);

        Movie[] actual = movieManager.findById(idToFind);
        Movie[] expected = new Movie[0];

        assertArrayEquals(expected, actual);
        verify(repository).findById(idToFind);
    }

    @Test
    void shouldRemoveById() {
        int idToRemove = 4;
        Movie[] returned = new Movie[]{one, two, three, five};
        doReturn(returned).when(repository).findAll();

        movieManager.removeById(idToRemove);

        Movie[] actual = movieManager.getAll();
        Movie[] expected = new Movie[]{five, three, two, one};

        assertArrayEquals(expected, actual);
        verify(repository).removeById(idToRemove);
    }

    @Test
    void shouldRemoveIdNotFind() {
        int idToRemove = 4;
        Movie[] returned = new Movie[]{one, two, three, five};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        movieManager.removeById(idToRemove);

        Movie[] actual = movieManager.getAll();
        Movie[] expected = new Movie[]{five, three, two, one};

        assertArrayEquals(expected, actual);
        verify(repository).removeById(idToRemove);
    }

    @Test
    void shouldNotRemoveIfNotExists (){
        int idToRemove = 4;
        Movie[] returned = new Movie[]{one, two, three};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        movieManager.removeById(idToRemove);

        Movie[] actual = movieManager.getAll();
        Movie[] expected = new Movie[]{three, two, one};

        assertArrayEquals(expected, actual);
        verify(repository).removeById(idToRemove);
    }
}