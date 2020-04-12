/**
 * test
 */
public class test {
    public static void main(String[] args) {
        testLinkedList();
        System.out.println("===========================");
        testQueue();
        System.out.println("===========================");
        testStack();
        System.out.println("\n===========================");
    }

    static void testLinkedList() {
        String[] arr = { "4", "5" };
        LinkedList<String> list = new LinkedList<String>("A", "B", "C");
        list.insertStart("1", "2", "3");
        list.insertPos(3, arr);
        list.insertPos(0, "-1", "0");
        list.insert("D");
        System.out.println(list.deleteByPos(0));
        list.delete("3");
        list.update("4", "3");
        list.updateByPos(4, "4");
        list.insertPos(-1, "sa");
        System.out.println(list.toString() + "\n" + list.getSize());
        System.out.println("---------------------------");
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.insert(1, 2, 6, 4);
        list2.updateByPos(2, 3);
        System.out.println(list2);
        System.out.println("---------------------------");
        LinkedList<Integer> list3 = new LinkedList<>();
        list3.insert(1, 2, 3, 4);
        System.out.println(list2);
        System.out.println(list3 + "\n" + list3.equals(list2));
    }

    static void testQueue() {
        String[] arr = { "4", "5" };
        Queue<String> queue1 = new Queue<>("A", "B", "C");
        queue1.enqueue("1", "2", "3");
        System.out.println(queue1.dequeue());
        System.out.println(queue1.dequeue());
        System.out.println(queue1.dequeue());
        queue1.enqueue(arr);
        System.out.println(queue1);
        System.out.println("---------------------------");
        Queue<String> queue2 = new Queue<>();
        queue2.enqueue("A", "B", "C", "1", "2", "3");
        System.out.println(queue2.dequeue());
        System.out.println(queue2.dequeue());
        System.out.println(queue2.dequeue());
        queue2.enqueue(arr);
        System.out.println(queue2.equals(queue1));
    }

    static void testStack() {
        Stack<String> stack1 = new Stack<>("1", "2", "3", "4", "5", "6");
        int size = stack1.getSize();
        System.out.println(stack1);
        for (int i = 0; i < size; i++) {
            System.out.print(stack1.pop() + " ");
        }
        System.out.println();
        System.out.println("---------------------------");
        Stack<String> stack2 = new Stack<>();
        stack2.push("1", "2", "3", "4", "5", "6");
        stack2.pop();
        stack2.push("E", "D", "C", "B", "A");
        System.out.println(stack2);
        int size2 = stack2.getSize();
        for (int i = 0; i < size2; i++) {
            System.out.print(stack2.pop() + " ");
        }
    }
}