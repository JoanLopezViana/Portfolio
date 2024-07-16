/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajo.utils;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

/**
 *
 * @author Victor
 */
public class Cosas {
    
    
    public static ImageView circularCutout(ImageView image) {
        double originalWidth = image.getFitWidth();
        double originalHeight = image.getFitHeight();
        image.setPreserveRatio(false);

        double minSize = Math.min(originalWidth, originalHeight);

        Circle clip = new Circle();
        clip.setCenterX(originalWidth / 2); 
        clip.setCenterY(originalHeight / 2); 
        clip.setRadius(minSize / 2); 

        
        image.setClip(clip);
        return image;
    }
    
}
