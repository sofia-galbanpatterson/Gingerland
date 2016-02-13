/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gingerland;

import images.ImageManager;
import images.ResourceTools;
import java.util.ArrayList;

/**
 *
 * @author sofialuzgalbanpatterson
 */
public class AnimatedImageManager extends ImageManager {

    public static final String MOVE_LEFT = "MOVE_LEFT";
    public static final String MOVE_RIGHT = "MOVE_RIGHT";

    public static ArrayList<String> MOVE_LEFT_IMAGE_NAMES; 
    public static ArrayList<String> MOVE_RIGHT_IMAGE_NAMES; 
    
            
    public AnimatedImageManager() {
       MOVE_LEFT_IMAGE_NAMES = new ArrayList<>(); 
       MOVE_LEFT_IMAGE_NAMES.add(MOVE_LEFT); 
       
       MOVE_RIGHT_IMAGE_NAMES = new ArrayList<>(); 
       MOVE_RIGHT_IMAGE_NAMES.add(MOVE_RIGHT); 
        
       this.addImage(MOVE_LEFT, ResourceTools.loadImageFromResource("gingerland/lord_farquaad_left.png"));
       this.addImage(MOVE_RIGHT, ResourceTools.loadImageFromResource("gingerland/lord_farquaad_right.png"));
       
       

    }

}
