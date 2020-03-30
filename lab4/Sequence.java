package lab4;

import java.util.Iterator;
import java.util.NoSuchElementException;

interface Iterate<E> {
    Iterator<E> iterate();
}

public class Sequence<E> implements Iterate<E> {

    private E[] pfa;
    private int length;

    public Sequence(E[] newArray) {
        this.pfa = newArray;
        this.length = newArray.length;
    }

    public Iterator<E> iterate(){
        Iterator<E> iterator = new Iterator<E>() {
            private E data;
            private int idx = 0;

            public boolean hasNext() {
                return idx < length && pfa[idx] != null;
            }

            public E next() {
                if(!hasNext())
                    throw new NoSuchElementException();
                return pfa[idx++];
            }

            public void remove(int value) {
                throw new UnsupportedOperationException();
            }
        };
        return iterator;
    }


    public static void main(String[] args) {
        Integer[] pfaI = new Integer[] {2,4,6,8,10,12,14,16,18,20};
        String[] pfaS = new String[] {"SJSU", "SFSU", "CSUEB", "CSULB", "CSUF"};

        Sequence<Integer> seqInteger = new Sequence<Integer>(pfaI);
        Sequence<String> seqString = new Sequence<String>(pfaS);

        Iterator<Integer> intIter = seqInteger.iterate();
        Iterator<String> strIter = seqString.iterate();

        System.out.println("All elements in the integer list: ");
        while(intIter.hasNext()) {
            Integer data = intIter.next();
            if(intIter.hasNext()) {
                System.out.print(data + ", ");
            }
            else {
                System.out.println(data);
            }
        }

        System.out.println("\nAll elements in the string list: ");
        while(strIter.hasNext()) {
            String data = strIter.next();
            if(strIter.hasNext()) {
                System.out.print(data + ", ");
            }
            else {
                System.out.println(data);
            }
        }

    }
}
