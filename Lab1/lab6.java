public class lab6 {
    public static void main(String[] args) {

        DoubleLinkSorted list = new DoubleLinkSorted();
        //Test append, result should be sorted, also the position for each element should printed each time
        list.append(3);
        System.out.println(list.toString());
        list.append(2);
        System.out.println(list.toString());
        list.append(4);
        System.out.println(list.toString());
        list.append(3);
        System.out.println(list.toString());
        list.append(8);
        System.out.println(list.toString());
        list.append(1);
        System.out.println(list.toString());
        list.append(7);
        System.out.println(list.toString());
        list.append(-2);
        System.out.println(list.toString());

    }

}
