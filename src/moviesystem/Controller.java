package moviesystem;

import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.AbstractAction;

/**
 *
 * @author Rendall
 */
public class Controller implements Observer{
    private final MovieModel movieModel;
    private final AddView addView;
    private final ListView listView;
    private final GraphView graphView;

    public Controller(MovieModel movieModel, AddView addView, ListView listView, GraphView graphView){
        this.movieModel = movieModel;
        this.addView = addView;
        this.listView = listView;
        this.graphView = graphView;
        
        //Observer pattern
        this.movieModel.addObserver(this);
        
        //Command pattern
        this.addView.setAction(new AddAction());
        this.listView.setAction(new RemoveAction());
        
        addView.setVisible(true);
        listView.setVisible(true);
        graphView.setVisible(true);
    }
    
    //De onderstaande functie is onderdeel van het observer pattern
    @Override
    public void update(Observable o, Object o1) {
        listView.setResult(movieModel.getMovies());
        graphView.update(movieModel.getMovies());
    }

    //De onderstaande functies horen bij het command pattern
    class AddAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent ae) {            
            String name = addView.getName();
            String country = addView.getCountry();
            String budget = addView.getBudget();
            String year = addView.getYear();
            
            if(name != "" && country != "" && budget != "" && year != ""){
                movieModel.AddMovie(name, year, budget, country);
            }
        }
    }
    
    class RemoveAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent ae) {
            int id = listView.getId();
            if(id > -1){
                movieModel.RemoveMovie(id);   
            }
        }
    }
}
