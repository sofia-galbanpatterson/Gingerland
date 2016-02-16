/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gingerland;

import images.ResourceTools;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author sofialuzgalbanpatterson
 */
public class Item {
    
    public void draw(Graphics graphics){ 
        graphics.drawImage(getImage(), 
                getCellData().getSystemCoordX(getX(), getY()),
                getCellData().getSystemCoordY(getX(), getY()), 
                getCellData().getCellWidth(),
                getCellData().getCellHeight(), null); 
        
        
    }
    
    public Item (int x, int y, String type, Image image, CellDataProviderIntf cellData){
      
        this.x = x; 
        this.y = y; 
        this.type = type; 
        this.image = image; 
        this.cellData = cellData;
        
        if (type.equals(Item.ITEM_TYPE_CANDYCANE)) {
          image = ResourceTools.loadImageFromResource("gingerland/candycane.png"); 
          
          
          
          
        }
        
    } 
    
       private int x, y;
       private boolean alive;
       private String type; 
       private Image image; 
       private final CellDataProviderIntf cellData; 
       private MoveValidatorIntf moveValidator; 
       
       

    /**
     * @return the x
     */
       //<editor-fold defaultstate="collapsed" desc="Properties">
       public static final String ITEM_TYPE_CANDYCANE = "CANDYCANE"; 
       public static final String ITEM_TYPE_GUMMYBEAR = "GUMMYBEAR"; 
       
       
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
        * @return the type
        */
       public String getType() {
           return type;
       }
       
       /**
        * @param type the type to set
        */
       public void setType(String type) {
           this.type = type;
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
       
       /**
        * @return the cellData
        */
       public CellDataProviderIntf getCellData() {
           return cellData;
       }
       
}

//</editor-fold>

