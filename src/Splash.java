import java.awt.*;
import javax.swing.*;
import java.awt.ScrollPane;
import java.awt.SplashScreen;

public class Splash {
	public static void main(String[] args)throws InterruptedException {
		  {
			 
		 Welcome frame = new Welcome(); 
		 frame.setUndecorated(true);
		 frame.setResizable(false);
		 frame.setLocation(400, 100);
		 frame.setVisible(true);
		 
	
		 
		 try {
			 for(int i=0;i<=100;i++) {
				 Thread.sleep(30);
				 if(i==100) {
					 SignUp home = new SignUp();
					 home.show();
					 frame.setVisible(false);
					 home.setLocation(200, 10);
					 frame.dispose();
					 frame.removeAll();
		 }}}
		 
		 catch(Exception e) {
			 
		 }
		 
		 
		 
			 
				 
				 
				 
					 
		

	}}}


