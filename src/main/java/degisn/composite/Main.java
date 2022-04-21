package degisn.composite;

import java.util.ArrayList;
import java.util.List;

abstract class Node {
    abstract public void p();
}

class LeafNode extends Node {
    String content;

    public LeafNode(String content) {
        this.content = content;
    }

    @Override
    public void p() {
        System.out.println(content);
    }
}

class BranchNode extends Node {
    List<Node> list = new ArrayList<>();
    String name;

    public BranchNode(String name) {
        this.name = name;
    }

    public void add(Node n) {
        list.add(n);
    }

    @Override
    public void p() {
        System.out.println(name);
    }
}

public class Main {
    public static void main(String[] args) {
        BranchNode root = new BranchNode("lesson1");
        BranchNode n1 = new BranchNode("lesson1-1");
        BranchNode n2 = new BranchNode("lesson1-2");
        root.add(n1);
        root.add(n2);
        Node n11 = new LeafNode("lesson1-1-1");
        Node n12 = new LeafNode("lesson1-1-2");
        n1.add(n11);
        n1.add(n12);
        BranchNode n21 = new BranchNode("lesson1-2-1");
        n2.add(n21);
        Node n211 = new LeafNode("lesson1-2-1-1");
        Node n212 = new LeafNode("lesson1-2-1-1");
        n21.add(n211);
        n21.add(n212);
        print(root, 0);
    }

    public static void print(Node root, int depth) {
        if (root != null) {
            for (int i = 0; i < depth; i++) {
                System.out.print("--");
            }
            root.p();
        }
        if (root instanceof BranchNode) {
            BranchNode node = (BranchNode) root;
            for (int i = 0; i < node.list.size(); i++) {
                print(node.list.get(i), depth + 1);
            }
        }
    }
}
