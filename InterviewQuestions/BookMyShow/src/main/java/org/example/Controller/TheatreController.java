package org.example.Controller;

import org.example.Entities.Movie;
import org.example.Entities.Show;
import org.example.Entities.Theatre;
import org.example.Enums.City;
import org.example.Service.TheaterService;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class TheatreController {
    private final TheaterService theaterService;
    public TheatreController() {
        this.theaterService = new TheaterService();
    }
    public void addTheatre(Theatre theatre){
        theaterService.addTheatre(theatre);

    }
    public Set<Movie> getMovies(City city, LocalDate date) throws  Exception{
        return theaterService.getMovies(city,date);
    }
    public List<Theatre> getTheatres(City city,Movie movie, LocalDate date) throws  Exception{
        return theaterService.getTheatres(city,movie,date);
    }
    public List<Show> getShows(Movie movie, LocalDate date,Theatre theatre) throws  Exception{
        return theaterService.getShows(movie,date,theatre);
    }

}
