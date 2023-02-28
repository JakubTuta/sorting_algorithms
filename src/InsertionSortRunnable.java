public class InsertionSortRunnable implements Runnable {
    private final int[] arr;
    private final Window window;
    final int DELAY = 1;

    public InsertionSortRunnable(int[] arr, Window window) {
        this.arr = arr;
        this.window = window;
    }

    @Override
    public void run() {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;

                window.repaint();
                try {
                    Thread.sleep(DELAY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            arr[j + 1] = key;
        }
    }
}
