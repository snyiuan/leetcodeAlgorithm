package leetCode;

import java.util.ArrayList;
import java.util.List;

public class L589preorder {
    public static void main(String[] args) {
        // Node node = new Node(1, Arrays.asList(new Node(2),
        // new Node(3, Arrays.asList(new Node(6), new Node(7))),
        // new Node(4, Arrays.asList(new Node(8, Arrays.asList(new Node(12))))),
        // new Node(5, Arrays.asList(new Node(9, Arrays.asList(new Node(13))), new
        // Node(10)))));
        // Node node = new Node(1, Arrays.asList(new Node(2)));
        // System.out.println(preorder(node));

        // Node[] nodes = { new Node(1), new Node(2), new Node(3) };
        // Node node2 = new Node(3, (List) Arrays.asList(nodes));
        // System.out.println(node2);
        // System.out.println(Arrays.asList(new Node(1)));
    }

    public static List<Integer> preorder(Node2 root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<Integer>();
        prologue(list, root);
        return list;
    }

    public static void prologue(List<Integer> list, Node2 root) {
        if (root != null) {
            list.add(root.val);
        }
        for (Node2 node : root.children) {
            prologue(list, node);
        }
    }

}

class Node2 {
    public int val;
    public List<Node2> children;

    public Node2() {
    }

    public Node2(int _val) {
        val = _val;
    }

    public Node2(int _val, List<Node2> _children) {
        val = _val;
        children = _children;
    }
}