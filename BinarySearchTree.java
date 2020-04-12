/**
 * BinarySearchTree
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private TreeNode<T> root;

    public BinarySearchTree() {
        init(null);
    }

    private BinarySearchTree(TreeNode<T> root) {
        setRoot(root);
    }

    public BinarySearchTree(T... values) {
        insert(values);
    }

    /**
     * @return the root
     */
    private TreeNode<T> getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    private void setRoot(TreeNode<T> root) {
        this.root = root;
    }

    private void init(T value) {
        setRoot(new TreeNode<T>(value));
    }

    private TreeNode<T> moveLeft(TreeNode<T> node) {
        return node.getLeftNode();
    }

    private TreeNode<T> moveRight(TreeNode<T> node) {
        return node.getRightNode();
    }

    private TreeNode<T> findNode(T value) {
        if (value != null) {
            TreeNode<T> node = getRoot();
            while (node != null) {
                int result = value.compareTo(node.getData());
                if (result == 1) {
                    node = moveRight(node);
                } else if (result == -1) {
                    node = moveLeft(node);
                } else {
                    return node;
                }
            }
        }
        return null;
    }

    private TreeNode<T> findParentNode(T value) {
        if (value != null) {
            TreeNode<T> node = getRoot();
            while (node != null && node.getData() != value) {
                if (moveLeft(node) != null && moveLeft(node).getData() == value) {
                    return node;
                }
                if (moveRight(node) != null && moveRight(node).getData() == value) {
                    return node;
                }
                int result = value.compareTo(node.getData());
                if (result == 1) {
                    node = moveRight(node);
                } else if (result == -1) {
                    node = moveLeft(node);
                }
            }
        }
        return null;
    }

    public void insert(T... values) {
        for (T value : values) {
            if (value != null) {
                TreeNode<T> node = getRoot();
                if (node == null) {
                    init(value);
                }
                while (node != null) {
                    int result = value.compareTo(node.getData());
                    if (result > 0) {
                        if (moveRight(node) == null) {
                            node.setRightNode(new TreeNode<T>(value));
                            break;
                        } else {
                            node = moveRight(node);
                        }
                    } else if (result < 0) {
                        if (moveLeft(node) == null) {
                            node.setLeftNode(new TreeNode<T>(value));
                            break;
                        } else {
                            node = moveLeft(node);
                        }
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public void delete(T... values) {
        for (T value : values) {
            TreeNode<T> parentNode = findParentNode(value);
            if (parentNode == null) {
                if (findNode(value) == null) {
                    continue;
                }
                if (getRoot() == null)
                    continue;
                else {
                    setRoot(deleteRoot());
                    continue;
                }
            }
            int result = value.compareTo(parentNode.getData());
            TreeNode<T> node = null;
            if (result < 0) {
                node = moveLeft(parentNode);
            } else if (result > 0) {
                node = moveRight(parentNode);
            } else {
                System.out.println("error parent");
                continue;
            }

            BinarySearchTree<T> tmpTree = new BinarySearchTree<>(node);
            node = tmpTree.deleteRoot();
            if (result < 0) {
                parentNode.setLeftNode(node);
            } else if (result > 0) {
                parentNode.setRightNode(node);
            }
        }
    }

    private TreeNode<T> deleteRoot() {
        if (moveLeft(getRoot()) == null) {
            return moveRight(getRoot());
        }

        if (moveRight(getRoot()) == null) {
            return moveLeft(getRoot());
        }

        T minRight = (new BinarySearchTree<>(moveRight(getRoot()))).findMin();
        delete(minRight);
        getRoot().setData(minRight);
        return getRoot();

    }

    public String preOrder() {
        if (getRoot() != null) {
            StringBuilder result = new StringBuilder("");
            result.append(getRoot().getData().toString());
            result.append((new BinarySearchTree<>(moveLeft(getRoot()))).preOrder());
            result.append((new BinarySearchTree<>(moveRight(getRoot()))).preOrder());
            return result.toString();
        }
        return "";
    }

    public String postOrder() {
        if (getRoot() != null) {
            StringBuilder result = new StringBuilder("");
            result.append((new BinarySearchTree<>(moveLeft(getRoot()))).postOrder());
            result.append((new BinarySearchTree<>(moveRight(getRoot()))).postOrder());
            result.append(getRoot().getData().toString());
            return result.toString();
        }
        return "";
    }

    public String inOrder() {
        if (getRoot() != null) {
            StringBuilder result = new StringBuilder("");
            result.append((new BinarySearchTree<>(moveLeft(getRoot()))).inOrder());
            result.append(getRoot().getData().toString());
            result.append((new BinarySearchTree<>(moveRight(getRoot()))).inOrder());
            return result.toString();
        }
        return "";
    }

    public String findItemPath(T item) {
        if (item != null) {
            TreeNode<T> node = getRoot();
            if (node.getData() == item) {
                return "Root";
            }
            StringBuilder builder = new StringBuilder("");
            while (node != null) {
                int result = item.compareTo(node.getData());
                if (result == 1) {
                    node = moveRight(node);
                    builder.append("R ");
                } else if (result == -1) {
                    node = moveLeft(node);
                    builder.append("L ");
                } else {
                    return builder.toString();
                }
            }
            return "doesn't exits";
        }
        return "";
    }

    public T findMin() {
        TreeNode<T> node = getRoot();
        while (node != null && moveLeft(node) != null) {
            node = moveLeft(node);
        }
        if (node == null)
            return null;
        return node.getData();
    }

    public T findMax() {
        TreeNode<T> node = getRoot();
        while (node != null && moveRight(node) != null) {
            node = moveRight(node);
        }
        if (node == null)
            return null;
        return node.getData();
    }
}