import java.util.*;

class Solution {
    static Node[] nodes;
    static Stack<Integer> preStack;
    static Stack<Integer> postStack;    
    
    class Node {
        int id;
        int x;
        int y;
        Node left, right;
        public Node(int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }
    }
    
    class Tree {
        int parent;
        int left;
        int right;
        public Tree(int parent, int left, int right) {
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }
    
    public int[][] solution(int[][] nodeinfo) {
        nodes = new Node[nodeinfo.length];
        
        for(int i=0; i<nodeinfo.length; i++) {
            nodes[i] = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]);
        }
        
        //y 순으로 정렬
        Arrays.sort(nodes, new Comparator<Node>() {
            public int compare(Node n1, Node n2) {
                return n2.y - n1.y;
            }
        });
        
        for(int i=1; i<nodes.length; i++) {
            makeTree(nodes[0], nodes[i]);
        }
                
        preStack = new Stack<>();
        postStack = new Stack<>();
        
        dfsPre(nodes[0], preStack);
        dfsPost(nodes[0], postStack);
        
        int[][] answer = new int[2][nodeinfo.length];
        
        for(int i=0; i<nodeinfo.length; i++) {
            answer[0][i] = preStack.get(i);
            answer[1][i] = postStack.get(i);
        }
        
        return answer;
    }
    
    public static void makeTree(Node root, Node newNode) {
        if(newNode.x < root.x) {
            if(root.left==null) {
                root.left = newNode;
            }else {
                makeTree(root.left, newNode);
            }
        }else {
            if(root.right==null) {
                root.right = newNode;
            }else {
                makeTree(root.right, newNode);
            }
        }
    }
    
    public static void dfsPre(Node root, Stack stack) {
        stack.add(root.id);

        if(root.left!=null) {
            dfsPre(root.left, stack);
        }

        if(root.right!=null) {
            dfsPre(root.right, stack);
        }
    }
    
    public static void dfsPost(Node root, Stack stack) {
        if(root.left!=null) {
            dfsPost(root.left, stack);
        }

        if(root.right!=null) {
            dfsPost(root.right, stack);
        }

        stack.add(root.id);
    }
}