
public class DoubleLinkSorted {
    private DoubleLinkElement<Integer> first;
    private int size;


    public DoubleLinkSorted(){
        first = null;
        size = 0;
    }


    public void append(int item){
        if (isEmpty()){
            first = new DoubleLinkElement<Integer>(null, null, item);
            first.next = first;
            first.prev = first;

            size++;
        } else {

            int pos = getPos(item);

            System.out.println(pos);

            add(item, pos);
        }
    }

    /*
    This get the position for the element by comparing with
    previous items until find one bigger than it.
     */
    private int getPos(int item) {

        DoubleLinkElement<Integer> el = first;

        for (int i = 0; i < size; i++) {
            if (el.data > item) {
                return i;
            }

            el = el.next;
        }

        return size;
    }


    private void add(int item, int k){
        if (k <= size) {

            DoubleLinkElement<Integer> kth = first;

            for (int i = 0; i < k; i++) {
                kth = kth.next;
            }

            DoubleLinkElement new_element = new DoubleLinkElement<Integer>(kth.prev, kth, item);
            kth.prev = new_element;
            new_element.prev.next = new_element;

            if (k == 0) {
                first = new_element;
            }

            size++;
        }
    }


    public int pop (){
        if(!isEmpty()) {
            int out = first.data;

            DoubleLinkElement<Integer> last = first.prev;
            DoubleLinkElement<Integer> new_first = first.next;

            last.next = new_first;
            new_first.prev = last;

            first = new_first;

            size--;

            if (size == 0) {
                first = null;
            }
            return out;
        }
        return 0;
    }


    public int delete (){
        if(!isEmpty()) {
            int out = first.prev.data;

            DoubleLinkElement<Integer> new_last = first.prev.prev;

            first.prev = new_last;
            new_last.next = first;

            size--;

            if (size == 0) {
                first = null;
            }
            return out;
        }
        return 0;
    }

    public boolean isEmpty(){
        return size == 0;

    }

    public int remove(int k){
        if (k < size) {

            DoubleLinkElement<Integer> kth = first;

            for (int i = 0; i < k; i++) {
                kth = kth.next;
            }

            kth.prev.next = kth.next;
            kth.next.prev = kth.prev;

            size--;

            return kth.data;

        }

        return 0;

    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("DLLIST( ");
        DoubleLinkElement<Integer> curr = first;

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
