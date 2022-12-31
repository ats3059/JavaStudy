package lecture;


import java.util.LinkedList;
import java.util.Queue;

public class TreeStudy3 {
    Node root;

    public static void main(String[] args) {
        Node root = new TreeStudy3.Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);

        bfs(root);
    }
    //BFS -> 넓이 우선 탐색 ... lv1부터 lv n까지 조회하는데 한 번 탐색할 때 그 lv에 존재하는 노드 전부 탐색.
    static void bfs(Node node){
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        int L = 1;
        while(!q.isEmpty()){
            int len = q.size();
            System.out.print(L++ + " : [");
            for(int i = 0; i < len; i++){
                Node cur = q.poll();
                System.out.print(cur.val + ",");
                if(cur.lt != null) q.offer(cur.lt);
                if(cur.rt != null) q.offer(cur.rt);
            }
            System.out.print("]  ");
        }


    }
    
    static private class Node{
        int val;
        Node lt,rt;

        Node(int val){
            this.val = val;
            lt=rt=null;
        }

    }


}
