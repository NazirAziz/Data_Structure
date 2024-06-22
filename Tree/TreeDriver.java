import java.util.LinkedList;
import java.util.Queue;
// we need them for display

class Node{
    int data;
    Node leftChild;
    Node rightChild;

    Node (int data){
        this.data = data;
    }
    @Override
    public String toString() {
        return Integer.toString(data);
    }
}

class Tree{
    Node root;
    public void add(int data){
        addLoop(data);
    }
    private void addLoop(int data){
        Node temp = new Node(data);
        if (root == null){
            root = temp;
            return;
        }
        Node current = root;

        while (true){
            if (current.data >= data){
                if (current.leftChild == null){
                    current.leftChild = temp;
                    break;
                }
                else 
                    current = current.leftChild;
            }else if (current.data < data){
                if (current.rightChild == null){
                    current.rightChild = temp;
                    break;
                } 
                else
                    current = current.rightChild;
            }
        }
    }

    public void display(){
        // displayPreOrder(root);
        displayInOrder(root);
        // displayPostOrder(root);
        // displayLevelOrder(root);
    }
    private void displayInOrder(Node rootNode){
        if (rootNode == null)
            return;
        displayInOrder(rootNode.leftChild);
        System.out.print(rootNode + " ");
        displayInOrder(rootNode.rightChild);
    }
    private void displayPreOrder(Node rootNode){
        if (rootNode == null)
            return;
        System.out.print(rootNode + " ");
        displayPreOrder(rootNode.leftChild);
        displayPreOrder(rootNode.rightChild);
    }
    private void displayPostOrder(Node rootNode){
        if (rootNode == null)
            return;
            displayPostOrder(rootNode.leftChild);
            displayPostOrder(rootNode.rightChild);
            System.out.print(rootNode + " ");
    }
    private void displayLevelOrder(Node rooNode){
        Queue<Node> q = new LinkedList<Node>();
        q.add(rooNode);

        while (!q.isEmpty()){
            Node temp = q.peek();
            System.out.print(temp + " ");
            if (temp.leftChild != null)
                q.add(temp.leftChild);
            if (temp.rightChild != null)
                q.add(temp.rightChild);
            q.poll();
        }
    }

    public boolean search(int data){
        // return searchRec(root, data);
        // or
        return searchLoop(data);
    }
    private boolean searchRec(Node rootNode, int data){
        if (rootNode == null)
            return false;
        if (rootNode.data == data)
            return true;
        
        boolean result = false;
        if (rootNode.data > data)
            result = searchRec(rootNode.leftChild, data);
        else
            result = searchRec(rootNode.rightChild, data);
        return result;
    }
    private boolean searchLoop(int data){
        Node current = root;
        boolean result = false;
        while (current != null){
            if (current.data == data){
                result = true;
                break;
            }

            if (current.data > data)
                current = current.leftChild;
            else
                current = current.rightChild;   
        }
        return result;
    }

    public int depth(){
        return depth(root);
    }
    private int depth(Node rootNode){
        if (rootNode == null)
            return -1;
        return Math.max(depth(rootNode.leftChild), depth(rootNode.rightChild)) + 1;
    }

    public void delete(int data){
        root = deleteNode(root,data);
    }
    private Node deleteNode(Node rootNode, int key){
        if (rootNode == null) return null;
        if (key > rootNode.data)
            rootNode.rightChild = deleteNode(rootNode.rightChild, key);
        else if (key < rootNode.data)
            rootNode.leftChild = deleteNode(rootNode.leftChild, key);
        else{
            if (rootNode.leftChild == null && rootNode.rightChild == null){
                rootNode = null;
            }else if (rootNode.rightChild != null){
                rootNode.data = successor(rootNode);
                rootNode.rightChild = deleteNode(rootNode.rightChild, rootNode.data);   
            }else{
                rootNode.data = predecessor(rootNode);
                rootNode.leftChild = deleteNode(rootNode.leftChild, rootNode.data);
            }
        }
        return rootNode;
    }
    private int successor(Node root){
        root = root.rightChild;
        while(root.leftChild != null){
            root = root.leftChild;
        }
        return root.data;
    }
    private int predecessor(Node root){
        root = root.leftChild;
        while(root.rightChild != null){
            root = root.rightChild;
        }
        return root.data;
    }
}

public class TreeDriver{
    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.add(8);
        tree.add(4);
        tree.add(6);
        tree.add(3);
        tree.add(9);
        tree.add(23);
        tree.add(1);
        tree.add(9);
        tree.add(0);

        tree.display();
        tree.delete(3);
        System.out.println();
        tree.display();
        // System.out.println();
        // System.out.println(tree.search(89));
        // System.out.println(tree.depth());

    }
}
