// Sapike Sakshi Dinesh
// S3B 118 SY

import java.util.Scanner;

class HeapOperation {


    static void minHeapify(int arr[], int n, int i) {
        int smallest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] < arr[smallest])
            smallest = l;

        if (r < n && arr[r] < arr[smallest])
            smallest = r;

        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            minHeapify(arr, n, smallest);
        }
    }

    static void buildMinHeap(int arr[], int n) {
        int startIdx = (n / 2) - 1;

        for (int i = startIdx; i >= 0; i--) {
            minHeapify(arr, n, i);
        }
    }

    // Max Heap implementation
    static void maxHeapify(int arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            maxHeapify(arr, n, largest);
        }
    }

    static void buildMaxHeap(int arr[], int n) {
        int startIdx = (n / 2) - 1;

        for (int i = startIdx; i >= 0; i--) {
            maxHeapify(arr, n, i);
        }
    }

    static void printHeap(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter the elements: ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Choose Heap Type:");
        System.out.println("1. Min Heap");
        System.out.println("2. Max Heap");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                buildMinHeap(arr, size);
                System.out.println("Min Heap array: ");
                printHeap(arr, size);
                break;
            case 2:
                buildMaxHeap(arr, size);
                System.out.println("Max Heap array: ");
                printHeap(arr, size);
                break;
            default:
                System.out.println("Invalid choice. Please enter 1 for Min Heap or 2 for Max Heap.");
                break;
        }


    }
}