import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

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

        System.out.println("quit - exits program:");
        System.out.println("bubble - Bubble Sort");
        System.out.println("quick - Quick Sort:");
        System.out.println("insert - Insertion Sort:");
        System.out.println("select - Selection Sort:");
        System.out.println("bogo - Bogo Sort:");
        System.out.println("shaker - Shaker Sort:");
        System.out.println("radix - Radix Sort:");
        System.out.println("Choose sorting algorithm:");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        start_program(choice);
    }

    void start_program(String choice) {
        create_array();

        Thread thread = null;
        switch (choice) {
            case "bubble" -> thread = new Thread(new BubbleSortRunnable(arrOfNumbers, this));
            case "quick" -> thread = new Thread(new QuickSortRunnable(arrOfNumbers, this));
            case "insert" -> thread = new Thread(new InsertionSortRunnable(arrOfNumbers, this));
            case "select" -> thread = new Thread(new SelectionSortRunnable(arrOfNumbers, this));
            case "bogo" -> thread = new Thread(new BogoSortRunnable(arrOfNumbers, this));
            case "shaker" -> thread = new Thread(new ShakerSortRunnable(arrOfNumbers, this));
            case "radix" -> thread = new Thread(new RadixSortRunnable(arrOfNumbers, this));
            default -> System.exit(0);
        }
//        Thread thread = new Thread(new MergeSortRunnable(arrOfNumbers, this));
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