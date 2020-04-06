/**
 * LinkedList
 */
public class LinkedList<T> {
    private Node<T> startNode = null;
    private int size = 0;

    public LinkedList() {
    }

    public LinkedList(T... values) {
        insert(values);
    }

    private void init(T value) {
        setStartNode(new Node<T>(value));
        incSize();
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    private void setSize(int size) {
        this.size = size;
    }

    private void incSize() {
        setSize(this.size + 1);
    }

    private void decSize() {
        setSize(this.size - 1);
    }

    /**
     * @return the startNode
     */
    private Node<T> getStartNode() {
        return startNode;
    }

    /**
     * @param startNode the startNode to set
     */
    private void setStartNode(Node<T> startNode) {
        this.startNode = startNode;
    }

    public boolean isEmpty() {
        if (getSize() > 0) {
            return false;
        }
        return true;
    }

    public int findPos(T value) {
        if (getSize() <= 0)
            return -1;
        int count = 0;
        Node<T> currentNode = getStartNode();
        while (currentNode != null && !currentNode.getData().equals(value)) {
            currentNode = currentNode.getNextNode();
            count++;
        }
        if (currentNode == null)
            return -1;
        return count;
    }

    public void insert(T... values) {
        for (T value : values) {
            if (getSize() == 0) {
                init(value);
            } else {
                Node<T> newNode = new Node<T>(value);
                Node<T> endNode = getLastNode();
                endNode.setNextNode(newNode);
                incSize();
            }
        }
    }

    public void insertStart(T... values) {
        LinkedList<T> newList = new LinkedList<T>(values);
        newList.getLastNode().setNextNode(getStartNode());
        setStartNode(newList.getStartNode());
        for (T e : values) {
            incSize();
        }
    }

    public void insertPos(int pos, T... values) {
        if (pos < 0)
            return;

        if (pos == 0) {
            insertStart(values);
            return;
        }

        LinkedList<T> tmpList = new LinkedList<T>(values);
        tmpList.getLastNode().setNextNode(getNodeByPos(pos));
        getNodeByPos(pos - 1).setNextNode(tmpList.getStartNode());
        for (T e : values) {
            incSize();
        }
    }

    public void update(T oldValue, T newValue) {
        if (getSize() <= 0)
            return;
        getNodeByPos(findPos(oldValue)).setData(newValue);
    }

    public void updateByPos(int pos, T value) {
        if (getSize() <= 0 || pos < 0 || pos >= getSize())
            return;
        getNodeByPos(pos).setData(value);

    }

    public void delete(T value) {
        if (getSize() <= 0)
            return;
        deleteByPos(findPos(value));
    }

    public T deleteByPos(int pos) {
        if (getSize() <= 0 || pos < 0 || pos >= getSize())
            return null;

        Node<T> nodeToBeDeleted;
        if (pos == 0) {
            nodeToBeDeleted = getStartNode();
            setStartNode(nodeToBeDeleted.getNextNode());

        } else if (pos == getSize() - 1) {
            nodeToBeDeleted = getLastNode();
            getNodeByPos(pos - 1).setNextNode(null);
        } else {
            nodeToBeDeleted = getNodeByPos(pos);
            Node<T> nextNode = nodeToBeDeleted.getNextNode();
            getNodeByPos(pos - 1).setNextNode(nextNode);
        }
        T deletedData = nodeToBeDeleted.getData();
        nodeToBeDeleted = null;
        decSize();
        return deletedData;
    }

    private Node<T> getNodeByPos(int pos) {
        if (pos < getSize() && pos >= 0) {
            Node<T> currentNode = getStartNode();
            for (int i = 0; i < pos; i++) {
                currentNode = currentNode.getNextNode();
            }
            return currentNode;
        }
        return null;
    }

    private Node<T> getLastNode() {
        return getNodeByPos(getSize() - 1);
    }

    @Override
    public String toString() {
        String output = "";
        Node<T> currentNode = getStartNode();
        while (currentNode != null) {
            output += currentNode.getData() + " ";
            currentNode = currentNode.getNextNode();
        }
        return output;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + size;
        result = prime * result + ((startNode == null) ? 0 : startNode.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LinkedList other = (LinkedList) obj;
        if (size != other.size)
            return false;
        if (startNode == null) {
            if (other.startNode != null)
                return false;
        } else if (!startNode.equals(other.startNode))
            return false;
        return true;
    }

}