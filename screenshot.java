import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vedantmahajan
 */
public class screenshot {
    
    
    public static void main(String[] args) 
    {
        
        
    { 
        try { 
            Thread.sleep(120);
        } catch (InterruptedException ex) {
            Logger.getLogger(screenshot.class.getName()).log(Level.SEVERE, null, ex);
        }
            Robot r = null; 
        try {
            r = new Robot();
        } catch (AWTException ex) {
            Logger.getLogger(screenshot.class.getName()).log(Level.SEVERE, null, ex);
        }
  
            // It saves screenshot to desired path 
            String path = "src/pics/screenshot.jpg"; 
  
            // Used to get ScreenSize and capture image 
            Rectangle capture =  
            new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); 
            BufferedImage Image = r.createScreenCapture(capture); 
        try { 
            ImageIO.write(Image, "jpg", new File(path));
        } catch (IOException ex) {
            Logger.getLogger(screenshot.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println("Screenshot saved"); 
        } 
        
    }
        
    
//        catch (AWTException | IOException | InterruptedException ex) { 
//            System.out.println(ex); 
//        } 
    
}