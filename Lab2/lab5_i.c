#include <stdlib.h>
#include <stdio.h>
void print_arr(int* a, int len);
void exch(int *arr, int idx1, int idx2);

void insertionSort(int *arr, int len){
	for(int i = 1; i < len; i++) {
		for(int j = i; j > 0 && arr[j-1] > arr[j]; j--){
			exch(arr, j, j-1);
		}
	}
}

void exch(int *arr, int idx1, int idx2){
	int temp = arr[idx1];
	arr[idx1] = arr[idx2];
	arr[idx2] = temp;
}

void print_arr(int* a, int len) {
	for(int i=0;i<len;i++){
		printf("%d,",a[i]);
	}
	printf("\n");
}

int main(int argc, char *argv[])
{
	unsigned int seed;
	long nrIntegers;
	long maxInt;

	sscanf(argv[1],"%d", &seed);
	sscanf(argv[2],"%ld", &nrIntegers);
	sscanf(argv[3],"%ld", &maxInt);

	printf("%ld\n", nrIntegers);

	int arr[nrIntegers];

	srandom(seed);
	for(int i=0; i < nrIntegers; i++) {
		arr[i] = (long)(maxInt * ((double)random()/(double)RAND_MAX));
	}

	print_arr(arr, nrIntegers);

	insertionSort(arr, nrIntegers);

	print_arr(arr, nrIntegers);

	return 0;
}
