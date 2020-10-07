/*This program will go through the file, delete those which is not letters,
replaced by empty space but keep new line and numbers*/

#include <string.h>
#include <stdlib.h>
#include <stdio.h>
#include <ctype.h>

void delete(char* ch);
int is_number(char ch);

int is_number(char ch)
{
	return ch >= '0' && ch <= '9';
}


void delete(char* ch){
	if(isalpha(*ch)==0 && *ch != '\n' && *ch != '\r' && !is_number(*ch)){
		*ch = ' ';
	}
}

int main(){
	char ch;
	FILE * fp;


	fp = fopen("file.txt", "r"); // get file

   	if (fp == NULL)
   	{
    		perror("Error while opening the file.\n");
   	}

	while((ch = fgetc(fp)) != EOF){
		delete(&ch);
		putchar(ch);
	}

	printf("\r\n");

  	//printf("%s",fp);

	fclose(fp);
	return 0;
}
