import java.util.*;

class BinarySearchTree
{
    class Node
    {
        int data;
        Node right,left;
        Node(int data)
        {
            this.data = data;
            right=left=null;
        }
    }
    Node root ;
    BinarySearchTree()
    {
        root = null;
    }
    void insert(int data)
    {
        root = insertInTree(root,data);
    }
    Node insertInTree(Node root , int data)
    {
        if(root == null)
        {
            root = new Node(data);
            return root;
        }
        if(data < root.data)
        {
           root.left = insertInTree(root.left, data);
        }
        else
        {
            root.right = insertInTree(root.right, data);
        }
        return root;
    }
    int height()
    {
        int a ;
        a = calHeight(root);
        return a;
    }
    int calHeight(Node root)
    {
        if(root == null)
        {
            return 0;
        }
        else
        {
            int l = calHeight(root.left);
            int r = calHeight(root.right);
            if(l>r)
            {
                return l+1;
            }
            else
            {
                return r+1;
            }
        }
    }
    void preorder()
    {
        printPreOrder(root);
        System.out.println();
    }
    void printPreOrder(Node root)
    {
        if(root == null)
        {
            return;
        }
        System.out.print(root.data + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }
    void postorder()
    {
        printPostOrder(root);
        System.out.println();
    }
    void printPostOrder(Node root)
    {
        if(root == null)
        {
            return;
        }
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.data + " ");
    }
    void inorder()
    {
        printInOrder(root);
        System.out.println();
    }
    void printInOrder(Node root)
    {
        if(root == null)
        {
            return;
        }
        else
        {
            printInOrder(root.left);
            System.out.print(root.data + " ");
            printInOrder(root.right);
        }
    }
    void level()
    {
        int h = height();
        for(int i = 1 ; i<=h ; i++)
        {
            printlevel(root,i);
            System.out.println();
        }
    }
    void printlevel(Node root , int level)
    {
        if(root == null)
        {
            return;
        }
        if(level == 1)
        {
            System.out.print(root.data + " " );
        }
        else if(level>1)
        {
            printlevel(root.left, level-1);
            printlevel(root.right, level-1);
        }
    }
    void acending()
    {
        inorder();
    }
    void decending()
    {
        decending(root);
    }
    void decending(Node root)
    {
        if(root == null)
        {
            return;
        }
        else
        {
            decending(root.right);
            System.out.print(root.data + " ");
            decending(root.left);
        }
    }
    void rtllevel()
    {
        int h = height();
        for(int i = 1 ; i<=h ; i++)
        {
            System.out.println();
            printrtllevel(root,i);
        }
    }
    void printrtllevel(Node root , int level)
    {
        if(root == null)
        {
            return;
        }
        if(level == 1)
        {
            System.out.print(root.data + " " );
        }
        else if(level>1)
        {
            printrtllevel(root.right, level-1);
            printrtllevel(root.left, level-1);
        }
    }
    void revlevel()
    {
        int h = height();
        for(int i = h ; i>=1 ; i--)
        {
            System.out.println();
            printrevlevel(root,i);
        }
    }
    void printrevlevel(Node root , int level)
    {
        if(root == null)
        {
            return;
        }
        if(level == 1)
        {
            System.out.print(root.data + " " );
        }
        else if(level>1)
        {
            printrevlevel(root.left, level-1);
            printrevlevel(root.right, level-1);
        }
    }
    void spiral()
    {
        printinSpiral(root);
    }
    void printinSpiral(Node root)
    {
        int h = height();
        for(int i = 1 ; i<=h ; i++)
        {
            if(i%2==1)
            {
                printrtllevel(root, i);
                System.out.println();
            }
            else
            {
                printlevel(root, i);
                System.out.println();
            }
        }
    }
}

public class File{
    public static void main(String []agrs)
    {
        BinarySearchTree tree = new BinarySearchTree();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes");
        int num = sc.nextInt();
        System.out.println("Enter nodes");
        /*Enter the data nodes in PreOrder or just enter root node first*/
        for(int i =0 ; i<num ; i++)
        {
            tree.insert(sc.nextInt());
        }
        //Prints height of tree in terms of edges
        System.out.println("Edge height " + (tree.height()-1));
        //Prints level order traversal
        System.out.println("Level order");
        tree.level();
        //Prints reverse of level order traversal
        System.out.println("\nReverse level order");
        tree.revlevel();
        //Prints level order traversal with data aligned right to left
        System.out.println("\nData left to right in level order");
        tree.rtllevel();
        //Prints tree levels spirally
        System.out.println("\nSpiral printing");
        tree.spiral();
        //Prints preorder traversal
        System.out.println("\nPrints in order");
        tree.preorder();
        //Prints postorder traversal
        System.out.println("\nPrints post order");
        tree.postorder();
        sc.close();
        
    }
}