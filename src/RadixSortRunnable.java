public class RadixSortRunnable implements Runnable {
    private final int[] arr;
    private final Window window;
    final int DELAY = 1;

    public RadixSortRunnable(int[] arr, Window window) {
        this.arr = arr;
        this.window = window;
    }

    @Override
    public void run() {
        int max = getMax();
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(exp);
        }
    }

    public int getMax() {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public void countingSort(int exp) {
        int[] count = new int[10];
        int[] output = new int[arr.length];

        for (int j : arr) {
            int digit = (j / exp) % 10;
            count[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];

            window.repaint();
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}