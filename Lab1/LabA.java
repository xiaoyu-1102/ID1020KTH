public class LabA {

    private static boolean match (char open, char close) {

        System.out.println("Check " + open + " and " + close);

        switch (open) {
            case '(':
                return close == ')';
            case '[':
                return close == ']';
            case '{':
                return close == '}';
            default:
                System.out.println("Error");
                return false;
        }
    }


    private static boolean isBalanced(String str) {

        DoubleLinkQueue<Character> queue = new DoubleLinkQueue<>();

        for (int i=0; i < str.length(); i++) {

            char c = str.charAt(i);

            if (c == '(' || c == '[' || c == '{') {

                queue.append(c);
                System.out.println(queue.toString());
            } else if (c == ')' || c == ']' || c == '}') {
                Character pop_c = queue.delete();
                if (pop_c == null || !match(pop_c, c)) {
                    return false;
                }
            }

        }

        return queue.isEmpty();
    }


    public static void main(String[] args) {
        String str = "(He){wo,[1+2]lde}";
        System.out.println(str);
        System.out.println(isBalanced(str));

        str = "(He{sug)shjl]]lop{}sjdh";
        System.out.println(str);
        System.out.println(isBalanced(str));

        str = "}990adh]fiopw(sfioio[sjoiwes)";
        System.out.println(str);
        System.out.println(isBalanced(str));

        str = "uuuu}}}}uuuuuuuu()hhhhh{{{{hhh{{}}hhhhhhhhiws/";
        System.out.println(str);
        System.out.println(isBalanced(str));

        str = "((qwert((()){ss})[(1=2)])wold)";
        System.out.println(str);
        System.out.println(isBalanced(str));

        str = "(ahfiaowv]ashfijp{dfsoa}";
        System.out.println(str);
        System.out.println(isBalanced(str));

        str = "sd[ ";
        System.out.println(str);
        System.out.println(isBalanced(str));

    }



}
