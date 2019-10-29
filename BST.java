//I could not fix my compareTo function nor do I know how to and because of that it does not compile or run.

public class BST<Comparable> {
    private class Node {
        public Comparable data;
        public Node left;
        public Node right;

        public Node(Comparable newdata){
            data = newdata;
        }
    }

    private Node root;

    public BST(){


    }

    void delete(Comparable elem){
        root =  delete(root, elem);
    }

    Node delete(Node tree, Comparable elem){
        if(tree == null)
            return null;
        if(tree.data.compareTo(elem)== 0){
            if(tree.left == null)
                return tree.right;
            else if (tree.right == null)
                return tree.left;
            else {
                if(tree.right.left == null){
                    tree.data = tree.right.data;
                    tree.right = tree.right.right;
                    return tree;
                } else{
                    tree.data = removeSmallest(tree.right);
                    return tree;
                }
            }

        }
        else if(elem.compareTo(tree.data)<0){
            tree.left = delete(tree.left,elem);
            return tree;
        }
        else{
            tree.right = delete(tree.right, elem);
            return tree;
        }

    }

    public Comparable removeSmallest(Node tree){
        if(tree.left.left == null){
            Comparable smallest = tree.left.data;
            tree.left = tree.left.right;
            return smallest;
        }
        else{
            return removeSmallest(tree.left);
        }
    }

    public boolean find(Comparable item){

        return find(root,item);
    }


    public boolean find (Node tree, Comparable item ){
        if(tree == null)
            return false;
        if(item.compareTo(tree.data) == 0)
            return true;
        if(item.compareTo(tree.data)< 0)
            return find(tree.left,item);
        else
            return find(tree.right,item);
    }


    public void print(){
        print(root);
    }

    public void print(Node tree){
        if(tree != null)
            print(tree.left);
            System.out.print(tree.data);
            print(tree.right);
    }

    public void insert(Comparable item){
        insert(root,item);
    }


    public Node insert(Node tree, Comparable item){
        if(tree == null)
            return new Node(item);
        if(item.compareTo(tree.data)<0){
            tree.left = insert(tree.left,item);
            return tree;
        }
        else{
            tree.right = insert(tree.right,item);
            return tree;
        }
    }


}
