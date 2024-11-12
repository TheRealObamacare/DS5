public class DS5_BinarySearchTree<E extends Comparable> implements DS5_BinarySearchTree_Interface<E>
{
    private DS5_BinarySearchTree_Node<E> root;
    private int size;
    public DS5_BinarySearchTree()
    {
        root = null;
        size = 0;
    }
    public DS5_BinarySearchTree(E data)
    {
        root = new DS5_BinarySearchTree_Node<E>(data);
        size = 1;
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
            return ", "  + postOrderHelper(temp.getRight()) + postOrderHelper(temp.getLeft()) + temp.getData();
    }
    public E minValue()
    {
        if (root == null)
            return null;
        String ans = minHelper(root);
        return Math.min(Integer.parseInt(ans.split(" ")[0][1][2]);
    }
    public E minHelper(DS5_BinarySearchTree_Node<E> temp)
    {
        return minHelper(temp.getLeft().getData()) + " " + temp.getData() + " " + minHelper(temp.getRight().getData());
    }
    public E maxValue()
    {
        if (root == null)
            return null;
        String ans = minHelper(root);
        return Math.max(Integer.parseInt(ans.split(" ")[0][1][2]);
    }
    public E maxHelper(DS5_BinarySearchTree_Node<E> temp)
    {
        return maxHelper(temp.getLeft().getData()) + " " + temp.getData() + " " + maxHelper(temp.getRight().getData());
    }
    public int nodeDepth(E value);
    public int height()
    {
        return nodeDepth(root.getData());
    }
    public void clear()
    {
        root.setData(null);
        root.setLeft(null);
        root.setRight(null);
        root = null;
        size = 0;
    }
    public int size()
    {
        return size;
    }
    public boolean isEmpty()
    {
        return size == 0;
    }
    public boolean contains(E data)
    {
        return;
    }
    public boolean insert(E data);
    public boolean remove(E data);
}
