import java.util.Scanner;

class PQ12 {
    int[] H;  // Priority Queue Array
    int size; // Current size of the queue
    int capacity; // Capacity of the queue

    // Constructor to initialize the priority queue
    public PQ12(int capacity) {
        this.capacity = capacity;
        H = new int[capacity];
        size = -1;
    }

    public int Left_child(int i) {
        return (2 * i + 1);
    }

    public int Right_child(int i) {
        return (2 * i + 2);
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    // Insert an element into the priority queue
    public void insert(int p) {
        if (size == capacity - 1) {
            System.out.println("Priority Queue is full.");
            return;
        }
        size++;
        H[size] = p;
        Shiftup(size);
    }

    // Shift up to maintain the heap property
    public void Shiftup(int i) {
        while (i > 0 && H[parent(i)] < H[i]) {
            swap(parent(i), i);
            i = parent(i);
        }
    }

    // Swap elements in the array
    public void swap(int i, int j) {
        int temp = H[i];
        H[i] = H[j];
        H[j] = temp;
    }

    // Display the elements of the priority queue
    public void display() {
        if (size == -1) {
            System.out.println("Priority Queue is empty.");
            return;
        }
        for (int i = 0; i <= size; i++) {
            System.out.print(H[i] + " ");
        }
        System.out.println();
    }

    // Get the maximum element (root of the max heap)
    public int getMax() {
        if (size == -1) {
            System.out.println("Priority Queue is empty.");
            return -1;
        }
        return H[0];
    }

    // Extract the maximum element (root) and maintain the heap
    public int extractMax() {
        if (size == -1) {
            System.out.println("Priority Queue is empty.");
            return 0;
        }
        int result = H[0];
        System.out.println("Max Element: " + result);
        H[0] = H[size];
        size--;
        ShiftDown(0);
        return result;
    }

    // Shift down to maintain the heap property after extraction
    public void ShiftDown(int i) {
        int maxIndex = i;
        int left = Left_child(i);
        if (left <= size && H[left] > H[maxIndex]) {
            maxIndex = left;
        }
        int right = Right_child(i);
        if (right <= size && H[right] > H[maxIndex]) {
            maxIndex = right;
        }
        if (i != maxIndex) {
            swap(i, maxIndex);
            ShiftDown(maxIndex);
        }
    }

    public void changePriority(int i, int New_P){
        int Old_P = H[i];
        H[i]= New_P;
        if(Old_P<New_P){
            Shiftup(i);
        }
        else{
            ShiftDown(i);
        }
    }

}

public class Priority_Queue {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the capacity of the priority queue: ");
        int capacity = s.nextInt();
        PQ12 pq = new PQ12 (capacity);

        int b;
        do {
            System.out.println("Operations:\n1) Insert\n2) Display\n3)Extract Max\n4)Max Element\n5)Change Priority\n6) Exit");
            System.out.println("Enter your choice:");
            int choice = s.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the number of keys:");
                    int n = s.nextInt();
                    System.out.println("Enter keys to insert:");
                    for (int i = 0; i < n; i++) {
                        int key = s.nextInt();
                        pq.insert(key);
                    }
                    break;
                case 2:
                    System.out.println("Displaying Priority Queue...");
                    pq.display();
                    break;
                case 3:
                    pq.extractMax();
                    break;
                case 4:
                    System.out.println("Maximum Element: " + pq.getMax());
                    break;
                case 5:
                    System.out.println("Enter the index of the element to change the priority: ");
                    int i = s.nextInt();
                    System.out.println("Enter the new key :");
                    int N = s.nextInt();
                    pq.changePriority(i,N);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            System.out.println("Enter 1 to continue and 0 to stop:");
            b = s.nextInt();
        } while (b != 0);
    }
}