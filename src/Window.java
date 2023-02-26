import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Window extends JPanel{
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    final double SCREEN_WIDTH = screenSize.getWidth();
    final double SCREEN_HEIGHT = screenSize.getHeight();
    final int numOfNumbers = 512;
    int[] arrOfNumbers = new int[numOfNumbers];
    final double tileWidth = SCREEN_WIDTH / numOfNumbers;
    double tileHeight = 0;
    Window() {
        this.setBackground(Color.gray);
        for(int i = 0; i < 512; i++) {
            arrOfNumbers[i] = i + 1;
        }
        tileHeight = SCREEN_HEIGHT / Arrays.stream(arrOfNumbers).max().getAsInt();
    }
}
