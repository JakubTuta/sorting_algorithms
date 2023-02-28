public class SelectionSortRunnable implements Runnable {
    private final int[] arr;
    private final Window window;
    final int DELAY = 1;

    public SelectionSortRunnable(int[] arr, Window window) {
        this.arr = arr;
        this.window = window;
    }

    @Override
    public void run() {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;

                window.repaint();
                try {
                    Thread.sleep(DELAY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}