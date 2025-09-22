#include<stdio.h>
#include<stdlib.h>
int dichotomie(int * tab, int taille, int valeur)  {
int debut=0;
int fin=taille-1;
int m;
while (debut<=fin) {
    m=(debut+fin)/2;
   if(tab[m]==valeur) return m;
   if(tab[m]>valeur) fin=m-1;
   else debut=m+1;
}
return -1;
}

int main () {
int tab[]={0,1,2,3,4,5,6,7,8,9,10};
int a =dichotomie(tab, 11, 9);
printf("%d",a);
return EXIT_SUCCESS;
}
