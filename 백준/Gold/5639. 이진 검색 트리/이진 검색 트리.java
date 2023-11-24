import java.io.*;
import java.util.*;

public class Main {
    static List<Node> tree;
    static int inputCnt;
    static StringBuffer sb;

    static class Node {
        int root;
        int left;
        int right;
        public Node(int root, int left, int right) {
            this.root = root;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        tree = new ArrayList<>();
        inputCnt = 0;

        int first = Integer.parseInt(br.readLine());
        tree.add(new Node(first, 0, 0));

        while (true) {
            String s = br.readLine();
            if (s==null || s.equals("")) {
                break;
            }
            inputCnt++;

            int inputNum = Integer.parseInt(s);
            int remembered = 0;

            for(int i=0; i<inputCnt; i++) {
                if (remembered != 0 && remembered != tree.get(i).root) {
                    continue;
                }
                if (inputNum < tree.get(i).root) {
                    if (tree.get(i).left != 0) {
                        remembered = tree.get(i).left;
                        continue;
                    }
                    tree.get(i).left = inputNum;
                    break;
                }else {
                    if (tree.get(i).right != 0) {
                        remembered = tree.get(i).right;
                        continue;
                    }
                    tree.get(i).right = inputNum;
                    break;
                }
            }

            tree.add(new Node(inputNum, 0, 0));
        }

        sb = new StringBuffer();
        dfs(tree.get(0).root);

        System.out.println(sb.toString());
    }
    
    private static void dfs(int start) {
        for (int i = 0; i <= inputCnt; i++) {
            if (tree.get(i).root == start) {
                if (tree.get(i).left != 0) {
                    dfs(tree.get(i).left);
                }

                if (tree.get(i).right != 0) {
                    dfs(tree.get(i).right);
                }

                sb.append(tree.get(i).root + "\n");
                break;
            }
        }
    }

}