#include<stdlib.h>
#include<stdio.h>

void exch(int *arr, long idx1, long idx2);
void quick(int *arr, long l, long h);
void print_arr(int* a, long len);
long median(int* arr, long l, long h);
long partition (int *arr, long l, long h, long pivot);
void sort(int* arr, long l, long r);
long len;

void quick(int* arr, long l, long h){
	long size = h - l + 1;
	if(size<=3){
		sort(arr,l,h);
	}else
	{
		long mid = median(arr,l,h);
		long pivot = partition(arr,l,h,mid);
		quick(arr, l, pivot-1);
		quick(arr, pivot+1, h);
	}

}

long median(int* arr, long l, long h){
	long mid = (l + h)/2;

	if(arr[l]>arr[mid])
		exch(arr,l,mid);

	if(arr[mid]>arr[h])
		exch(arr,h,mid);

	if(arr[l]>arr[h])
		exch(arr,l,h);

	exch(arr, mid, h-1);
	return arr[h-1];
}

long partition (int *arr, long l, long h, long pivot)
{	long left = l;
	long right = h-1;

	while(1){
		while(arr[left]<pivot){
			++left;
		}

		while(arr[right]>pivot){
			--right;
		}

		if(left >= right){
			break;
		}else{
			exch(arr,left,right);
		}
	}
	exch(arr,left,right-1);
	return left;
}

void sort(int* arr, long l, long r){

long size = r - l + 1;
if(size<=1){
	return;
}else if( size == 2){
	if(arr[l]>arr[r])
		exch(arr,l,r);
}else
	{
		if(arr[l]>arr[r-1])
			exch(arr,l,r-1);

		if(arr[l]>arr[r])
			exch(arr,r,l);

		if(arr[r]<arr[r-1])
			exch(arr,r-1,r);
	}

}


void exch(int *arr, long idx1, long idx2){
	int temp = arr[idx1];
	arr[idx1] = arr[idx2];
	arr[idx2] = temp;
}

void print_arr(int* a, long len)
{
	for(long i=0;i<len;i++){
		printf("%d,",a[i]);
	}
	printf("\n");
}

void quickSort(int* arr){
	quick(arr,0,len-1);
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

	quickSort(arr);

	print_arr(arr, nrIntegers);

	return 0;
}
