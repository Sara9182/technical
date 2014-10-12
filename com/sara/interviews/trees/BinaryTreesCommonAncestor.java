package com.sara.interviews.trees;

import java.util.HashSet;
import java.util.Set;

public class BinaryTreesCommonAncestor {

    static class AncesoryInfo<T> {
        Set<BinaryTreeNode<T>> occurrences = new HashSet<>();
        BinaryTreeNode<T> ancestor;
    }

    public static <T> BinaryTreeNode<T> commonAncestor(BinaryTreeNode<T> root, BinaryTreeNode<T> x, BinaryTreeNode<T> y) {
        AncesoryInfo<T> ancesoryInfo= (commonAncestorRec(root,x,y));
        return ancesoryInfo == null ? null : ancesoryInfo.ancestor;
    }

    private static <T> AncesoryInfo<T> commonAncestorRec(BinaryTreeNode<T> current, BinaryTreeNode<T> x, BinaryTreeNode<T> y) {
        if (current == null || x == null || y == null) {
            return null;
        }
        AncesoryInfo<T> infoCurrent = new AncesoryInfo<>();
        AncesoryInfo<T> infoLeft = commonAncestorRec(current.getLeft(),x,y);
        if (infoLeft != null && infoLeft.ancestor != null) {
            infoCurrent.ancestor = infoLeft.ancestor;
            return infoCurrent;
        }
        AncesoryInfo<T> infoRight = commonAncestorRec(current.getRight(),x,y);
        if (infoRight != null && infoRight.ancestor != null) {
            infoCurrent.ancestor = infoRight.ancestor;
            return infoCurrent;
        }
        if (isFirstAncestor(infoLeft,infoRight,x,y)) {
            infoCurrent.ancestor = current;
            return infoCurrent;
        }
        else {
            if (infoLeft != null) infoCurrent.occurrences.addAll(infoLeft.occurrences);
            if (infoRight != null) infoCurrent.occurrences.addAll(infoRight.occurrences);
            if (current == x || current == y) {
                infoCurrent.occurrences.add(current);
            }
            return infoCurrent;
        }
    }

    private static <T> boolean isFirstAncestor(AncesoryInfo<T> infoLeft, AncesoryInfo<T> infoRight, BinaryTreeNode<T> x, BinaryTreeNode<T> y) {
        Set<BinaryTreeNode<T>> union = new HashSet<>();
        if (infoLeft != null) union.addAll(infoLeft.occurrences);
        if (infoRight != null) union.addAll(infoRight.occurrences);
        return union.contains(x) && union.contains(y);
    }
}
