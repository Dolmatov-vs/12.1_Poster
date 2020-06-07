package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Movie {
    private int id;
    private String name;
    private String genre;
    private String url;
    private String urlImage;
//    private boolean premiereTomorrow;
}
