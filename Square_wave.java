import java.awt.Graphics;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Square_wave extends JPanel
{ 
  
   String dataword = "0101101000111010";
   Square_wave(String st)
   {
      dataword = st;
   }
   public void paint(Graphics g)
   {
   
   int st_x = 25;
   int st_y = 25 ;
   
   for(int x=0;x<dataword.length();x++)
      {  
      for(int y=0;y<getHeight();y=y+10){
      g.drawLine(st_x,y,st_x,y+3);
      
      }
      if(dataword.charAt(x)=='0')
      {         st_y=50;
               
         g.drawLine(st_x,st_y,st_x+25,st_y); 
         st_x+=25;     
      }
      else
      { 
         st_y=25;
         if(x>0){
         if(dataword.charAt(x-1)=='0')
         g.drawLine(st_x,50,st_x,25);} //up
         g.drawLine(st_x,st_y,st_x+25,st_y); //mid
         st_x+=25;  
         if(x<dataword.length()-1){
         if(dataword.charAt(x+1)=='0')
         g.drawLine(st_x,25,st_x,50); //down
         
      }
      
      }
    
    }
   }
   public void draw_square_wave(String st)
   {

      JFrame frame =new JFrame();
      frame.getContentPane().add(new Square_wave(st));
  
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.setSize(200,200);
      frame.setVisible(true);
   }
   public static void main(String args[])
   {  
  
   
    
   }
}
