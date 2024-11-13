public class DS5_BinarySearchTree<E extends Comparable> implements DS5_BinarySearchTree_Interface<E>
{
    private DS5_BinarySearchTree_Node<E> root;
    public DS5_BinarySearchTree()
    {
        root = null;
    }
    public DS5_BinarySearchTree(E data)
    {
        root = new DS5_BinarySearchTree_Node<E>(data);
    }
    public DS5_BinarySearchTree_Node<E> getRoot()
    {
        return root;
    }
    public String preOrder()
    {
        if(root==null)
            return "[]";
        return "["+preOrderHelper(root).substring(2)+"]";
    }

    public String preOrderHelper(DS5_BinarySearchTree_Node<E> temp)
    {
        if(temp==null)
            return "";
        else
            return ", "+temp.getData() +
                    preOrderHelper(temp.getLeft()) +
                    preOrderHelper(temp.getRight());
    }
    public String inOrder()
    {
        if (root == null)
            return "[]";
        return "["+inOrderHelper(root).substring(2)+"]";
    }
    public String inOrderHelper(DS5_BinarySearchTree_Node<E> temp)
    {
        if(temp==null)
            return "";
        else
            return inOrderHelper(temp.getLeft()) + ", " + temp.getData() + inOrderHelper(temp.getRight());
    }
    public String postOrder()
    {
        if (root == null)
            return "[]";
        return "["+postOrderHelper(root).substring(2)+"]";
    }
    public String postOrderHelper(DS5_BinarySearchTree_Node<E> temp)
    {
        if(temp==null)
            return "";
        else
            return ", "  + postOrderHelper(temp.getLeft()) + postOrderHelper(temp.getRight()) + temp.getData();
    }
    public E minValue()
    {
        if (root == null)
            return null;
        DS5_BinarySearchTree_Node<E> temp = root;
        while (temp.getLeft() != null)
            temp = temp.getLeft();
        return temp.getData();
    }
    public E maxValue()
    {
        if (root == null)
            return null;
        DS5_BinarySearchTree_Node<E> temp = root;
        while (temp.getRight() != null)
            temp = temp.getRight();
        return temp.getData();
    }
    public E maxHelper(DS5_BinarySearchTree_Node<E> temp)
    {
        return maxHelper(temp.getLeft().getData()) + " " + temp.getData() + " " + maxHelper(temp.getRight().getData());
    }
    public int nodeDepth(E value)
    {
        if (root == null || !contains(value))
            return -1;
        if (root.getData().equals(value))
            return 0;
        int ans = 0;
        int count = 0;
        DS5_BinarySearchTree_Node<E> temp = root;
        findDepth(temp, value, count);
    }
    public int findDepth(DS5_BinarySearchTree_Node<E> temp, E value, int count)
    {
        if (temp == null)
            return -1;
        if (temp.getData().equals(value))
            return count;
        findDepth(temp.getLeft(), value, count+1);
        findDepth(temp.getRight(), value, count+1);
    }
    public int height()
    {
        if (root == null)
            return -1;
        return heightHelper(root, 0);
    }
    public int heightHelper(DS5_BinarySearchTree_Node<E> temp, int count)
    {
        if (temp.getRight() == null || temp.getLeft() == null)
            return count;
        return Math.max(heightHelper(temp.getLeft(), count+1),heightHelper(temp.getRight(), count + 1));
    }
    public void clear()
    {
        root.setData(null);
        root.setLeft(null);
        root.setRight(null);
        root = null;
    }
    public int size()
    {
        return sizeHelper(root);
    }
    public int sizeHelper(DS5_BinarySearchTree_Node<E> temp) {
        if (temp == null)
            return 0;
        return 1 + sizeHelper(temp.getLeft()) + sizeHelper(temp.getRight());
    }
    public boolean isEmpty()
    {
        return size() == 0;
    }
    public boolean contains(E data)
    {
        return containsHelper(root, data);
    }
    public boolean containsHelper(DS5_BinarySearchTree_Node<E> temp, E data)
    {
        if (temp == null)
            return false;
        if (temp.getData().equals(data))
            return true;
        return containsHelper(temp.getLeft(), data) || containsHelper(temp.getRight(), data);
    }
    public boolean insert(E data)
    {
        if (root == null || !contains(data))
            return false;
        DS5_BinarySearchTree_Node<E> temp = root;
        temp.setData(data);
    }
    public DS5_BinarySearchTree_Node<E> get(E data)
    {
        return getHelper(root, data);
    }
    public DS5_BinarySearchTree_Node<E> getHelper(DS5_BinarySearchTree_Node<E> temp, E data)
    {
        if (temp == null)
            return null;
        if (temp.getData().equals(data))
            return temp;
        return getHelper(temp.getLeft(), data) || getHelper(temp.getRight(), data);
    }
    public boolean remove(E data)
    {
        if (root == null || !contains(data))
            return false;
        DS5_BinarySearchTree_Node<E> temp = get(data);
    }
}
