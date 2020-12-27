#include <stdio.h>

int main() {
  int arr_a[1][4] = {1, 2};           //只提供了2个初始值
  int arr_b[1][4] = {1, 2, 3, 4};     //提供了全部4个初始值
  int arr_c[1][4] = {1, 2, 3, 4, 5};  //提供了6个初始值

  printf("arr_a: ");
  for (int i = 0; i < 1; i++)
    for (int j = 0; j < 4; j++) 
      printf("%d ", arr_a[i][j]);  //输出 1 2 0 0

  printf("\narr_b: ");
  for (int i = 0; i < 1; i++)
    for (int j = 0; j < 4; j++) 
      printf("%d ", arr_b[i][j]);  //输出 1 2 3 4

  printf("\narr_c: ");
  for (int i = 0; i < 1; i++)
    for (int j = 0; j < 6; j++)
      printf("%d ", arr_c[i][j]);  //输出 1 2 3 4 -158987776 32764
                                  // 输出的后面两个数是内存里的随机值

  return 0;
}