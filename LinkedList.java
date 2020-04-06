/**
 * LinkedList
 */
public class LinkedList<T> {
    private Node<T> startNode = null;

    public LinkedList() {
    }

    public LinkedList(T... values) {
        insert(values);
    }

    private void init(T value) {
        setStartNode(new Node<T>(value));
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

    /**
     * @return the size
     */
    public int getSize() {
        int size = 0;
        Node<T> currentNode = getStartNode();
        while (currentNode != null) {
            size++;
            currentNode = currentNode.getNextNode();
        }
        return size;
    }

    /**
     * Returns the node at the position
     * 
     * @return the Node
     * @param pos the position
     */
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

    /**
     * Returns the node at the last position
     * 
     * @return the Node
     */
    private Node<T> getLastNode() {
        return getNodeByPos(getSize() - 1);
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
            }
        }
    }

    public void insertStart(T... values) {
        LinkedList<T> newList = new LinkedList<T>(values);
        newList.getLastNode().setNextNode(getStartNode());
        setStartNode(newList.getStartNode());
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
        return deletedData;
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
        result = prime * result + getSize();
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
        if (getSize() != other.getSize())
            return false;
        if (startNode == null) {
            if (other.startNode != null)
                return false;
        } else if (!startNode.equals(other.startNode))
            return false;
        return true;
    }

}