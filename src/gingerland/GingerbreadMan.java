/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gingerland;

import environment.Direction;
import images.ResourceTools;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;


/**
 *
 * @author sofialuzgalbanpatterson
 */
public class GingerbreadMan {
    
    public void move(){
        if (direction == Direction.LEFT) {
            x--;
        } else if (direction == Direction.DOWN) {
            y++;
        }if (direction == Direction.RIGHT) {
            x++;
        }if (direction == Direction.UP) {
            y--;
        }
        
      
    }       
    

    
    
    public void draw(Graphics graphics){
        graphics.drawImage(getImage(), 
                           cellData.getSystemCoordX(x, y), 
                           cellData.getSystemCoordY(x, y), 
                           cellData.getCellWidth(), 
                           cellData.getCellHeight(), 
                           null);
        
        
    }
    
//    public GingerbreadMan (int x, int y, Direction direction, CellDataProviderIntf cellData){
    public GingerbreadMan (int x, int y, Direction direction, CellDataProviderIntf cellData){
        this.x = x;
        this.y = y; 
        this.direction = direction;
        this.cellData = cellData;
        //image
        BufferedImage temp = (BufferedImage) ResourceTools.loadImageFromResource("gingerland/gingerbread_sprite_sheet.jpg");
        this.image = temp.getSubimage(12, 9, 26, 36);
    }
    
//<editor-fold defaultstate="collapsed" desc="Properties">
    private int x;
    private int y;
    
    private Direction direction;
    private Image image;
    
    private CellDataProviderIntf cellData; 
    
    /**
     * @return the x
     */
    public int getX() {
        return x;
    }
    
    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }
    
    /**
     * @return the y
     */
    public int getY() {
        return y;
    }
    
    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
    
    /**
     * @return the direction
     */
    public Direction getDirection() {
        return direction;
    }
    
    /**
     * @param direction the direction to set
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    
    /**
     * @return the image
     */
    public Image getImage() {
        return image;
    }
    
    /**
     * @param image the image to set
     */
    public void setImage(Image image) {
        this.image = image;
    }
//</editor-fold>
    
}