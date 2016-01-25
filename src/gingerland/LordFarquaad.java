/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gingerland;

import environment.Direction;
import java.awt.Graphics;

/**
 *
 * @author sofialuzgalbanpatterson
 */
public class LordFarquaad {
    
    public void move() { 
        if (direction == Direction.LEFT) {
            x--; 
        }
        if (direction == Direction.DOWN) {
            y++; 
    } 
        if (direction == Direction.RIGHT) {
            x++; 
        }      
            if (direction == Direction.LEFT) {
            y--; 
            
            }
    }
    
    public void draw (Graphics graphics) { 
        graphics.drawImage(getImage(), 
               cellData.getSystemCoordX(x, y),
                cellData.getSystemCoordY(x, y),
                cellData.getCellWidth(),
                cellData.getCellHeight(),
                null);
    }
    
    public LordFarquaad(int x, int y, Direction direction, CellDataProviderIntf celldata) { 
        this.x = x; 
        this.y = y; 
        this.direction = direction; 
        this.cellData = cellData; 
        
    }
