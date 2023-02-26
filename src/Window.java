import javax.swing.*;
import java.awt.*;

public class Window extends JPanel{
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    final int SCREEN_WIDTH = (int)screenSize.getWidth();
    final int SCREEN_HEIGHT = (int)screenSize.getHeight();
    Window() {
        this.setBackground(Color.gray);
    }
}
