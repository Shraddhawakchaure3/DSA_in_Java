import java.util.*;
class HashTable {
    private LinkedList<Integer>[] table;
    private int size;

    @SuppressWarnings("unchecked")

    public HashTable(int size) {
        this.size = size;
        table = new LinkedList[size];
        for(int i=0; i<size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hashFunction(int key) {
        return key % size;
    }

    public void insert(int key) {
        int index = hashFunction(key);

        table[index].add(key);
    }
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print("Index " + i + ": ");

            for(Integer key:table[i]) {
                System.out.println(key + "->");
            }
            System.out.println("null");

        }
    }

    public boolean search(int key) {
        int index = hashFunction(key);
        return table[index].contains(key);

    }

}
public class ChainingWithoutReplacement {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the size of Hash Table: ");
        int size = s.nextInt();
        HashTable h = new HashTable(size);

        System.out.println("Enter the number of key  to insert: ");
        int n =s.nextInt();

        System.out.println("Enter the key : ");
        for(int i=0; i<n; i++) {
            int key = s.nextInt();
            h.insert(key);
        }

        System.out.println("Hash Table:");
        h.display();

        System.out.println("Enter the key which you want to search:");
        int keyTosearch = s.nextInt();
        if(h.search(keyTosearch)) {
            System.out.println(keyTosearch + "Found in the hash table");
        }
        else {
            System.out.println(keyTosearch + "not found in the hash table");
        }
    }
}