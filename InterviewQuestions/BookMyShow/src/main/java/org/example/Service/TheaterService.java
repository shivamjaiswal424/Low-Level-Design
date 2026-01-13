package org.example.Service;

import org.example.Entities.Movie;
import org.example.Entities.Screen;
import org.example.Entities.Show;
import org.example.Entities.Theatre;
import org.example.Enums.City;

import java.time.LocalDate;
import java.util.*;

public class TheaterService {
    private final Map<City, List<Theatre>> cityTheatres=new HashMap<>();



    public void addTheatre(Theatre theatre){
        cityTheatres.computeIfAbsent(theatre.getCity(),c-> new ArrayList<>()).add(theatre);
    }
    public Set<Movie> getMovies(City city, LocalDate date) {
        Set<Movie> movies = new HashSet<>();
        List<Theatre> theatres = cityTheatres.getOrDefault(city, List.of());

        for (Theatre theatre : theatres) {
            for (Screen screen : theatre.getScreens()) {
                for (Show show : screen.getShowsByDate(date)) {
                    movies.add(show.getMovie());
                }
            }
        }
        return movies;
    }

    public List<Show> getShows(Movie movie, LocalDate date,Theatre theatre) {
        List<Show> shows=new ArrayList<>();
        for (Screen screen:theatre.getScreens()){
            for (Show show:screen.getShowsByDate(date)){
                if (show.getMovie().equals(movie)){
                    shows.add(show);
                }
            }
        }
        return shows;
    }
    public List<Theatre> getTheatres(City city,Movie movie, LocalDate date) {
        List<Theatre> theatres=cityTheatres.getOrDefault(city,List.of());
        return theatres.stream().filter(t->t.getScreens().stream().anyMatch(s->s.getShowsByDate(date).stream().anyMatch(show -> show.getMovie().equals(movie)))).toList();
    }
}
