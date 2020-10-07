import java.util.Arrays;
import java.util.Scanner;

class ST  <Key extends Comparable <Key>, Value> {

        private Key[] keys;
        private Value[] vals;
        private int N;

    public ST (int cap){
        keys = (Key[]) new Comparable[cap];
        vals = (Value[]) new Object[cap];
    }


    public int size() { return N; }

    public boolean isEmpty(){
        return N == 0;
    }


    public int rank(Key key)
    {
        int lo = 0;
        int hi = N-1;

        while(!(lo>hi)){
            int mid = lo + (hi-lo) / 2;
            int com = key.compareTo(keys[mid]);
            if (com>0) {
                lo = mid+1;
            } else if(com<0) {
                hi = mid-1;
            } else {
                return mid;
            }
        }
        return lo;
    }


    public boolean contains(Key key) {
        if(isEmpty()) return false;
        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0)
            return true;
        else
            return false;
    }

    public void put(Key key, Value val){
            int i = rank(key);
            if(i<N && keys[i].compareTo(key)==0){
                vals[i] = val;
                return;
            }// if find, replace the value and update
            for(int j = N; j>i;j--){
                keys[j]= keys[j-1];
                vals[j]= vals[j-1];
            }
            keys[i] = key;
            vals[i] = val;
            N++;

    }//if not, create new element

    public Value get(Key key){
        int i = rank(key);
        if (isEmpty()) {
            return null;
        }

        if (i<N && keys[i].compareTo(key)==0){
            return vals[i];
        } else {
            return null;
        }
    }


    public Key getKeypos(int pos){
        if (pos<N){
            return keys[pos];
        }else
            return null;
    }

    public Iterable<Key> keys()
    {
        Key[] arr = (Key[]) new Object[this.size()];
        int p = 0;
        for (int i = 0; i < keys.length; i++) {
            if (this.contains(keys[i])) {
                arr[p++] = keys[i];
            }
        }

        return Arrays.asList(arr);
    }

}
