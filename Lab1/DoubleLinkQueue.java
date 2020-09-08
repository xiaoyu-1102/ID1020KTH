import java.util.Iterator;

public class DoubleLinkQueue<Item> implements Iterable<Item> {
    private DoubleLinkElement<Item> first;
    private int size;


    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    public DoubleLinkQueue(){
        first = null;
        size = 0;
    }


    public void append(Item item){
        if (isEmpty()){
            first = new DoubleLinkElement<Item>(null, null, item);
            first.next = first;
            first.prev = first;

        } else {
            DoubleLinkElement new_element = new DoubleLinkElement<Item>(first.prev, first, item);
            first.prev = new_element;
            new_element.prev.next = new_element;
        }
        size++;
    }

    // This inserts element to given position
    public void add(Item item, int k){
        if (k <= size) {

            DoubleLinkElement<Item> kth = first;

            for (int i = 0; i < k; i++) {
                kth = kth.next;
            }

            DoubleLinkElement new_element = new DoubleLinkElement<Item>(kth.prev, kth, item);
            kth.prev = new_element;
            new_element.prev.next = new_element;

            if (k == 0) {
                first = new_element;
            }

            size++;
        }
    }


    public void push(Item item){
        append(item);
        first = first.prev;
    }



    public Item pop (){
        if(!isEmpty()) {
            Item out = first.data;

            DoubleLinkElement<Item> last = first.prev;
            DoubleLinkElement<Item> new_first = first.next;

            last.next = new_first;
            new_first.prev = last;

            first = new_first;

            size--;

            if (size == 0) {
                first = null;
            }
            return out;
        }
        return null;
    }


    public Item delete (){
        if(!isEmpty()) {
            Item out = first.prev.data;

            DoubleLinkElement<Item> new_last = first.prev.prev;

            first.prev = new_last;
            new_last.next = first;

            size--;

            if (size == 0) {
                first = null;
            }
            return out;
        }
        return null;
    }

    public boolean isEmpty(){
        return size == 0;

    }

    public Item remove(int k){
        if (k < size) {

            DoubleLinkElement<Item> kth = first;

            for (int i = 0; i < k; i++) {
                kth = kth.next;
            }

            kth.prev.next = kth.next;
            kth.next.prev = kth.prev;

            size--;

            return kth.data;

        }

        return null;

    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("DLLIST( ");
        DoubleLinkElement<Item> curr = first;

        if (size == 0) {
            return out + ")";
        }

        for (int i = 0; i < size - 1; i++) {
            out.append(curr.toString()).append(", ");
            curr = curr.next;
        }

        out.append(curr.toString()).append(" )");

        return out.toString();
    }
}
