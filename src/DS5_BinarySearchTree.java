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
            return   + postOrderHelper(temp.getLeft()) + postOrderHelper(temp.getRight()) +", " + temp.getData();
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
    public int nodeDepth(E value)
    {
        if (root == null || !contains(value))
            return -1;
        if (root.getData().equals(value))
            return 0;
        int ans = 0;
        int count = 0;
        DS5_BinarySearchTree_Node<E> temp = root;
        return findDepth(temp, value, count);
    }
    public int findDepth(DS5_BinarySearchTree_Node<E> temp, E value, int count)
    {
        if (temp == null)
            return -1;
        if (temp.getData().equals(value))
            return count;
        if (temp.getData().compareTo(value) > 0)
            return findDepth(temp.getLeft(), value, count+1);
        else
            return findDepth(temp.getRight(), value, count+1);
    }
    public int height()
    {
        if (root == null)
            return 0;
        return heightHelper(root, 0);
    }
    public int heightHelper(DS5_BinarySearchTree_Node<E> temp, int count)
    {
        if (temp.getRight() == null || temp.getLeft() == null)
            return count;
        return 1+Math.max(heightHelper(temp.getLeft(), count+1),heightHelper(temp.getRight(), count + 1));
    }
    public int maxDepth()
    {
        if (root == null)
            return -1;
        return height()-1;
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
        if (temp.getData().compareTo(data) > 0)
            return containsHelper(temp.getLeft(), data);
        else
            return containsHelper(temp.getRight(), data);
    }
    public boolean insert(E data)
    {
        if (root == null)
        {
            root = new DS5_BinarySearchTree_Node<E>(data);
            return true;
        }
        if (contains(data))
            return false;
        return insertHelper(root, data);
    }
    public boolean insertHelper(DS5_BinarySearchTree_Node<E> temp, E data)
    {
        if (temp == null)
            return false;
        if (temp.getData().equals(data))
            return false;
        if (temp.getData().compareTo(data) > 0 && temp.getLeft() == null)
        {
            temp.setLeft(new DS5_BinarySearchTree_Node<E>(data));
            return true;
        }
        else if (temp.getData().compareTo(data) < 0 && temp.getRight() == null)
        {
            temp.setRight(new DS5_BinarySearchTree_Node<E>(data));
            return true;
        }
        if (temp.getData().compareTo(data) > 0)
            return insertHelper(temp.getLeft(), data);
        else
            return insertHelper(temp.getRight(), data);
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
        if (temp.getData().compareTo(data) > 0)
            return getHelper(temp.getLeft(), data);
        else
            return getHelper(temp.getRight(), data);
    }
    public boolean remove(E data)
    {
        if (root == null || !contains(data))
            return false;
        DS5_BinarySearchTree_Node<E> temp = getHelper(root, data);
        return removeHelper(root, temp, data);
    }
    public boolean removeHelper(DS5_BinarySearchTree_Node<E> temp, DS5_BinarySearchTree_Node<E> node, E data)
    {
        if (temp == null)
            return false;
        if (temp.getRight() == node || temp.getLeft() == node)
        {
            if (temp.getRight() == node)
            {
                temp.setRight(null);
            }
            else
            {
                temp.setLeft(null);
            }
            return true;
        }
        if (temp.getData().compareTo(data) > 0)
            return removeHelper(temp.getLeft(), node, data);
        else
            return removeHelper(temp.getRight(), node, data);
    }
}
