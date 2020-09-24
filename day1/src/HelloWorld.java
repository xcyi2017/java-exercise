public class HelloWorld {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        bubbleSort(arr, 0, arr.length);
        for (int j : arr) {
            System.out.println(j);
        }
    }

    public static void bubbleSort(int[] arr, int left, int right) {
        if (left < right) {
            for (int i = 0; i < right - 1; ++i) {
                if (arr[i] < arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    bubbleSort(arr, left, right - 1);
                }
            }
        }
    }
}
