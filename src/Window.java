import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class Window extends JPanel {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    final double SCREEN_WIDTH = screenSize.getWidth();
    final double SCREEN_HEIGHT = screenSize.getHeight();
    final int numOfNumbers = 1000;
    int[] arrOfNumbers = new int[numOfNumbers];
    final double tileWidth = SCREEN_WIDTH / numOfNumbers;
    double tileHeight = 0;

    Window() {
        this.setBackground(Color.gray);
        start_program();
    }

    void start_program() {
        create_array();
        Thread thread = new Thread(new QuickSortRunnable(arrOfNumbers, this));
        thread.start();
    }

    void create_array() {
        for (int i = 0; i < arrOfNumbers.length; i++) {
            arrOfNumbers[i] = i + 1;
        }
        tileHeight = SCREEN_HEIGHT / Arrays.stream(arrOfNumbers).max().getAsInt();
        shuffle_array(arrOfNumbers);
    }

    void shuffle_array(int[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        for (int i = 0; i < arrOfNumbers.length; i++) {
            g.fillRect(
                    (int) Math.round(i * tileWidth),
                    (int) Math.round(SCREEN_HEIGHT - (tileHeight * arrOfNumbers[i])),
                    (int) Math.round(tileWidth),
                    (int) Math.round(tileHeight * arrOfNumbers[i]));
        }
    }
}