public class lab4 {
    public static void main(String[] args) {

        DoubleLinkList<Character> list = new DoubleLinkList<>();

        // Test append, last one should be #
        list.append('b');
        System.out.println(list.toString());
        list.append('r');
        System.out.println(list.toString());
        list.append('a');
        System.out.println(list.toString());
        list.append('d');
        System.out.println(list.toString());
        list.append('a');
        System.out.println(list.toString());
        list.append('g');
        System.out.println(list.toString());
        list.append('$');
        System.out.println(list.toString());
        list.append('#');
        System.out.println(list.toString());

        // Test push, first one should be @
        list.push(' ');
        System.out.println(list.toString());
        list.push('n');
        System.out.println(list.toString());
        list.push('e');
        System.out.println(list.toString());
        list.push('a');
        System.out.println(list.toString());
        list.push('H');
        System.out.println(list.toString());
        list.push('%');
        System.out.println(list.toString());
        list.push('@');
        System.out.println(list.toString());

        // Test delete, #,$ should be removed
        System.out.println(list.delete());
        System.out.println(list.toString());
        System.out.println(list.delete());
        System.out.println(list.toString());

        // Test pop, @,% should be removed
        System.out.println(list.pop());
        System.out.println(list.toString());
        System.out.println(list.pop());
        System.out.println(list.toString());
    }


}
