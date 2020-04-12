/**
 * Queue
 */
public class Queue<T> extends LinkedList<T> {

    public Queue() {
    }

    public Queue(T... values) {
        super(values);
    }

    public void enqueue(T... values) {
        insert(values);
    }

    public T dequeue() {
        return deleteByPos(0);
    }
}