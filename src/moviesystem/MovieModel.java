package moviesystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author Rendall
 */
public class MovieModel extends Observable{
    private final List<Movie> movies;
    
    public MovieModel(){
        movies = new ArrayList<>();
    }
    
    public void AddMovie(String name, String year, String budget, String country){
        Movie movie = new Movie(name, year, budget, country);
        movies.add(movie);
        
        setChanged();
        notifyObservers();
    }
    
    public void RemoveMovie(int id){
        Movie movie = movies.get(id);
        movies.remove(movie);
        
        setChanged();
        notifyObservers();
    }
    
    public List<Movie> getMovies(){
        return movies;
    }
}
