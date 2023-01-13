package com.example.demo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

interface ITree<T> {
    T Root();

    boolean isLeaf();

    int numberSubTrees();

    ITree<T> getSubTree(int i);

    void addSubTree(ITree<T> subtree);

    List<T> preorder();

    List<T> inorder();

    List<T> postorder();

    int Height();
}

public class Tree<T> implements ITree<T> {
    static Tree<String> tree;
    static ArrayList<Tree<String>> folders = new ArrayList<>();
    private T root;
    private LinkedList<ITree<T>> children;

    Tree(T root) {
        this.root = root;
        children = new LinkedList<>();
    }

    @Override
    public T Root() {
        return root;
    }

    @Override
    public boolean isLeaf() {
        return children.isEmpty();
    }

    @Override
    public int numberSubTrees() {
        return children.size();
    }

    @Override
    public ITree<T> getSubTree(int i) {
        return children.get(i);
    }

    @Override
    public void addSubTree(ITree<T> subtree) {
        children.add(subtree);
    }


    @Override
    public List<T> preorder() {
        return _preorder(new LinkedList<>());
    }

    private List<T> _preorder(List<T> result) {
        result.add(root);
        if (!isLeaf()) {
            for (ITree<T> subtree : children) {
                ((Tree) subtree)._preorder(result);
            }
        }
        return result;
    }

    @Override
    public List<T> inorder() {

        return _inorder(new LinkedList<>());
    }

    private List<T> _inorder(List<T> result) {
        if (isLeaf()) {
            result.add(root);
        } else {
            ((Tree) children.get(0))._inorder(result);
            result.add(root);
            for (int i = 1; i < numberSubTrees(); i++) {
                ((Tree) children.get(i))._inorder(result);
            }
        }
        return result;
    }

    @Override
    public List<T> postorder() {
        return _postorder(new LinkedList<>());
    }


    private List<T> _postorder(List<T> result) {
        for (int i = 0; i < numberSubTrees(); i++) {
            ((Tree) children.get(i))._postorder(result);
        }
        result.add(root);
        return result;
    }

    @Override
    public int Height() {
        if (isLeaf())
            return 0;
        int max = 0;
        for (int i = 0; i < children.size(); i++) {
            int h = children.get(i).Height();
            if (max < h)
                max = h;
        }
        return max + 1;
    }
}