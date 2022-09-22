import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
public class WindowFrame extends JFrame implements KeyListener{
    WindowFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(null);
        this.addKeyListener(this);
        CarInterface cinterface = new CarInterface();
        this.setVisible(true);
    }


    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Typed key: "+e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Pressed key: "+e.getKeyChar());
        if(e.getKeyChar() == 'c'){

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Released key: "+e.getKeyChar());
    }
}
