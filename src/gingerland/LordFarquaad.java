/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gingerland;

import environment.Direction;
import images.Animator;
import images.ResourceTools;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

/**
 *
 * @author sofialuzgalbanpatterson
 */
public class LordFarquaad {

    public void draw(Graphics graphics) {
        graphics.drawImage(getImage(), cellData.getSystemCoordX(getX(), getY()),
                cellData.getSystemCoordY(getX(), getY()), cellData.getCellWidth(),
                cellData.getCellHeight(), null);
    }

    public LordFarquaad(int x, int y, Direction direction, CellDataProviderIntf cellData) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.cellData = cellData;

        imageLeft = ResourceTools.loadImageFromResource("gingerland/lord_farquaad_left.png");
        imageRight = ResourceTools.loadImageFromResource("gingerland/lord_farquaad_right.png");
    }

    public void move(int x, int y){
        this.setX(this.getX() + x);
        this.setY(this.getY() + y);
    }
    
    private Image imageLeft, imageRight;
    private Direction direction;
    private int x, y;
    private CellDataProviderIntf cellData;

    private Image getImage() {
        if (direction == Direction.LEFT) {
            return imageLeft;
        } else {
            return imageRight;
        }
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * @return the x
     */
    public Point getLocation() {
        return new Point(x, y);
    }
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

}
