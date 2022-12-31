package lecture;

class Node{
    int val;
    Node lt,rt;

    Node(int val){
        this.val = val;
        lt=rt=null;
    }

}


public class TreeStudy {
    Node root;

    public static void main(String[] args) {
        TreeStudy treeStudy = new TreeStudy();
        treeStudy.root = new Node(1);
        treeStudy.root.lt = new Node(2);
        treeStudy.root.rt = new Node(3);
        treeStudy.root.lt.lt = new Node(4);
        treeStudy.root.lt.rt = new Node(5);
        treeStudy.root.rt.lt = new Node(6);
        treeStudy.root.rt.rt = new Node(7);

        dfs(treeStudy.root);
    }

    static void dfs(Node node){
       if(node == null) return;
       else{
           System.out.println(node.val);
           dfs(node.lt);
           dfs(node.rt);
       }



    }

}
