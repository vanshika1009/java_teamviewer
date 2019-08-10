import com.vmm.JHTTPServer;
import com.vmm.NanoHTTPD;
import static com.vmm.NanoHTTPD.HTTP_OK;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.util.Properties;
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
 * @author DELL
 */
public class serverforteamviewer extends JHTTPServer
{
    
    public serverforteamviewer(int port) throws IOException {
        super(port);
    }
    @Override
    public Response serve(String uri, String method, Properties header,
            Properties parms, Properties files)
    {

        Response res = null;

        System.out.println("URI " + uri);

        if (uri.contains("/savescreenshot")) {

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
            Rectangle capture
                    = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage Image = r.createScreenCapture(capture);
            try {
                ImageIO.write(Image, "jpg", new File(path));
            } catch (IOException ex) {
                Logger.getLogger(screenshot.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Screenshot saved");
            res = new Response(HTTP_OK, "text/plain", "Screenshot saved");
        } 
        else if (uri.contains("/GetResource")) //request should be of the form /GetResource/src/content/one.jpg
        {
            uri = uri.substring(1);
            uri = uri.substring(uri.indexOf("/") + 1);
            System.out.println(uri +" * " );
            res = sendCompleteFile(uri);
        } 
        else {
            res = new Response(HTTP_OK, "text/html", "<body style='background: #D46A6A; color: #fff'><center><h1>Hello</h1><br> <h3>Welcome To JHTTP Server (Version 1.0)</h3></body></center>");

        }

        return res;
    }
}
