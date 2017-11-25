package com.sveta.sorts;

import java.util.Arrays;

public class QuickSort {

    private int[] numbers;

    public QuickSort(int[] data) {
        this.numbers = Arrays.copyOf(data, data.length);
    }

    public int[] getSortedData() {
        doSort(0, numbers.length - 1);
        return numbers;
    }

    private void doSort(int leftBorder, int rightBorder) {
        if (leftBorder >= rightBorder)
            return;
        int i = leftBorder, j = rightBorder;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (numbers[i] <= numbers[cur])) {
                i++;
            }
            while (j > cur && (numbers[cur] <= numbers[j])) {
                j--;
            }
            if (i < j) {
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
                System.out.println(Arrays.toString(numbers));
                System.out.println("i=" + i + ", j=" + j);
            }
        }
        doSort(leftBorder, cur);
        doSort(cur + 1, rightBorder);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new QuickSort(new int[]{8, 1, 0, 7, 9, 3, 2}).getSortedData()));
    }


}
