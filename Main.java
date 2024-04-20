import java.util.LinkedList;

class Node {
    int value;
    Node next;

    Node(int x) {
        value = x;
        next = null;
    }
}

class Hashing {
    LinkedList<Node>[] HashTable;

    Hashing() {
        HashTable = new LinkedList[10];
        for (int i = 0; i < 10; i++) {
            HashTable[i] = new LinkedList<>();
        }
    }

    int hashFunction(int value) {
        return value % 10;
    }

    void insertElement(int value) {
        int hashVal = hashFunction(value);
        HashTable[hashVal].addLast(new Node(value));
    }

    void display() {
        for (int i = 0; i < 10; i++) {
            System.out.print("a[" + i + "] : ");
            for (Node temp : HashTable[i]) {
                System.out.print(" ->" + temp.value);
            }
            System.out.println();
        }
    }

    int searchElement(int value) {
        boolean flag = false;
        int hashVal = hashFunction(value);
        for (Node entry : HashTable[hashVal]) {
            if (entry.value == value) {
                System.out.println("\nElement found at : " + hashVal + " : " + entry.value);
                flag = true;
            }
        }
        if (!flag)
            return -1;
        return 0;
    }

    void deleteElement(int value) {
        int hashVal = hashFunction(value);
        LinkedList<Node> list = HashTable[hashVal];
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).value == value) {
                list.remove(i);
                System.out.println("Phno. Deleted");
                return;
            }
        }
        System.out.println("No Element found");
    }
}

public class Main {
    public static void main(String[] args) {
        int ch;
        int data, search, del;
        Hashing h = new Hashing();
        do {
            System.out.println("\nTelephone : \n1.Insert \n2.Display \n3.Search \n4.Delete \n5.Exit \n\n OPTION: ");
            ch = Integer.parseInt(System.console().readLine());
            switch (ch) {
                case 1:
                    System.out.println("\nEnter phone no. to be inserted : ");
                    data = Integer.parseInt(System.console().readLine());
                    h.insertElement(data);
                    break;
                case 2:
                    h.display();
                    break;
                case 3:
                    System.out.println("\nEnter the no to be searched : ");
                    search = Integer.parseInt(System.console().readLine());
                    if (h.searchElement(search) == -1) {
                        System.out.println("No element found at key ");
                        continue;
                    }
                    break;
                case 4:
                    System.out.println("\nEnter the phno. to be deleted : ");
                    del = Integer.parseInt(System.console().readLine());
                    h.deleteElement(del);
                    break;
            }
        } while (ch != 5);
    }
}

