
public class DoubleLinkElement<Item> {
    public DoubleLinkElement<Item> prev;
    public DoubleLinkElement<Item> next;
    public Item data;

    public DoubleLinkElement(DoubleLinkElement prev, DoubleLinkElement next, Item data) {
        this.prev = prev;
        this.next = next;
        this.data = data;
    }

    @Override
    public String toString() {
        return "[" + data.toString() + "]";
    }
}
