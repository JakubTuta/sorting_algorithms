import javax.swing.*;
import java.awt.GraphicsEnvironment;
public class GameFrame extends JFrame{
    GameFrame() {
        this.add(new Window());
        this.setTitle("Sorting algorithms");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(this);
    }
}
