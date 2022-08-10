public class Sem02_MergeSort {
    public static void main(String[] args) {
        int[] array = {6, 8, 10, 24, 1, 2, 9, 0};
        var res = mergeSortArray(array);
        for (var el :
                res) {
            System.out.print(el + " ");
        }
    }
    public static int[] mergeSortArray(int[] array) {
        if (array.length < 2) return array;

        int[] arrayB = new int[array.length / 2];
        System.arraycopy(array, 0, arrayB, 0, array.length / 2);
        int[] arrayC = new int[array.length - arrayB.length];
        System.arraycopy(array, arrayB.length, arrayC, 0, array.length - arrayB.length);

        mergeSortArray(arrayB);
        mergeSortArray(arrayC);
        mergeArray(array, arrayB, arrayC);

        return array;
    }

    private static void mergeArray(int[] array, int[] arrayB, int[] arrayC) {

        int posB = 0;
        int posC = 0;

        for (int c = 0; c < array.length; c++) {
            if (posB == arrayB.length) {
                array[c] = arrayC[posC];
                posC++;
            } else if (posC == arrayC.length) {
                array[c] = arrayB[posB];
                posB++;
            } else if (arrayB[posB] < arrayC[posC]) {
                array[c] = arrayB[posB];
                posB++;
            } else {
                array[c] = arrayC[posC];
                posC++;
            }
        }
    }
}
