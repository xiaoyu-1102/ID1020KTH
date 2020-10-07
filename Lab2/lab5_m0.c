#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#include <unistd.h>


void print_arr(int* a, long len);
void exch(int *arr, int idx1, int idx2);

void merge(int arr[], long l, long m, long r) {
	long n1 = m - l + 1;
	long n2 = r - m;

	long L[n1], R[n2];

	/* Add data into L[] and R[] */
	for (long i = 0; i < n1; i++) {
		L[i] = arr[l + i];
	}

	for (long j = 0; j < n2; j++){
		R[j] = arr[m + 1 + j];
	}


	/* Merge L[] and R[] together */
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
	/*什么意思*/

	while (j < n2) {
		arr[k++] = R[j++];
	}
}

void mergeSort(int arr[], long l, long r) {
	if (l < r) {
		long m = l + (r - l) / 2;

		mergeSort(arr, l, m);
		mergeSort(arr, m + 1, r);

		merge(arr, l, m, r);
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
	/* */
	double time_taken = 0.0;

	clock_t begin = clock();

	/* */

	unsigned int seed;
	long nrIntegers;
	long maxInt;

	sscanf(argv[1],"%d", &seed);
	sscanf(argv[2],"%ld", &nrIntegers);
	sscanf(argv[3],"%ld", &maxInt);

	int arr[nrIntegers];

	printf("%ld\n", nrIntegers);

	srandom(seed);
	for(long i=0; i < nrIntegers; i++) {
		arr[i] = (long)(maxInt * ((double)random()/(double)RAND_MAX));
	}

	print_arr(arr, nrIntegers);

	mergeSort(arr, 0, nrIntegers);

	print_arr(arr, nrIntegers);

	/* */
	sleep(3);


	clock_t end = clock();
	double time_taken = (double)(end - begin)/CLOCK_PER_SEC;
  	printf("time spend is %f ", time_taken);

   	return 0;
}
