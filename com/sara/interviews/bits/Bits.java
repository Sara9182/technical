package com.sara.interviews.bits;

public class Bits {

    /**
     * Replaces bits j..i of number {@code n} with number {@code m}
     */
    public static int replaceWith(int n, int m, int j, int i) {
        if (j<0 || j>=Integer.SIZE || i<0 || i>=Integer.SIZE || j<i) throw new IllegalArgumentException();
        int n1 = clearBits(n,j,i);
        int m1 = shiftToPosition(m,j,i);
        return n1 | m1;
    }

    private static int clearBits(int n, int j, int i) {
        int onesToJ = ~0 << j+1;
        int onesFromI = ~0 >>> 32-i;
        int zeroesFromJToI = onesToJ ^ onesFromI;
        return n & zeroesFromJToI;
    }

    private static int shiftToPosition(int m, int j, int i) {
        return m << i;
    }


}
