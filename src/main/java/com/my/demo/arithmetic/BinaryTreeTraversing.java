package com.my.demo.arithmetic;


/**
 * 二叉树的遍历（前序 、中序、后序）
 */
public class BinaryTreeTraversing {

    /**
     * 构建二叉树
     * @return
     */
    private static BinTree buildBinTree() {
        BinTree A = new BinTree("A");
        BinTree B = new BinTree("B");
        BinTree C = new BinTree("C");
        BinTree D = new BinTree("D");
        BinTree E = new BinTree("E");
        BinTree F = new BinTree("F");
        BinTree G = new BinTree("G");

        A.leftTree = B;
        A.rightTree = C;
        B.leftTree = D;
        B.rightTree = E;
        C.leftTree = F;
        C.rightTree = G;
        return A;
    }


    public static void main(String[] args) {
        BinTree binTree = buildBinTree();
        System.out.print("\n前序遍历 ： ");
        preOrder(binTree);
        System.out.print("\n中序遍历 ： ");
        inOrder(binTree);
        System.out.print("\n后序遍历 ： ");
        postOrder(binTree);

    }

    /**
     * 前序遍历 ： A | B | D | E | C | F | G |
     * @param binTree
     */
    private static void preOrder(BinTree binTree) {
        System.out.print(binTree.data + " | ");
        if (binTree.leftTree != null) {
            preOrder(binTree.leftTree);
        }
        if (binTree.rightTree != null) {
            preOrder(binTree.rightTree);
        }
    }

    /**
     * 中序遍历 ： D | B | E | A | F | C | G |
     * @param binTree
     */
    private static void inOrder(BinTree binTree) {
        if (binTree.leftTree != null) {
            inOrder(binTree.leftTree);
        }
        System.out.print(binTree.data + " | ");
        if (binTree.rightTree != null) {
            inOrder(binTree.rightTree);
        }
    }

    /**
     * 后序遍历 ： D | E | B | F | G | C | A |
     * @param binTree
     */
    private static void postOrder(BinTree binTree) {
        if (binTree.leftTree != null) {
            postOrder(binTree.leftTree);
        }
        if (binTree.rightTree != null) {
            postOrder(binTree.rightTree);
        }
        System.out.print(binTree.data + " | ");
    }


    /**
     * tree 对象
     */
    static class BinTree {
        private String data;
        private BinTree leftTree;
        private BinTree rightTree;

        public BinTree(String data) {
            this.data = data;
        }
    }

}

