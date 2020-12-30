#include <stdio.h>

int main() {
  int a[3][3] = {1, 2, 3, 4, 5, 6, 7, 8, 9};

  int *p = &a[0][0];
  //p = p + 3;
  printf("%d\n", *(p+9));  // 4

  return 0;
}