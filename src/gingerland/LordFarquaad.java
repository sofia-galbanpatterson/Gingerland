/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gingerland;

import images.Animator;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author sofialuzgalbanpatterson
 */
public class LordFarquaad {
  private Animator animator; 
  private Image image; 
  
  public void draw(Graphics graphics){
      graphics.drawImage(getImage(), 0, 0, 0, 0, null); 
  }
    
    public LordFarquaad(){ 
        animator = new Animator(new AnimatedImageManager(), AnimatedImageManager.MOVE_LEFT_IMAGE_NAMES, 100); 
        
    }

    private Image getImage() {
        
       if (animator != null) { 
           return animator.getCurrentImage(); 
       } else { 
           return image;  
       }
        
    }
}
