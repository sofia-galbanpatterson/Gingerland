/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gingerland;

import audio.AudioPlayer;
import audio.Track;
import environment.Direction;
import environment.Environment;
import grid.Grid;
import images.ResourceTools;
import java.awt.Color;
import java.awt.Font;
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

    private final ArrayList<Barrier> barriers;
    private final ArrayList<Item> items;
    private final GingerbreadMan gingy;
    private String trackNameGameTimer; 
    private int score; 

    {
        //<editor-fold defaultstate="collapsed" desc="Barriers and Grid">
        grid = new Grid(25, 17, 32, 32, new Point(10, 50), Color.MAGENTA);

        BufferedImage temp = (BufferedImage) ResourceTools.loadImageFromResource("gingerland/grass_background.png");

        this.setBackground(temp.getScaledInstance(1600, 900, Image.SCALE_SMOOTH));

        //<editor-fold defaultstate="collapsed" desc="Barriers">
        barriers = new ArrayList<>();
        barriers.add(new Barrier(2, 2, Color.PINK, this));
        barriers.add(new Barrier(3, 2, Color.PINK, this));
        barriers.add(new Barrier(4, 2, Color.PINK, this));
        barriers.add(new Barrier(5, 2, Color.PINK, this));
        barriers.add(new Barrier(9, 2, Color.PINK, this));
        barriers.add(new Barrier(10, 2, Color.PINK, this));
        barriers.add(new Barrier(20, 3, Color.PINK, this));
        barriers.add(new Barrier(21, 3, Color.PINK, this));
        barriers.add(new Barrier(22, 3, Color.PINK, this));
        barriers.add(new Barrier(23, 3, Color.PINK, this));
        barriers.add(new Barrier(20, 10, Color.PINK, this));
        barriers.add(new Barrier(21, 10, Color.PINK, this));
        barriers.add(new Barrier(22, 10, Color.PINK, this));
        barriers.add(new Barrier(23, 10, Color.PINK, this));
        
        barriers.add(new Barrier(20, 20, Color.PINK, this));
        barriers.add(new Barrier(13, 12, Color.PINK, this));
        barriers.add(new Barrier(8, 12, Color.PINK, this));
        barriers.add(new Barrier(9, 12, Color.PINK, this));
        barriers.add(new Barrier(6, 2, Color.PINK, this));
        barriers.add(new Barrier(7, 5, Color.PINK, this));
        barriers.add(new Barrier(8, 5, Color.PINK, this));
        barriers.add(new Barrier(9, 5, Color.PINK, this));
        barriers.add(new Barrier(10, 5, Color.PINK, this));
        barriers.add(new Barrier(10, 5, Color.PINK, this));
        barriers.add(new Barrier(11, 8, Color.PINK, this));
        barriers.add(new Barrier(12, 8, Color.PINK, this));
        barriers.add(new Barrier(1, 12, Color.PINK, this));
        barriers.add(new Barrier(2, 12, Color.PINK, this));
        barriers.add(new Barrier(3, 12, Color.PINK, this));
        barriers.add(new Barrier(4, 12, Color.PINK, this));
        barriers.add(new Barrier(18, 12, Color.PINK, this));
        barriers.add(new Barrier(13, 12, Color.PINK, this));
        barriers.add(new Barrier(14, 12, Color.PINK, this));
        barriers.add(new Barrier(15, 12, Color.PINK, this));
        barriers.add(new Barrier(16, 12, Color.PINK, this));
        barriers.add(new Barrier(17, 12, Color.PINK, this));
        barriers.add(new Barrier(5, 12, Color.PINK, this));
        barriers.add(new Barrier(9, 12, Color.PINK, this));
        
      
//</editor-fold>

        items = new ArrayList<>();
        items.add(new Item(5, 5, "POWER_UP",
                ResourceTools.loadImageFromResource("gingerland/gummybear.png"), this));
        items.add(new Item(8, 8, "POWER_UP",
                ResourceTools.loadImageFromResource("gingerland/candycane.png"), this));
        items.add(new Item(6, 6, "POWER_UP",
                ResourceTools.loadImageFromResource("gingerland/gummybear.png"), this));
        items.add(new Item(10, 10, "POWER_UP",
                ResourceTools.loadImageFromResource("gingerland/gummybear.png"), this));
        items.add(new Item(11, 12, "POWER_UP",
                ResourceTools.loadImageFromResource("gingerland/gummybear.png"), this));
        
        items.add(new Item(20, 12, Item.ITEM_TYPE_CANDYCANE,
                ResourceTools.loadImageFromResource("gingerland/candycane.png"), this)); 
        
        items.add(new Item(20, 5, "POWER_UP",
                ResourceTools.loadImageFromResource("gingerland/candycane.png"), this));

//</editor-fold> 
    }

    public CandyLand() {
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
        
        ArrayList<Track> tracks = new ArrayList<>(); 

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
                score ++; 
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

        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            AudioPlayer.play("/gingerland/collections_sound.wav");
        } else if (e.getKeyCode() == KeyEvent.VK_F) {
            AudioPlayer.play("/gingerland/jumpsound.wav");
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

        if (items != null) {
            for (int i = 0; i < items.size(); i++) {
                items.get(i).draw(graphics);

            }

            if (gingy != null) {
                gingy.draw(graphics);
            }
        }
        graphics.setColor(Color.WHITE); 
        graphics.setFont(new Font ("Calibri", Font.BOLD, 35));
        graphics.drawString("Score: " + score, 10, 20); 
        

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
  
        
        if (proposedLocation.x < 0) {
            proposedLocation.x = grid.getColumns() - 1; 
        } else if (proposedLocation.x > grid.getColumns() - 1 ) {
            proposedLocation.x = 0;
        } if (proposedLocation.y < 0) {
            proposedLocation.y = grid.getRows() - 1;
        
       
    }
        return null;
        
    } 
    
} 
       
    
//    
//}


        
    

//</editor-fold>
//</editor-fold>

        