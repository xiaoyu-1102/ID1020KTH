#include <stdio.h>
#include <string.h>

void print_arr(int* a, int len);
int subs(int *a, int idx, int value);
void swift_left(int *a, int len);
void foo(int *a, int len);

void foo(int *a, int len){
	int m = 1 ;
	int n = len-1;

	int temp = a[0];

	for(int i = 1; i < len; i++){
		if (temp < 0) {
			temp = subs(a, m, temp);
			m++;
		} else {
			temp = subs(a, n, temp);
			n--;
		}

		print_arr(a, len);
	}

	if (temp < 0) {
		a[0] = temp;
	} else {
		swift_left(a, len);
		a[len-1]=temp;
	}
}

void swift_left(int *a, int len){
	for (int i=0; i < len - 1; i++){
		a[i]=a[i+1];
	}
}

int subs(int * a, int idx, int value){
	int aux = a[idx];
	a[idx] = value;
	return aux;
}

void print_arr(int* a, int len) {
	for(int i=0;i<5;i++){
		printf("%d,",a[i]);
	}
	printf("\n");
}

int main(){
	int a[] = {2, -4, 1, -7, -5};

	print_arr(a, 5);

	foo(a,5);

	print_arr(a, 5);

	return 0;
}
