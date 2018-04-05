import java.util.*;
public class StackByLinkedList<T> {
    private LinkedList<T> l;
    public StackByLinkedList() {
        l = new LinkedList<>();
    }
    public void push(T i) {
        l.add(i);
    }
    public T peek(T i) {
        if(i.size()<=0) throw new RuntimeException("Empty Stack");
        return l.getLast();
    }
    public T pop(T i) {
        if(i.size<=0) throw new RuntimeException("Empty Stack");
        T temp = l.getLast();
        l.remove(l.size()-1);
        return temp;
    }
}
