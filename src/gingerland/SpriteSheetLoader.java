/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gingerland;

import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author sofialuzgalbanpatterson
 */
public class SpriteSheetLoader {

    BufferedImage spriteSheet = ImageIO.read(new File("gingerbread_sprite_sheet.png"));

    int width;
    int height;
    int rows;
    int columns;
    BufferedImage[] sprites; 
    

    public SpriteSheetLoader(int width, int height, int rows, int columns) throws IOException {
        this.width = width;
        this.height = height;
        this.rows = rows;
        this.columns = columns;
        
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sprites[(i * columns) + j] = spriteSheet.getSubimage(i * width, j * height, width , height); 
                
            }
            
        }

    }
    
    public void paint(Graphics g) {
        g.drawImage(sprites[1], 100, 100, null); 
    }

}
