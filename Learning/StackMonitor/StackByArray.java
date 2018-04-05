public class StackByArray<T> {
    private Object[] a;
    private int top;
    public StackByArray(int max) {
        a = new Object[max];
        top = 0;
    }

    public Object peek(){
        if(top <= 0) {
            throw new RuntimeException("Empty Stack");
        }
        return a[top-1];
    }

    public Object pop() {
        if(top <= 0) {
            throw new RuntimeException("Empty Stack");
        }
        return a[top--];
    }

    public void push(Object i) {
        if(top == a.length-1) {
            throw new RuntimeException("Stack Overflow");
        }
        a[top++] = i;
    }

    public static void main(String [] args) {
        StackByArray<Integer> a = new StackByArray<>(10);
        a.pop();
        a.push(0);
        a.push(1);
        System.out.println(a.peek());
    }
}
