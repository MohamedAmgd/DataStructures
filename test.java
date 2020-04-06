/**
 * test
 */
public class test {
    public static void main(String[] args) {
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
}