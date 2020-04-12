/**
 * TreeNode
 */
public class TreeNode<T extends Comparable<T>> {

    private T data = null;
    private TreeNode<T> leftNode = null, rightNode = null;

    public TreeNode() {
    }

    public TreeNode(T data) {
        this.data = data;
    }

    public TreeNode(T data, TreeNode<T> leftNode, TreeNode<T> rightNode) {
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    /**
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * @return the leftNode
     */
    public TreeNode<T> getLeftNode() {
        return leftNode;
    }

    /**
     * @param leftNode the leftNode to set
     */
    public void setLeftNode(TreeNode<T> leftNode) {
        this.leftNode = leftNode;
    }

    /**
     * @return the rightNode
     */
    public TreeNode<T> getRightNode() {
        return rightNode;
    }

    /**
     * @param rightNode the rightNode to set
     */
    public void setRightNode(TreeNode<T> rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + ((leftNode == null) ? 0 : leftNode.hashCode());
        result = prime * result + ((rightNode == null) ? 0 : rightNode.hashCode());
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
        TreeNode other = (TreeNode) obj;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        if (leftNode == null) {
            if (other.leftNode != null)
                return false;
        } else if (!leftNode.equals(other.leftNode))
            return false;
        if (rightNode == null) {
            if (other.rightNode != null)
                return false;
        } else if (!rightNode.equals(other.rightNode))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}