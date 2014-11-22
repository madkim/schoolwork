// Matthew Kim & Susan Kim
// madkim
// cmps12b
// 11/21/14
// Tree.java 
// creates a binary search tree of words 

import static java.lang.System.*;

class Tree {

    private class Node {
        String key;
        Queue<Integer> value;
        Node left;
        Node right;
    }
    private Node root;

    private void debugHelper(Node tree, int depth) 
        {
        if(tree != null) {
            for(int i = 0; i < depth; i++){
                System.out.print("  ");
            }
        System.out.println(depth+" "+tree.key);
        depth++;
        debugHelper(tree.left, depth);
        debugHelper(tree.right, depth);
        }
    }

    private void outputHelper(Node tree) 
        {
        if(tree != null) {
            outputHelper(tree.left);
            System.out.print(tree.key + " : ");
            for(int i: tree.value){
                System.out.print(i+" ");
            }
            System.out.println();
            outputHelper(tree.right);
        }
    }

    public void insert(String key, Integer linenum) 
        {        
        Node newNode = new Node();  //Code from tree.java
        newNode.key = key;
        newNode.value = new Queue<Integer>();

        if(root == null){
            newNode.value.insert(linenum);
            root = newNode;
        }
        else
            {
            Node current = root;
            Node parent;
            while(true)
                {
                parent = current;
                if(key.compareTo(current.key) < 0){
                    current = current.left;
                    if(current == null){
                        newNode.value.insert(linenum);
                        parent.left = newNode;
                        return;
                    }
                }
                else if(key.compareTo(current.key) == 0){
                    current.value.insert(linenum);
                    return;
                }
                else
                    {
                    current = current.right;
                    if(current == null){
                        newNode.value.insert(linenum);
                        parent.right = newNode;
                        return;
                    }
                    }   
                }
            }
        }

    public void debug() {
        debugHelper(root, 0);
    }

    public void output() {
        // Show sorted words with lines where each word appears
        outputHelper(root);
        
    }

}
