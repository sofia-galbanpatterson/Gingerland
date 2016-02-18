/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gingerland;

import environment.ApplicationStarter;
import java.awt.Dimension;

/**
 *
 * @author sofialuzgalbanpatterson
 */
public class Gingerland {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationStarter.run(new String[0], "Gingerland", new Dimension(1200, 750), new CandyLand());
    }
    
    
    
}
