#include<stdlib.h>
#include<stdio.h>

void exch(int *arr, long idx1, long idx2);
long partition (int arr[], long low, long high);


void quick(int arr[], long l, long h)
{
	long pi = 0;
    if (l < h)
    {
       pi = partition(arr, l, h);

        quick(arr, l, pi - 1);  // Before pi
        quick(arr, pi + 1, h); // After pi
    }
}

void exch(int *arr, long idx1, long idx2){
	int temp = arr[idx1];
	arr[idx1] = arr[idx2];
	arr[idx2] = temp;
}

long partition (int arr[], long low, long high)
{
    // Element placed at right position)
    int temp = arr[high];
    long i = (low - 1);  // Index of smaller element

    for (int j = low; j <= high- 1; j++)
    {
        // If current element is smaller than the temp
        if (arr[j] < temp)
        {
            i++;
			exch(arr, i, j);
        }
    }
	exch(arr,i+1,high);
	return i+1;

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

	int arr[nrIntegers];

	printf("%ld\n", nrIntegers);

	srandom(seed);
	for(long i=0; i < nrIntegers; i++) {
		arr[i] = (long)(maxInt * ((double)random()/(double)RAND_MAX));
	}

	print_arr(arr, nrIntegers);

	quick(arr, 0, nrIntegers);

	print_arr(arr, nrIntegers);

	return 0;
}
