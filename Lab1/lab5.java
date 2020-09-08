public class lab5 {
    public static void main(String[] args) {

        DoubleLinkQueue<Character> list = new DoubleLinkQueue<>();

        list.append('s');
        System.out.println(list.toString());
        list.append('o');
        System.out.println(list.toString());
        list.append('r');
        System.out.println(list.toString());
        list.append('g');
        System.out.println(list.toString());
        list.append('l');
        System.out.println(list.toString());
        list.append('i');
        System.out.println(list.toString());
        list.append('g');
        System.out.println(list.toString());
        list.append('d');
        System.out.println(list.toString());
        list.append('a');
        System.out.println(list.toString());
        list.append('g');
        System.out.println(list.toString());
        list.append('#');
        System.out.println(list.toString());

        // Test push, first one should be @
        list.push('n');
        System.out.println(list.toString());
        list.push('e');
        System.out.println(list.toString());
        list.push('r');
        System.out.println(list.toString());
        list.push('a');
        System.out.println(list.toString());
        list.push('h');
        System.out.println(list.toString());
        list.push('g');
        System.out.println(list.toString());
        list.push('a');
        System.out.println(list.toString());
        list.push('J');
        System.out.println(list.toString());
        list.push('@');
        System.out.println(list.toString());

        // Test delete, # should be removed
        System.out.println(list.delete());
        System.out.println(list.toString());

        // Test pop, @ should be removed
        System.out.println(list.pop());
        System.out.println(list.toString());

        //Test remove, s,o,r,g should be removed
        System.out.println(list.remove(8));
        System.out.println(list.toString());
        System.out.println(list.remove(8));
        System.out.println(list.toString());
        System.out.println(list.remove(8));
        System.out.println(list.toString());
        System.out.println(list.remove(8));
        System.out.println(list.toString());

        //Test add, l,i,c,k should added into position 8-11
        list.add('l', 8);
        System.out.println(list.toString());
        list.add('i', 9);
        System.out.println(list.toString());
        list.add('c', 10);
        System.out.println(list.toString());
        list.add('k', 11);
        System.out.println(list.toString());


    }


}
