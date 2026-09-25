
public class Stack<T> {
    private int size;
    private T[] stack;

    public Stack(int length) {
        stack = (T[]) (new Object[length]);
        this.size = 0;
    }

    public T pop() {
        if (size > 0) {
            T item = stack[--size];
            stack[size] = null;
            return item;
        } else {
            System.out.println("error stack empty on pop");
            return null;
        }
    }

    public T peek() {
        if (size > 0) {
            return stack[size - 1];
        } else {
            System.out.println("error stack empty on peek");
            return null;
        }
    }

    public void push(T item) {
        if (size < stack.length) {
            stack[size++] = item;
        } else {
            T[] resize = (T[]) (new Object[stack.length * 2]);
            System.arraycopy(stack, 0, resize, 0, stack.length);// should be a loop but convienent
            stack = resize;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int Size() {
        return size;
    }

    public String toString() {
        StringBuilder str = new StringBuilder("");
        for (int i = 0; i < size; i++) {
            str.append(stack[i]).append(",");
        }
        return str.toString();
    }
}
