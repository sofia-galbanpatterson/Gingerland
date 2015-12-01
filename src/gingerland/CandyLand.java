/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gingerland;

import environment.Direction;
import environment.Environment;
import grid.Grid;
import images.ResourceTools;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 *
 * @author sofialuzgalbanpatterson
 */
class CandyLand extends Environment implements CellDataProviderIntf, MoveValidatorIntf {

    Grid grid;
    Image Farquaad;
    Image Gingy;
    Image GummyBear;
    Image GingerbreadSprite;
    private ArrayList<Barrier> barriers;
    private GingerbreadMan gingy; 
           

    {
        grid = new Grid(25, 20, 20, 20, new Point(10, 50), Color.BLACK);
        barriers = new ArrayList<>();
        barriers.add(new Barrier(0, 0, Color.PINK, this));
        barriers.add(new Barrier(1, 0, Color.PINK, this));
        barriers.add(new Barrier(2, 0, Color.PINK, this));
        barriers.add(new Barrier(3, 0, Color.PINK, this));
        barriers.add(new Barrier(4, 0, Color.PINK, this));

    }

    public CandyLand() {
//        Farquaad = ResourceTools.loadImageFromResource("gingerland/Farquaad_S.png");
//        Gingy = ResourceTools.loadImageFromResource("gingerland/gingy.png");
//        GummyBear = ResourceTools.loadImageFromResource("gingerland/gummy bear.png");
//        GingerbreadSprite = ResourceTools.loadImageFromResource("gingerbread sprite"); 
        gingy = new GingerbreadMan(3, 4, Direction.DOWN, this); 
    }

    @Override
    public void initializeEnvironment() {

    }
    int counter;

    @Override
    public void timerTaskHandler() {
        if (gingy != null) {
            gingy.move();
        }
    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
//        System.out.println("Key Event" + e.getKeyChar());
//        System.out.println("Key Event" + e.getKeyCode());
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("Go Left!");
            gingy.setDirection(Direction.LEFT);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("Go Right!");
            gingy.setDirection(Direction.RIGHT);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("Go Up!");
            gingy.setDirection(Direction.UP);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("Go Down!");
            gingy.setDirection(Direction.DOWN);
        }

    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            System.out.println("Go Left!");
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            System.out.println("Go Right!");
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            System.out.println("Go Up!");
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            System.out.println("Go Down!");
        }

    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {
        System.out.println("mouse click at " + e.getPoint());
        System.out.println("mouse clicked in cell " + grid.getCellLocationFromSystemCoordinate(e.getPoint()));

    }

    @Override
    public void paintEnvironment(Graphics graphics) {
        if (grid != null) {
            grid.paintComponent(graphics);
        }

        if (Gingy != null) {
            graphics.drawImage(Gingy, 400, 250, 100, 100, this);

        }
        if (GummyBear != null) {
            graphics.drawImage(GummyBear, 400, 400, 50, 50, this);
        }

        if (Farquaad != null) {
            graphics.drawImage(Farquaad, 300, 300, 100, 100, this);

        }
        
        
            
        

        if (barriers != null) {
            for (int i = 0; i < barriers.size(); i++) {
                barriers.get(i).draw(graphics);
            } 
        }
        
        if (gingy != null) {
            gingy.draw(graphics);
            
        }
    }

    //<editor-fold defaultstate="collapsed" desc="CellDataProviderIntf">
    @Override
    public int getCellWidth() {
        return grid.getCellWidth();
    }

    @Override
    public int getCellHeight() {
        return grid.getCellHeight();
    }

    @Override
    public int getSystemCoordX(int x, int y) {
        return grid.getCellSystemCoordinate(x, y).x;

    }

    @Override
    public int getSystemCoordY(int x, int y) {
        return grid.getCellSystemCoordinate(x, y).y;
    }

    //<editor-fold defaultstate="collapsed" desc="MoveValidatorIntf">
    @Override
    public Point validateMove(Point proposedLocation) {

        return proposedLocation;
    }

}
//</editor-fold>
//</editor-fold>
