
package lecture;

import java.util.LinkedList;
import java.util.Queue;

public class TreeStudy4 {

    Node root;

    public static void main(String[] args) {
        TreeStudy4 treeStudy = new TreeStudy4();
        treeStudy.root = new Node(1);
        treeStudy.root.lt = new Node(2);
        treeStudy.root.rt = new Node(3);
        treeStudy.root.lt.lt = new Node(4);
        treeStudy.root.lt.rt = new Node(5);

        int i = 0;
//        System.out.println(dfs(treeStudy.root, i));
        System.out.println(bfs(treeStudy.root));
    }

    static int dfs(Node node, int i) {
        if(node.lt == null && node.rt == null) return i;
        else return Math.min(dfs(node.lt,i+1),dfs(node.rt,i+1));
    }


    static int bfs(Node node){
        int answer = 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Node cur = q.poll();
                if(cur.lt == null && cur.rt == null) return answer;
                if(cur.lt != null)q.offer(cur.lt);
                if(cur.rt != null)q.offer(cur.rt);
            }
            answer++;
        }

        return answer;
    }


}
