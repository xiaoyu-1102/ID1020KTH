#include <stdio.h>
#include <string.h>

/* recursive way */

void foo(){
	char c = getchar();
	if(c!='\n'){
		foo();
		putchar(c);
	}
}

int main()
{
	char ch;

	printf("Input your content ");
	foo();

	putchar('\n');
	return 0;

}
