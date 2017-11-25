package com.sveta.sorts;

import java.util.Arrays;

public class BubbleSort {

    private int[] data;

    public BubbleSort(int[] data) {
        this.data = Arrays.copyOf(data, data.length);
    }

    public int[] getSortedData() {
        int left = 0, right = data.length -1;
        boolean forth = true;
        while(left < right) {
            if (forth) {
                for (int i = left; i < right; i++) {
                    if (data[i] > data[i+1]) {
                        swapElements(i,i+1);
                    }
                }
                right--;
            } else {
                for (int i = right; i > left; i--) {
                    if (data[i] < data[i-1]) {
                        swapElements(i, i-1);
                    }
                }
                left++;
            }
            forth = !forth;
        }
        return data;
    }

    private void swapElements(int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString( new BubbleSort(new int[] {9,8,7,4,6}).getSortedData() ));
    }

}
