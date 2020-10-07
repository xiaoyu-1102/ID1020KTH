import java.util.*;

public class BST <Key extends Comparable<Key>, Value> {
    private Node root;
    private int p;

    private class Node {

        private Key key;
        private Value val;
        private Node lf;
        private Node rt;
        private int N;

        public Node (Key key, Value val, int N){
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    public Key min() { return min(root).key; }
    public Key max() { return max(root).key; }

    private Node min(Node x) {
        if(x.lf == null) return x;
        return min(x.lf);
    }

    private Node max(Node x) {
        if(x.rt == null) return x;
        return max(x.rt);
    }


    public Iterable<Key> keys() { return keys(min(), max()); }

    private Iterable<Key> keys(Key lo, Key hi) {
        Key[] arr = (Key[]) new Comparable[size()];
        p = 0;
        keys(root, arr, lo, hi);
        return Arrays.asList(arr);
    }

    private void keys(Node x, Key[] arr, Key lo, Key hi) {
        if(x == null) return;
        int cmpLo = lo.compareTo(x.key);
        int cmpHi = hi.compareTo(x.key);

        if(cmpLo < 0) keys(x.lf, arr, lo, hi);
        if(cmpLo <= 0 && cmpHi >= 0 ) arr[p++] = x.key;
        if(cmpHi > 0) keys(x.rt, arr, lo, hi);
    }

    private int size(Node n){
        if(n == null){
            return 0;
        }else
            return n.N;
    }

   public int size() { return size(root); }



    public boolean contains(Key key) {
        return contains(root, key);
    }

   public boolean contains(Node n, Key key){
        if(n==null){
            return false;
        }
        int com = key.compareTo(n.key);
        if(com<0){
            return contains(n.lf,key);
        }else if(com>0){
            return contains(n.rt,key);
        }else return true;
   }


   public Value get(Key key){
       return get(root, key);
   }

   public Value get(Node n, Key key){
       if(n == null){
           return null;
       }
       int com = key.compareTo((Key) n.key);

       if(com<0){
           return get(n.lf,key);
       } else if (com > 0) {
           return get(n.rt,key);
       }else
           return (Value) n.val;
   }


    public void put(Key key, Value val){
        root = put(root, key, val);
    }

    public Node put(Node m, Key key, Value val) {
        if (m == null) {
            return new Node(key, val, 1);
        }

        int cmp = key.compareTo(m.key);

        if (cmp < 0) {
            m.lf = put(m.lf, key, val);
        } else if (cmp > 0) {
            m.rt = put(m.rt, key, val);
        } else
            m.val = val;

        m.N = size(m.lf) + size(m.rt) + 1;
        return m;
    }


}
