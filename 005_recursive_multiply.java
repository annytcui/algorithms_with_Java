// Recursive Multiply: Write a recursive function to multiply two positive
// integers without using the * operator (or / operator). You can use addition,
// subtraction, and bit shifting, but you should minimize the number of those
// operations.

// Solution #1
int minProduct(int a, int b) {
  int bigger = a < b ? b : a;
  int smaller = a < b ? a : b;
  return minProductHelper(smaller, bigger);
}

int minProductHelper(int smaller, int bigger) {
  if (smaller == 0) {
    return 0;
  } else if (smaller == 1) {
    return bigger;
  }

  // Compute half. If uneven, compute other half. If even, double it.
  int s = smaller >> 1;
  int side1 = minProduct(s, bigger);
  int side2 = side1;
  if (smaller % 2 == 1) {
    side2 = minProductHelper(smaller - s, bigger);
  }

  return side1 + side2;
}

// Solution #2: Memoization
int minProduct(int a, int b) {
  int bigger = a < b ? b : a;
  int smaller = a < b ? a : b;

  int memo[] = new int[smaller + 1];
  return minProduct(smaller, bigger, memo);
}

int minProduct(int smaller, int bigger, int[] memo) {
  if (smaller == 0) {
    return 0;
  } else if (smaller == 1) {
    return bigger;
  } else if (memo[smaller] > 0) {
    return memo[smaller];
  }

  // Compute half. If uneven, compute other half. If even, double it.
  int s = smaller >> 1;
  int side1 = minProduct(s, bigger, memo);
  int side2 = side1;
  if (smaller % 2 == 1) {
    side2 = minProduct(smaller - s, bigger, memo);

  }

  // Sum and cache
  memo[smaller] = side1 + side2;
  return memo[smaller];
}

// Solution #3
int minProduct(int a, int b) {
  int bigger = a < b ? b : a;
  int smaller = a < b ? a : b;
  return minProductHelper(smaller, bigger);
}

int minProductHelper(int smaller, int bigger) {
  if (smaller == 0) return 0;
  else if (smaller == 1) return bigger;

  int s = smaller >> 1;
  int halfProd = minProductHelper(s, bigger);

  if (smaller % 2 == 0) {
    return halfProd + halfProd;
  } else {
    return halfProd + halfProd + bigger;
  }
}
