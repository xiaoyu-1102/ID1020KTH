#include <stdlib.h>
#include <stdio.h>
void print_arr(int* a, long len);
void exch(int *arr, int idx1, int idx2);
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

void merge(int arr[], long l, long m, long r) {
	long n1 = m - l + 1;
	long n2 = r - m;

	int L[n1], R[n2];

	/* Copy data to temp arrays L[] and R[] */
	for (long i = 0; i < n1; i++)
		L[i] = arr[l + i];
	for (long j = 0; j < n2; j++)
		R[j] = arr[m + 1 + j];

	/* Merge the temp arrays back into arr[l..r]*/
	long i = 0;
	long j = 0;
	long k = l;
	while (i < n1 && j < n2) {
		if (L[i] <= R[j]) {
			arr[k++] = L[i++];
		} else {
			arr[k++] = R[j++];
		}
	}

	while (i < n1) {
		arr[k++] = L[i++];
	}

	while (j < n2) {
		arr[k++] = R[j++];
	}
}

void mergeSort(int *arr, long l, long r) {
	if (l < r) {
		long m = l + (r - l) / 2;
		int cut = 10;
		if (m-l > cut) {
			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);

			merge(arr, l, m, r);
		} else {
			insertionSort(arr+l, r-l+1);
		}
	}
}


void print_arr(int* a, long len) {
	for(long i=0;i<len;i++){
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
	for(long i=0; i < nrIntegers; i++) {
		arr[i] = (long)(maxInt * ((double)random()/(double)RAND_MAX));
	}

	print_arr(arr, nrIntegers);

	mergeSort(arr, 0, nrIntegers);

	print_arr(arr, nrIntegers);

	return 0;
}
