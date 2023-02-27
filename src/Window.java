import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Window extends JPanel{
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    final double SCREEN_WIDTH = screenSize.getWidth();
    final double SCREEN_HEIGHT = screenSize.getHeight();
    final int numOfNumbers = 512;
    int[] arrOfNumbers = new int[numOfNumbers];
    final double tileWidth = SCREEN_WIDTH / numOfNumbers;
    double tileHeight = 0;
    boolean running = false;
    Window() {
        this.setBackground(Color.gray);
        start_program();
    }

    void start_program() {
        for(int i = 0; i < arrOfNumbers.length; i++) {
            arrOfNumbers[i] = i + 1;
        }
        tileHeight = SCREEN_HEIGHT / Arrays.stream(arrOfNumbers).max().getAsInt();
        arrOfNumbers = shuffle_array(arrOfNumbers);
        running = true;
        bubble_sort(arrOfNumbers);
    }

    int[] shuffle_array(int[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }

    void bubble_sort(int[] arr) {
        int i, j;
        boolean swapped;
        for(i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for(j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j+1]) {
                    swapped = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    repaint();
                }
            }
            if (!swapped)
                break;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        if (!running) {
            return;
        }

        g.setColor(Color.white);
        for(int i = 0; i < arrOfNumbers.length; i++) {
            g.fillRect((int) Math.round(i * tileWidth), (int) Math.round(SCREEN_HEIGHT - (tileHeight * arrOfNumbers[i])), (int) Math.round(tileWidth), (int) Math.round(tileHeight * arrOfNumbers[i]));
        }
    }
}
