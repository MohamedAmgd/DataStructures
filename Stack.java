/**
 * Stack
 */
public class Stack<T> extends LinkedList<T> {

    public Stack() {
    }

    public Stack(T... values) {
        super(values);
    }

    public void push(T... values) {
        insert(values);
    }

    public T pop() {
        return deleteByPos(getSize() - 1);
    }
}