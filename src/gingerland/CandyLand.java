/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gingerland;

import audio.AudioPlayer;
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
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author sofialuzgalbanpatterson
 */
class CandyLand extends Environment implements CellDataProviderIntf, MoveValidatorIntf {

    Grid grid;
    Image Gingerbreadsprite;
    Image gingerbreadsprite1;
    Image gingerbreadsprite2;
    Image gingerbreadsprite3;
    Image gingerbreadsprite4;
    Image gingerbreadsprite5;
    Image gingerbreadsprite6;
    Image gingerbreadsprite7; 
    Image gingerbreadsprite8; 
    Image gingerbreadsprite9; 

    private ArrayList<Barrier> barriers;
    private GingerbreadMan gingy;

    {
        //<editor-fold defaultstate="collapsed" desc="Barriers and Grid">
        grid = new Grid(25, 17, 32, 32, new Point(10, 50), Color.MAGENTA);
        
        BufferedImage temp = (BufferedImage) ResourceTools.loadImageFromResource("gingerland/grass_background.png");
        
        this.setBackground(temp.getScaledInstance(1600, 900, Image.SCALE_SMOOTH)); 

        barriers = new ArrayList<>();
        barriers.add(new Barrier(2, 2, Color.PINK, this));
        barriers.add(new Barrier(3, 2, Color.PINK, this));
        barriers.add(new Barrier(4, 2, Color.PINK, this));
        barriers.add(new Barrier(5, 2, Color.PINK, this));
        barriers.add(new Barrier(6, 2, Color.PINK, this));
        barriers.add(new Barrier(7, 5, Color.PINK, this));
        barriers.add(new Barrier(8, 5, Color.PINK, this));
        barriers.add(new Barrier(9, 5, Color.PINK, this));
        barriers.add(new Barrier(10, 5, Color.PINK, this));
        barriers.add(new Barrier(11, 8, Color.PINK, this));
        barriers.add(new Barrier(12, 8, Color.PINK, this));
        barriers.add(new Barrier(1, 12, Color.PINK, this));
        barriers.add(new Barrier(2, 12, Color.PINK, this));
        barriers.add(new Barrier(3, 12, Color.PINK, this));
        barriers.add(new Barrier(4, 12, Color.PINK, this));
        barriers.add(new Barrier(12, 12, Color.PINK, this));
        barriers.add(new Barrier(13, 12, Color.PINK, this));
        barriers.add(new Barrier(14, 12, Color.PINK, this));
        barriers.add(new Barrier(15, 12, Color.PINK, this));
        barriers.add(new Barrier(16, 12, Color.PINK, this));
        barriers.add(new Barrier(17, 12, Color.PINK, this));
        

//</editor-fold> 
    }
    
    public CandyLand() {
//        GingerbreadSprite = ResourceTools.loadImageFromResource("gingerbread sprite"); 
        gingy = new GingerbreadMan(3, 4, Direction.DOWN, this);
        gingerbreadsprite1 = ResourceTools.loadImageFromResource("gingerland/gingerbread_front_still.png");
        gingerbreadsprite2 = ResourceTools.loadImageFromResource("gingerland/gingerbread_front_walk1.png");
        gingerbreadsprite3 = ResourceTools.loadImageFromResource("gingerland/gingerbread_front_walk2.png");
        gingerbreadsprite4 = ResourceTools.loadImageFromResource("gingerland/gingerbread_right_still.png");
        gingerbreadsprite5 = ResourceTools.loadImageFromResource("gingerland/gingerbread_right_walk.png");
        gingerbreadsprite6 = ResourceTools.loadImageFromResource("gingerland/gingerbread_right_walk2.png");
        gingerbreadsprite7 = ResourceTools.loadImageFromResource("gingerland/gingerbread_left_still.png");
        gingerbreadsprite8 = ResourceTools.loadImageFromResource("gingerland/gingerbread_left_walk1.png");
        gingerbreadsprite9 = ResourceTools.loadImageFromResource("gingerland/gingerbread_left_walk2.png");


        

    }

    @Override
    public void initializeEnvironment() {

    }
    private int counter;
    private int limit = 2;
    final int LIMIT_SLOW = 5;
    final int LIMIT_MEDIUM = 3;
    final int LIMIT_FAST = 1;
    final int LIMIT_CRAZY = 0;

    //need a counter and a limit
    @Override
    public void timerTaskHandler() {
        if (gingy != null) {
            if (counter < limit) {
                counter++;
            } else {
                counter = 0;
                gingy.move();
            }
        }
    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
//        System.out.println("Key Event" + e.getKeyChar());
//        System.out.println("Key Event" + e.getKeyCode());
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            gingy.setDirection(Direction.LEFT);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            gingy.setDirection(Direction.RIGHT);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            gingy.setDirection(Direction.UP);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            gingy.setDirection(Direction.DOWN);
        } else if (e.getKeyCode() == KeyEvent.VK_1) {
            this.limit = LIMIT_SLOW;
        } else if (e.getKeyCode() == KeyEvent.VK_2) {
            this.limit = LIMIT_MEDIUM;
        } else if (e.getKeyCode() == KeyEvent.VK_3) {
            this.limit = LIMIT_FAST;
        } else if (e.getKeyCode() == KeyEvent.VK_4) {
            this.limit = LIMIT_CRAZY;
        } else if (e.getKeyCode()== KeyEvent.VK_SPACE) { 
            AudioPlayer.play("/gingerland/collections_sound.wav"); 
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

        if (barriers != null) {
            for (int i = 0; i < barriers.size(); i++) {
                barriers.get(i).draw(graphics);
            }
        }

        if (gingy != null) {
            gingy.draw(graphics);

        }

        if (gingerbreadsprite1 != null) {
            graphics.drawImage(gingerbreadsprite1, 400, 250, 25, 25, this); 
        }
        
        if (gingerbreadsprite2 !=null) { 
            graphics.drawImage(gingerbreadsprite2, 350, 260, 25, 25, this); 
        }
        
        if (gingerbreadsprite3 !=null) { 
            graphics.drawImage(gingerbreadsprite3, 650, 270, 25, 25, this); 
        }
        
        if (gingerbreadsprite4 !=null) { 
            graphics.drawImage(gingerbreadsprite4, 550, 280, 25, 25, this); 
        }
        
        if (gingerbreadsprite5 !=null) { 
            graphics.drawImage(gingerbreadsprite5, 750, 290, 25, 25, this); 
        }
        
        if (gingerbreadsprite6 !=null) { 
            graphics.drawImage(gingerbreadsprite6, 850, 300, 25, 25, this); 
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
