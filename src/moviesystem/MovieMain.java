package moviesystem;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Rendall
 */
public class MovieMain {
    private static Controller controller;
    
    public static void main(String[] args) {
        //Basic abstract factory
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel"); 
        }
        catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e){
            System.out.println("Unknown theme");
        }
        
        /*Hier is sprake van dependency injection, 
        ik geef hier de objecten mee aan de constructor 
        en de addview en listview zijn beide afhankelijk van ActionView. Ik zou ook gemakkelijk andere views mee kunnen sturen.
        */
        controller = new Controller(new MovieModel(), new AddView() {}, new ListView(), new GraphView());
    }   
}
