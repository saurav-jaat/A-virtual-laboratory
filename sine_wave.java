import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

class Diagram extends JPanel {
 static final int SCALEFACTOR = 1000;
 int cycles;
 int points;

 String code_word;
 double[] sines;
 int[] pts;
 Diagram() {
 
  }
  public  void setCycles(int newCycles) {
  cycles = newCycles;
  points = SCALEFACTOR * cycles * 2;
  sines = new double[points];
  for (int i = 0; i < points; i++) {
  double radians = (Math.PI / SCALEFACTOR) * i;
  sines[i] = Math.sin(radians);
  }
  repaint();
  }
  public void paintComponent(Graphics g) {
  super.paintComponent(g);
  int len = code_word.length();
  
  int maxWidth = getWidth();
  double hstep = (double) maxWidth / (double) points;
  int maxHeight = getHeight()/2;
  pts = new int[points];
 
  int bookmark = points/len;
  int count=0;
  for (int i = 0; i < points; i++)
  pts[i] = (int) (sines[i] * maxHeight / 2 * .95 + maxHeight / 2);
  g.setColor(Color.BLUE);
  for (int i = 1; i < points; i++) {
    int x1 = (int) ((i - 1) * hstep);
    int x2 = (int) (i * hstep);
    int y1,y2;
  if(code_word.charAt(count)=='1')
  {
   y1 = pts[i - 1];
   y2 = pts[i];
   
  }
  else
  {
     y1 = 0;
     y2 = 0;
    
  }
 
  g.drawLine(x1, y1, x2, y2);
  if(i%bookmark==0){
    if(count<len-1){
      g.setColor(Color.BLACK);
      count++;
      
      for(int y=0;y<getHeight();y=y+10){
        g.drawLine(x1,y,x1,y+3);}
      g.setColor(Color.BLUE);
     } 
   
    }
  
  }
  g.drawLine(0, maxHeight/2, maxWidth, maxHeight/2);
  
    
    
  }
  
}








public class sine_wave {
   String str;
   String code_word;
  sine_wave(String code_string)
  {
     this.code_word = code_string ;
  }

  public void draw_sine_wave()
  {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(500, 200);
    Diagram sines = new Diagram();
    sines.code_word=code_word;
    sines.setCycles(50);
    frame.getContentPane().add(sines);
    frame.setVisible(true);
    str = sines.code_word;
    System.out.println(str);
  }
 
 public static void main(String[] args) {
      sine_wave obj = new sine_wave("01010101011111100001010101");
      obj.draw_sine_wave();
  }
} 