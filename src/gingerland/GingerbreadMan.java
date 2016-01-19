/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gingerland;

import environment.Direction;
import images.Animator;
import images.ImageManager;
import images.ResourceTools;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author sofialuzgalbanpatterson
 */
public class GingerbreadMan {

    public void move() {
        if (direction == Direction.LEFT) {
            x--;
        } else if (direction == Direction.DOWN) {
            y++;
        }
        if (direction == Direction.RIGHT) {
            x++;
        }
        if (direction == Direction.UP) {
            y--;
        }
    }

    public void draw(Graphics graphics) {
        graphics.drawImage(getImage(),
                cellData.getSystemCoordX(x, y),
                cellData.getSystemCoordY(x, y),
                cellData.getCellWidth(),
                cellData.getCellHeight(),
                null);
    }

//    public GingerbreadMan (int x, int y, Direction direction, CellDataProviderIntf cellData){
    public GingerbreadMan(int x, int y, Direction direction, CellDataProviderIntf cellData) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.cellData = cellData;
        
        
        //image
        BufferedImage temp = (BufferedImage) ResourceTools.loadImageFromResource("gingerland/gingerbread_sprite_sheet.jpg");
        this.image = temp.getSubimage(12, 9, 26, 36);

        ImageManager im = new ImageManager();
        im.addImage(GINGERBREAD_FRONT_STILL, ResourceTools.loadImageFromResource("gingerland/gingerbread_front_still.png"));
        im.addImage(GINGERBREAD_FRONT_WALK1, ResourceTools.loadImageFromResource("gingerland/gingerbread_front_walk1.png"));
        im.addImage(GINGERBREAD_FRONT_WALK2, ResourceTools.loadImageFromResource("gingerland/gingerbread_front_walk2.png"));
        im.addImage(GINGERBREAD_LEFT_STILL, ResourceTools.loadImageFromResource("gingerland/gingerbread_left_still.png"));
        im.addImage(GINGERBREAD_LEFT_WALK1, ResourceTools.loadImageFromResource("gingerland/gingerbread_left_walk1.png"));
        im.addImage(GINGERBREAD_LEFT_WALK2, ResourceTools.loadImageFromResource("gingerland/gingerbread_left_walk2.png"));
        im.addImage(GINGERBREAD_RIGHT_STILL, ResourceTools.loadImageFromResource("gingerland/gingerbread_right_still.png"));
        im.addImage(GINGERBREAD_RIGHT_WALK, ResourceTools.loadImageFromResource("gingerland/gingerbread_right_walk.png"));
        im.addImage(GINGERBREAD_RIGHT_WALK2, ResourceTools.loadImageFromResource("gingerland/gingerbread_right_walk2.png"));

        frontImages = new ArrayList<>();
        frontImages.add(GINGERBREAD_FRONT_STILL);
        frontImages.add(GINGERBREAD_FRONT_WALK1);
        frontImages.add(GINGERBREAD_FRONT_WALK2);

        leftImages = new ArrayList<>(); 
        leftImages.add(GINGERBREAD_LEFT_STILL); 
        leftImages.add(GINGERBREAD_LEFT_WALK1);
        leftImages.add(GINGERBREAD_LEFT_WALK2);
        
        rightImages = new ArrayList<>();
        rightImages.add(GINGERBREAD_RIGHT_STILL);
        rightImages.add(GINGERBREAD_RIGHT_WALK);
        rightImages.add(GINGERBREAD_RIGHT_WALK2); 

        animator = new Animator(im, frontImages, 1000);
    }

    Animator animator;

    private static final String GINGERBREAD_FRONT_STILL = "GINGERBREAD_FRONT_STILL";
    private static final String GINGERBREAD_FRONT_WALK1 = "GINGERBREAD_FRONT_WALK1";
    private static final String GINGERBREAD_FRONT_WALK2 = "GINGERBREAD_FRONT_WALK2";
    private static ArrayList<String> frontImages;

    private static final String GINGERBREAD_LEFT_STILL = "GINGERBREAD_LEFT_STILL";
    private static final String GINGERBREAD_LEFT_WALK1 = "GINGERBREAD_LEFT_WALK1";
    private static final String GINGERBREAD_LEFT_WALK2 = "GINGERBREAD_LEFT_WALK2";
    private static ArrayList<String> leftImages;

    private static final String GINGERBREAD_RIGHT_STILL = "GINGERBREAD_RIGHT_STILL";
    private static final String GINGERBREAD_RIGHT_WALK = "GINGERBREAD_RIGHT_WALK";
    private static final String GINGERBREAD_RIGHT_WALK2 = "GINGERBREAD_RIGHT_WALK2";
    private static ArrayList<String> rightImages;

//<editor-fold defaultstate="collapsed" desc="Properties">
    private int x;
    private int y;
    private Direction direction;
    private Image image;
    private Image gingerbreadsprite1, gingerbreadsprite2, gingerbreadsprite3, gingerbreadsprite4, gingerbreadsprite5,
            gingerbreadsprite6, gingerbreadsprite7, gingerbreadsprite8, gingerbreadsprite9;

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

        if (direction == Direction.DOWN) {
            animator.setImageNames(frontImages);
        } else if (direction == Direction.LEFT) {
            animator.setImageNames(leftImages);
        } else if (direction == Direction.UP) {
            animator.setImageNames(frontImages);
        } else if (direction == Direction.RIGHT) {
            animator.setImageNames(rightImages);
        }
    }

    /**
     * @return the image
     */
    public Image getImage() {
        if (animator != null) {
            return animator.getCurrentImage();
        } else {
            return this.gingerbreadsprite1;
        }
    }

    /**
     * @param image the image to set
     */
    public void setImage(Image image) {
        this.image = image;
    }
//</editor-fold>

}
