import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class main{ static int count=0;
  static  String to_demodulate = "";
public static void main(final String args[]) {
 
  final JFrame frame = new JFrame("My first GUI");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setSize(250, 400);
  frame.setBackground(Color.pink);
  final JPanel panel = new JPanel();
  ////////////// buttons ////////////////
  final JButton square_wave = new JButton("Square wave");
  final JButton modulate = new JButton("Modulate(ASK)");
  final JButton demodulate = new JButton("Demodulate(ASK)");

  ////////////// Labels ////////////////
  final JLabel codeword_label = new JLabel("Enter your codeword here");
  final JLabel frequency_label = new JLabel("Enter the frequency for Carrier wave");
  final JLabel amplitude_label = new JLabel("Enter the Peak to peak amplitude");

  ////////////// TextViews ////////////////
  final JTextField codeword = new JTextField(20);
  final JTextField frequency = new JTextField(10);
  final JTextField amplitude = new JTextField(10);

  square_wave.addActionListener(new ActionListener() {
    public void actionPerformed(final ActionEvent e) {

      final Square_wave obj = new Square_wave(codeword.getText());
      obj.draw_square_wave(codeword.getText());

    }
  });
  modulate.addActionListener(new ActionListener() {
    public void actionPerformed(final ActionEvent e) {
      final sine_wave objd = new sine_wave(codeword.getText());
      objd.draw_sine_wave();
      to_demodulate = objd.str;
      System.out.print(to_demodulate);

    }
  });
  demodulate.addActionListener(new ActionListener() {
    public void actionPerformed(final ActionEvent e) {
      if(!to_demodulate.matches(""))
      {
        final Square_wave obj = new Square_wave(to_demodulate);
      obj.draw_square_wave(to_demodulate);
      } else {
        System.out.println("Please first modulate the signal.");
      }
       
      }
    });
panel.add(codeword_label);
panel.add(codeword);
panel.add(amplitude_label);
panel.add(amplitude);
panel.add(frequency_label);
panel.add(frequency);
panel.add(square_wave);
panel.add(modulate);
panel.add(demodulate);
frame.add(panel);
frame.setVisible(true);
}
}
