#include <stdio.h>
#include <string.h>

/* iterative way */

void foo(){
	char arr[20];

	int i;
	for(i=0;i<20;i++){
		char n = getchar();
		if(n ==  '\n')
			break;

		arr[i] = n;
	}

	for(int j=i-1; j>=0;j--){
		putchar(arr[j]);
	}
}

int main()
{
	printf("say something\n");
	foo();
	putchar('\n');
	return 0;

}
