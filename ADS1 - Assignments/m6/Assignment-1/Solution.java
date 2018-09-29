import java.util.Scanner;

class LinkedList<T> {

    /**
     * generic type node.
     */
    private Node<T> first = null;
    int size = 0;

    /**
     * Class for node.
     *
     * @param      <T>   generic mode.
     */
    class Node<T> {
        /**
         * T data item.
         */
        private T item;

        /**
         * Node next.
         */
        private Node<T> next;

    }

    /**
     * check whether stack is empty or not.
     * @return true or false.
     */
    public boolean isEmpty() {
        return first == null;
    }
    /**
     * push method is used to push the item.
     * @param item element to push.
     */
    public void push(final T item) {
        Node<T> oldfirst = first;
        first = new Node<T>();
        first.item = item;
        first.next = oldfirst;
        size++;
    }
    /**
     * pop method is to remove the item.
     * @return the poped element.
     */
    public T pop() {
        if (size == 0) {
            return null;
        }
        T item = first.item;
        first = first.next;
        size--;
        return item;            
    }

    public int size() {
        return this.size;
    }

}


class Stack<E>{
    LinkedList<E> stackList = new LinkedList<E>();
    public void push(E data) {
        stackList.push(data);
    }
    public E pop() {
        try {
            E t = stackList.pop();
            return t;
        }
        catch(Exception E) {
            //System.out.println("no elements left");
        }
        return null;
    }
    public boolean isEmpty() {
        return stackList.isEmpty();
    }
    

    public int size() {
        return stackList.size();
    }
}


class AddLargeNumbers {
    
    public static LinkedList<Integer> numberToDigits(String number) {
        //System.out.println("number is "+number);
        LinkedList<Integer> digitsList = new LinkedList<Integer>();
        for (int i = 0; i < number.length(); i++) {
            //System.out.println("being pushed " + number.charAt(i));
            digitsList.push(Integer.parseInt("" + number.charAt(i)));
        }
        return digitsList;
    }

    public static String digitsToNumber(LinkedList<Integer> list) {
        int k = list.size();
        String result = "";
        for (int i = 0 ;i < k; i++) {
            int tmpp = list.pop();
            //System.out.println(tmpp);
            result += "" + tmpp;
        }
        return result;
    }

    public static LinkedList<Integer> addLargeNumbers(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        //list1.print();
        //list2.print();
        
        Stack<Integer> carry = new Stack<Integer>();
        Stack<String> answer = new Stack<String>();
        LinkedList<Integer> finalResult = new LinkedList<Integer>();

        int noOfIterations = 0;
        
        if (list1.size() >= list2.size()) {
            noOfIterations = list1.size();
        } else {
            noOfIterations = list2.size();
        }

        for (int i = 0 ; i < noOfIterations; i++) {
            Integer t1 = list1.pop();
            Integer t2 = list2.pop();
            
            //System.out.println("t1 is "+ t1 + " t2 is "+ t2);

            if (t1 == null) {
                t1 = 0;
            } 

            if (t2 == null) {
                t2 = 0;
            }

            int tmpAdditionResult = 0;
            if (carry.isEmpty()) {
                tmpAdditionResult= t1 + t2;    
            } else {
                tmpAdditionResult = t1 + t2 + carry.pop();
            }
            
            //System.out.println(tmpAdditionResult);
            String splitter = "" + tmpAdditionResult;

            if (splitter.length() > 1 && (!list1.isEmpty() || !list2.isEmpty())) {
                //System.out.println(Integer.parseInt(""+splitter.charAt(0)));
                carry.push(Integer.parseInt(""+splitter.charAt(0)));
                //System.out.println("" + splitter.charAt(1));
                answer.push("" + splitter.charAt(1));
            } else {
                answer.push(splitter);
            }

            for (int j = 0; j < answer.size(); j++) {
                int tt = Integer.parseInt(answer.pop());
                //System.out.println("tt is "+tt);
                finalResult.push(tt);
            }

            


        }
        return finalResult;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch(input){
            case "numberToDigits":
                LinkedList<Integer> pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList<Integer> qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            case "addLargeNumbers":
                pDigits = AddLargeNumbers.numberToDigits(p);
                qDigits = AddLargeNumbers.numberToDigits(q);
                LinkedList<Integer> result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
        }
    }   
}
