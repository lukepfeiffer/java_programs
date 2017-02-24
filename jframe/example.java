import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class ExampleJFrame{
  public static void main(String args[]){
    JFrame window = new JFrame("Basic JFrame example");
    window.addWindowListener(new WindowAdapter(){
      public void windowClosing(WindowEvent event){
        System.exit(0);
      }
    });
    JLabel jlbempty = new JLabel("Some JLabel");
    window.getContentPane().add(jlbempty, BorderLayout.CENTER);
    window.pack();
    window.setVisible(true);
    window.setSize(300,300);
  }
}
