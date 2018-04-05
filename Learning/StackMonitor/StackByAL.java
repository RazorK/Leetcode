import java.util.*;
public class StackByAL<T> {
    private ArrayList<T> a;
    public StackByAL() {
        a = new ArrayList<>();
    }

    public T peek(){
        if(a.size() == 0) {
            throw new RuntimeException("Empty Stack");
        }
        return a.get(a.size()-1);
    }

    public T pop() {
        if(a.size() <= 0) {
            throw new RuntimeException("Empty Stack");
        }
        T res = a.get(a.size()-1);
        a.remove(a.size()-1);
        return res;
    }

    public void push(T i) {
        a.add(i);
    }

    public static void main(String [] args) {
        StackByAL<Integer> s = new StackByAL<>();
        s.push(0);
        s.push(1);
        System.out.println(s.peek());
    }
}
