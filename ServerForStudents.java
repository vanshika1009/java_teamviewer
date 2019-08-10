
import com.vmm.JHTTPServer;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.*;
import java.net.InetAddress;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerForStudents extends JHTTPServer {

    public ServerForStudents(int port) throws IOException {
        super(port);
    }

    /**
     * This is the common function which will receive the client's request and
     * will serve the response accordingly. for e.g 1. if request is for
     * /GetResource( image preview / any file download ) call
     * sendCompleteFile(uri) 2. if request is for /StreamMedia ( stream audio /
     * video ) call streamFile(uri,method,header) 3. in case of any other custom
     * request prepare your own response and return
     *
     * NOTE: In case of File upload (client to server) call any of the two
     * functions 1. saveFileOnServerWithOriginalName(files,parms,name,abspath)
     * 1. saveFileOnServerWithRandomName(files,parms,name,abspath)
     *
     *
     * @param uri will contain the extracted uri from the complete URL for e.g
     * (/GetResource/c1.jpg) (/GetResource/one.mp3) (/StreamMedia/ome.mp4)
     * @param method contains GET,POST,HEAD
     * @param header contains the extra header data (range, user-agent etc)
     * @param parms contains the query string parameters to extract text data
     * e.g String email = parms.getProperty("email");
     *
     * @param files contains the files in form of file upload(POST request)
     * filename = saveFileOnServerWithRandomName(files, parms, field_name,
     * abs_path);
     * @return
     */
    @Override
    public Response serve(String uri, String method, Properties header,
            Properties parms, Properties files) {

        Response res = null;

        System.out.println("URI " + uri);

        if (uri.contains("/GetResource")) //request should be of the form /GetResource/src/content/one.jpg
        {
            uri = uri.substring(1);
            uri = uri.substring(uri.indexOf("/") + 1);
            System.out.println(uri + " *** ");
            res = sendCompleteFile(uri);
        } else if (uri.contains("/StreamMedia")) //request should be of the form /GetResource/one.jpg
        {
            uri = uri.substring(1);
            uri = uri.substring(uri.indexOf("/") + 1);
            System.out.println(uri + " *** ");
            res = streamFile(uri, method, header);
        } else if (uri.contains("/checklogin")) {
            String u = parms.getProperty("user");
            String p = parms.getProperty("pass");

            System.out.println(u + " " + p);

            /*
            if(u.equals("abc") && p.equals("123"))
              res = new Response(HTTP_OK, "text/plain", "Login Successfull !!!");
            else
                  res = new Response(HTTP_OK, "text/plain", "Login Failed !!!");
             */
            try {
                ResultSet rs = DBLoader.executeQuery("select * from users where username=\'" + u + "\' and password=\'" + p + "\'");

                if (rs.next()) {
                    res = new Response(HTTP_OK, "text/plain", "Login Successfull !!!");
                } else {
                    res = new Response(HTTP_OK, "text/plain", "Login Failed !!!");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (uri.contains("/uploadfile")) {
            String a = parms.getProperty("a");
            String f1 = files.getProperty("f1");

            System.out.println("--- File Upload Example ---");
            System.out.println(a);
            System.out.println(f1);

            saveFileOnServerWithRandomName(files, parms, "f1", "src/uploaded_pics");

            System.out.println("File Saved on Server");
        } else if (uri.contains("/connect")) {
            String osname = System.getProperty("os.name");
            try {
                String systemName = InetAddress.getLocalHost().getHostName();
                String ans = systemName + "," + osname + "";
                res = new Response(HTTP_OK, "text/html", ans);
            } catch (Exception E) {
                System.err.println("System Name Exp : " + E.getMessage());

            }

        } else if (uri.contains("/login")) {

            try {
                String username = parms.getProperty("username");
                String password = parms.getProperty("password");
                System.out.println(username);
                System.out.println(password);
                File f = new File("E:\\teamviewerfile\\user.txt");
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                while (true) {
                    String s1 = br.readLine();
                    String s2 = br.readLine();
                    System.out.println(s1 + "--" + s2);
                    String u = s1.substring(s1.indexOf("=") + 2);
                    String p = s2.substring(s2.indexOf("=") + 2);

                    System.out.println("Saved UP: " + u + "--" + p);

                    if (u.equals(username) && p.equals(password)) {
                        InetAddress ip = InetAddress.getLocalHost();
                        String nameOS = System.getProperty("os.name");
                        String osType = System.getProperty("os.arch");
                        String osVersion = System.getProperty("os.version");
                        /* Total number of processors or cores available to the JVM */
                        int processors = Runtime.getRuntime().availableProcessors();
                        /* Total amount of free memory available to the JVM */
                        long freememory = Runtime.getRuntime().freeMemory();
                        /* This will return Long.MAX_VALUE if there is no preset limit */
                        long maxMemory = Runtime.getRuntime().maxMemory();
                        /* Maximum amount of memory the JVM will attempt to use */
                        long runtimememory = Runtime.getRuntime().totalMemory();
                        String ans = "login successful";
                        ans = ans + "," + ip + "," + nameOS + "," + osType + "," + osVersion + "," + processors + "," + freememory + "," + maxMemory + "," + runtimememory;
                        res = new Response(HTTP_OK, "text/plain", ans);
                        System.out.println("inside equals");
                    } else {
                        res = new Response(HTTP_OK, "text/plain", "username or password not correct");

                    }
                    if (br.readLine() == null) {
                        break;
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (uri.contains("/shutdown")) {
            try {
                res = new Response(HTTP_OK, "text/html", "Shut down successfull! ");
                Runtime runtime = Runtime.getRuntime();
                Process proc = runtime.exec("shutdown -s -t 0");
                System.exit(0);

            } catch (IOException ex) {
                Logger.getLogger(homescreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.contains("/logoff")) {
            try {
                res = new Response(HTTP_OK, "text/html", "Log off successfull! ");
                String shutdownCmd = "shutdown -l";
                Process child = Runtime.getRuntime().exec(shutdownCmd);
            } catch (IOException ex) {
                Logger.getLogger(ServerForStudents.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.contains("/restart")) {
            Runtime rt = Runtime.getRuntime();
            try {
                res = new Response(HTTP_OK, "text/html", "Shut down successfull! ");
                Process pr1 = rt.exec("cmd /c shutdown -r");
                System.out.println("res");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.contains("/showmessage")) {
            String msg = parms.getProperty("msg");
            MessageForm mf = new MessageForm(msg);
            mf.setVisible(true);

            String ans = "Message sent";
            res = new Response(HTTP_OK, "text/plain", "Message Sent");

        } else if (uri.contains("/screensize")) {
            int server_width;
            int server_hieght;

            // java - get screen size using the Toolkit class
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

            // the screen height
            server_hieght = (int) screenSize.getHeight();

            // the screen width
            server_width = (int) screenSize.getWidth();

            String ans = server_hieght + "," + server_width;

            res = new Response(HTTP_OK, "text/plain", ans);

        } else if (uri.contains("/mousemoved")) {
            try {
                int x = Integer.parseInt(parms.getProperty("x"));
                int y = Integer.parseInt(parms.getProperty("y"));
                Robot rb = new Robot();
                rb.mouseMove(x, y);
                res = new Response(HTTP_OK, "text/plain", "coordinates recieved");
            } catch (AWTException ex) {
                Logger.getLogger(ServerForStudents.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (uri.contains("/mousedragged")) {
            try {
                int x = Integer.parseInt(parms.getProperty("x"));
                int y = Integer.parseInt(parms.getProperty("y"));
                Robot rb = new Robot();
                rb.mousePress(MouseEvent.BUTTON1_MASK);
                rb.mouseMove(x, y);
            } catch (AWTException ex) {
                Logger.getLogger(ServerForStudents.class.getName()).log(Level.SEVERE, null, ex);
            }
            res = new Response(HTTP_OK, "text/plain", "coordinates recieved");

        } else if (uri.contains("/mouseclicked")) {
            try {
                int bt = Integer.parseInt(parms.getProperty("bt"));
                Robot rb = new Robot();

                if (bt == MouseEvent.BUTTON1) {
                    rb.mousePress(MouseEvent.BUTTON1_MASK);
                    rb.mouseRelease(MouseEvent.BUTTON1_MASK);
                } else if (bt == MouseEvent.BUTTON2) {
                    rb.mousePress(MouseEvent.BUTTON2_MASK);
                    rb.mouseRelease(MouseEvent.BUTTON2_MASK);
                } else {
                    rb.mousePress(MouseEvent.BUTTON3_MASK);
                    rb.mouseRelease(MouseEvent.BUTTON3_MASK);
                }
                res = new Response(HTTP_OK, "text/plain", "coordinates recieved");
            } catch (AWTException ex) {
                Logger.getLogger(ServerForStudents.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }  else if (uri.contains("/mousereleased")) {
            try {
                int bt = Integer.parseInt(parms.getProperty("bt"));
                Robot rb = new Robot();

                if (bt == MouseEvent.BUTTON1) {
                    rb.mouseRelease(MouseEvent.BUTTON1_MASK);
                } else if (bt == MouseEvent.BUTTON2) {
                    rb.mouseRelease(MouseEvent.BUTTON2_MASK);
                } else {
                    rb.mouseRelease(MouseEvent.BUTTON3_MASK);
                }
            } catch (AWTException ex) {
                Logger.getLogger(ServerForStudents.class.getName()).log(Level.SEVERE, null, ex);
            }
            res = new Response(HTTP_OK, "text/plain", "mouse released");
        } else if (uri.contains("/keyreleased")) {
            try {
                int key = Integer.parseInt(parms.getProperty("k"));
                Robot rb = new Robot();

                rb.keyPress(key);
                rb.keyRelease(key);
            } catch (AWTException ex) {
                Logger.getLogger(ServerForStudents.class.getName()).log(Level.SEVERE, null, ex);
            }
            res = new Response(HTTP_OK, "text/plain", "coordinates recieved");
        } else {
            res = new Response(HTTP_OK, "text/html", "<body style='background: #D46A6A; color: #fff'><center><h1>Hello</h1><br> <h3>Welcome To JHTTP Server (Version 1.0)</h3></body></center>");
        }
        return res;
    }
}
