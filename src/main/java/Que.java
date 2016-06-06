/**
 * Created by eshulga on 6/1/16.
 */
public class Que<T> {
    private T[] ar = (T[]) new Object[10];
    private int counterN = -1;

    public static void main(String[] args) {
        Que<Integer> s = new Que();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
        s.push(5);
        s.push(6);
        while (!s.isEmtpy()) {
            System.out.println(s.pop());
        }
        System.out.println(s.pop());
    }

    public void push(T data) {
        ar[++counterN] = data;
    }

    public T peek() {
        if(isEmtpy()){
            return null;
        }
        return ar[counterN];
    }

    public T pop() {
        if(isEmtpy()){
            return null;
        }
        T res = ar[counterN];
        ar[counterN--] = null;
        return res;
    }

    boolean isEmtpy() {
        return counterN<0;
    }
}

class DoubleLinked<T> {
    Node<T> first;
    Node<T> last;

    public void addHead(T data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            first = newNode;
        } else {
            newNode.next = first;
            first.previous = newNode;
            first = newNode;
        }
    }

    public void addTail(T data) {
        Node newNode = new Node(data);
        if(isEmpty()){
            //TODO
        }
    }

    public T peekHead() {
        return first.data;
    }

    public T popHead() {
        T res = first.data;
        first = first.next;
        first.previous = null;
        return res;
    }

    public boolean isEmpty() {
        return first == null;
    }

    class Node<T> {
        Node<T> next;
        Node<T> previous;
        T data;

        public Node(T data) {
            this.data = data;
        }
    }
}