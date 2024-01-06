import java.util.Arrays;
import java.util.Scanner;

class QuickSortExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter the elements of the array:");

        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Original array: " + Arrays.toString(arr));

        // Best case: Already sorted array
        quickSort(arr, 0, size - 1);
        System.out.println("Best case (sorted array): " + Arrays.toString(arr));

        // Worst case: Reverse sorted array
        reverseArray(arr);
        quickSort(arr, 0, size - 1);
        System.out.println("Worst case (reverse sorted array): " + Arrays.toString(arr));

        // Average case: Randomized array
        shuffleArray(arr);
        quickSort(arr, 0, size - 1);
        System.out.println("Average case (randomized array): " + Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    private static void reverseArray(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }

    private static void shuffleArray(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int index = (int) (Math.random() * (i + 1));
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }
}