#include<stdio.h>
#include<stdlib.h>
FILE *fp;
struct employee
{
char name[20];
int key,salary;
}emp[20];
int n,m;
int *ht,index;
int count=0;
void insert(int key)
{
index=key%m;
while(ht[index]!=-1)
{
printf("\ncollision detected for %d and resolved using linear probing",key);
index=(index+1)%m;
}
ht[index]=key;
count++;
}
void display()
{
int i;
if(count==0)
{
printf("\nhash table is empty");
return;
}
printf("\nhash table contents are:\n");
for(i=0;i<m;i++)
printf("\n T[%d]->%d",i,ht[i]);
}
void main()
{
int i;
printf("\n enter the number of employee records:");
scanf("%d",&n);
printf("\n enter the two digit memory location for hash table:");
scanf("%d",&m);
ht=(int*)malloc(m*sizeof(int));
for(i=0;i<m;i++)
ht[i]=-1;
fp=fopen("c:\\program1.txt","w");
printf("\n enter the four digit key,name,salary values for n employee records:\n");for(i=0;i<n;i++)
{
scanf("%d %s %d",&emp[i].key,&emp[i].name,&emp[i].salary);
fprintf(fp,"%d \t %s \t %d \n",emp[i].key,emp[i].name,emp[i].salary);
}
fclose(fp);
fp=fopen("c:\\program1.txt","r");
for(i=0;i<n;i++)
{
if(count==m)
{
printf("\n ~~~Hash table is full.Cannot insert the record %d key~~~",i+1);
break;
}
fscanf(fp,"%d",&emp[i].key);
insert(emp[i].key);
}
fclose(fp);
display();
}