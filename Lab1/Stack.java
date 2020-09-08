import java.util.Arrays;
import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
    Item arr[];
    int head;

    @Override
    public Iterator<Item> iterator() {
        return Arrays.stream(arr).iterator();
    }

    public Stack(int size){
        arr = (Item[]) new Object[size];
        head = -1;
    }

    public boolean isFull() {
        return head >= arr.length - 1;
    }
    public void push(Item item){
        if (!isFull()){
            arr[++head] = item;
        }
    }

    public Item pop(){
        if (!isEmpty()) {
            return arr[head--];
        }
        return null;
    }

    public boolean isEmpty(){
        return head == -1;
    }

    public int size(){
        return head + 1;
    }

}
