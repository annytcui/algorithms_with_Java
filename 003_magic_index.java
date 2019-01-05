// Magic Index: A magic index in an array A[1..n-1] is defined to be an index
// such that A[i] = i. Given a sorted array of distinct integers, write a method
// to find a magic index, if one exists, in array A.

int magicIndex(int[] array) {
  return magicIndex(array, 0, array.length - 1);
}

int magicIndex(int[] array, int start, int end) {
  if (end < start) {
    return -1;
  }

  int mid = (start + end) / 2;
  if (array[mid] == mid) {
    return mid;
  } else if (array[mid] > mid) {
    return magicIndex(array, start, mid - 1);
  } else {
    return magicIndex(array, mid + 1, end);
  }
}

// Follow up: what if the values are not distinct?
int magicIndex(int[] array) {
  return magicIndex(array, 0, array.length - 1);
}

int magicIndex(int[] array, int start, int end) {
  if (end < start) return -1;

  int midIndex = (start + end) / 2;
  int midValue = array[midIndex];
  if (midValue == midIndex) {
    return midIndex;
  }

  // Search left
  int leftIndex = Math.min(midIndex - 1, midValue);
  int left = magicIndex(array, start, leftIndex);
  if (left >= 0) {
    return left;
  }

  // Search right
  int rightIndex = Math.max(midIndex + 1, midValue);
  int right = magicIndex(array, rightIndex, end);

  return right;
}
