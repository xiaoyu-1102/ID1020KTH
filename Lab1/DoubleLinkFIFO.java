import java.util.Iterator;

public class DoubleLinkFIFO<Item> implements Iterable<Item> {
    private DoubleLinkElement<Item> first;
    private int size;


    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    public DoubleLinkFIFO(){
        first = null;
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;

    }

    public void enqueue(Item item){
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

    public Item dequeue (){
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


    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("DLFIFO( ");
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
