import java.util.Iterator;

public class DoubleLinkList<Item> implements Iterable<Item> {
    private DoubleLinkElement<Item> first;
    private int size;


    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    public DoubleLinkList(){
        first = null;
        size = 0;
    }

    // This adds an element to the end
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

    // This adds an element to the beginning
    public void push(Item item){
        append(item);
        first = first.prev;
    }


    // This removes the first element
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

    // This removes the last element
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
