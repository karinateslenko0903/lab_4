public class lab_4 {
    public static void main(String[] args) {
        int[] array = {1, 6, 2, 4, 5};
        System.out.println("Масив упорядкований: " + isSorted(array));
    }

    public static boolean isSorted(int[] array) {
        if (array.length <= 1) {
            return true;
        }

        boolean ascending = true;
        boolean descending = true;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                ascending = false;
            }
            if (array[i] > array[i - 1]) {
                descending = false;
            }
        }

        return ascending || descending;
    }
}
