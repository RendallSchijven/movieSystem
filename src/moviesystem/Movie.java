package moviesystem;

/**
 *
 * @author Rendall
 */
public class Movie {
    private final String name;
    private final String year;
    private final String budget;
    private final String country;
    
    public Movie(String name, String year, String budget, String country){
        this.name = name;
        this.year = year;
        this.budget = budget;
        this.country = country;
    }
    
    public String getName(){
        return name;
    }
    
    public String getYear(){
        return year;
    }
    
    public String getBudget(){
        return budget;
    }
    
    public String getCountry(){
        return country;
    }
}
