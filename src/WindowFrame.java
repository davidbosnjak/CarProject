import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
public class WindowFrame extends JFrame implements KeyListener{
    WindowFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(null);
        this.addKeyListener(this);

        this.setVisible(true);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Pressed key: "+e.getKeyChar());

    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Released key: "+e.getKeyChar());
    }
}
