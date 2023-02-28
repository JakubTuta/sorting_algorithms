public class CombSortRunnable implements Runnable {
    private final int[] arr;
    private final Window window;
    final int DELAY = 1;

    public CombSortRunnable(int[] arr, Window window) {
        this.arr = arr;
        this.window = window;
    }

    @Override
    public void run() {
        int gap = arr.length;
        double shrink = 1.3;
        boolean swapped = true;
        while (gap > 1 || swapped) {
            gap = (int) (gap / shrink);
            if (gap < 1) {
                gap = 1;
            }
            swapped = false;
            for (int i = 0; i + gap < arr.length; i++) {
                if (arr[i] > arr[i + gap]) {
                    int temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;
                    swapped = true;
                }

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