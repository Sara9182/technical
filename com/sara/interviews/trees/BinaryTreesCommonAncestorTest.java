package com.sara.interviews.trees;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreesCommonAncestorTest {

    @Test
    public void testCommonAncestorNullTree() {
        assertNull(BinaryTreesCommonAncestor.commonAncestor(null,new BinaryTreeNode<>(1), new BinaryTreeNode<>(1)));
    }

    @Test
    public void testCommonAncestorNullX() {
        assertNull(BinaryTreesCommonAncestor.commonAncestor(new BinaryTreeNode<>(1), null, new BinaryTreeNode<>(1)));
    }

    @Test
    public void testCommonAncestorNullY() {
        assertNull(BinaryTreesCommonAncestor.commonAncestor(new BinaryTreeNode<>(1), new BinaryTreeNode<>(1), null));
    }

    @Test
    public void testCommonAncestorRootXY() {
        BinaryTreeNode<Integer> v1 = new BinaryTreeNode<>(1);
        assertNull(BinaryTreesCommonAncestor.commonAncestor(v1,v1,v1));
    }

    @Test
    public void testCommonAncestorRootX() {
        BinaryTreeNode<Integer> v1 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> v2 = new BinaryTreeNode<>(1);
        v1.setLeft(v2);
        assertNull(BinaryTreesCommonAncestor.commonAncestor(v1,v1,v2));
    }

    @Test
    public void testCommonAncestorRootY() {
        BinaryTreeNode<Integer> v1 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> v2 = new BinaryTreeNode<>(1);
        v1.setRight(v2);
        assertNull(BinaryTreesCommonAncestor.commonAncestor(v1,v2,v1));
    }

    @Test
    public void testCommonAncestorXEqualsY() {
        BinaryTreeNode<Integer> v1 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> v2 = new BinaryTreeNode<>(1);
        v1.setRight(v2);
        assertEquals(v1,BinaryTreesCommonAncestor.commonAncestor(v1,v2,v2));
    }

    @Test
    public void testCommonAncestorBothRightDecendants() {
        BinaryTreeNode<Integer> v1 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> v2 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> v3 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> v4 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> v5 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> v6 = new BinaryTreeNode<>(1);
        v1.setRight(v2);
        v2.setRight(v3);
        v3.setRight(v4);
        v1.setLeft(v5);
        v5.setRight(v6);
        assertEquals(v2,BinaryTreesCommonAncestor.commonAncestor(v1,v3,v4));
    }

    @Test
    public void testCommonAncestorOneLeftOneRightDescendant() {
        BinaryTreeNode<Integer> v1 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> v2 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> v3 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> v4 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> v5 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> v6 = new BinaryTreeNode<>(1);
        v1.setRight(v2);
        v1.setLeft(v3);
        v3.setLeft(v4);
        v3.setRight(v5);
        v4.setRight(v6);
        assertEquals(v3,BinaryTreesCommonAncestor.commonAncestor(v1,v4,v6));
    }

}