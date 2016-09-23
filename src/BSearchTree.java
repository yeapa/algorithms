/**
 * Created by ye on 16-9-5.
 */
public class BSearchTree<Key extends Comparable<Key>,Value> {
    private Node root;
    private class Node{
        private Key key;
        private  Value val;
        private Node left,right;
        private int N;

        public Node(Key key,Value val,int N){
            this.key=key;
            this.val=val;
            this.N =N;
        }
    }

    private int size(Node x){
        if (x==null){
            return 0;
        }
        else return x.N;
    }

    private void put(Key key, Value val){
        root = put(root, key,val);
    }

    private Node put(Node x, Key key , Value val){
        if (x==null){
            return  new Node(key,val,1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp<0){

        }
        else if (cmp>0){

        }
        else x.val=val;

        x.N = size(x.left)+size(x.right)+1;
        return x;
    }
}
