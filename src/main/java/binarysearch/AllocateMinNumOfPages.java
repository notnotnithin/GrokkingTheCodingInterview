package binarysearch;

public class AllocateMinNumOfPages {

  public static void main(String[] args) {
    int[] arr = {12, 34, 67, 90};
    int n = arr.length;
    int k = 2;

    System.out.println("Minimum number of pages a student should study is: "
        + findPages(arr, n, k));
  }

  private static int findPages(int[] arr, int n, int k) {
    if (n < k) {
      return -1;
    }

    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += arr[i];
    }

    int start = 0, end = sum;
    int res = -1;

    while (start <= end) {
      int mid = start + (end - start) / 2;

      if (isValid(arr, n, k, mid)) {
        res = mid;
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return res;
  }

  private static boolean isValid(int[] arr, int n, int k, int mid) {
    int student = 1;
    int sum = 0;

    for (int i = 0; i < n; i++) {
      sum += arr[i];
      if (sum > mid) {
        student++;
        sum = arr[i];
      }
    }

    if (student > k) {
      return false;
    }
    return true;
  }
}
