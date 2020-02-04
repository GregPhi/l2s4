#include <stdio.h>
#include <stdlib.h>
#include "ArbreBinaire.h"
#include "Affichage.h"

#define max(a,b) ((a)>(b)?(a):(b))

int cmp;

int effi[20];

/* Philippot Gregoire and Pelage François-Xavier */

/* Manipulation d'arbres binaires */

Noeud_t arbre1 (void) {
  Noeud_t arbre, tmp;
  arbre = CreerNoeud(12);
  tmp = CreerNoeud(9);
  AjouterFilsGauche(arbre, tmp);
  tmp = CreerNoeud(8);
  AjouterFilsDroit(arbre, tmp);
  SauverArbreDansFichier(arbre,"arbre1");
  return arbre;
}

Noeud_t arbre2 (void) {
  Noeud_t arbre, tmp, tmp2;
  arbre = CreerNoeud(12);
  tmp = CreerNoeud(9);
  AjouterFilsGauche(arbre, tmp);
  tmp2 = CreerNoeud(5);
  AjouterFilsDroit(tmp, tmp2);
  tmp = tmp2;
  tmp2 = CreerNoeud(7);
  AjouterFilsGauche(tmp, tmp2);
  SauverArbreDansFichier(arbre,"arbre2");
  return arbre;
}

Noeud_t arbre3 (void) {
  Noeud_t arbre, tmp, tmp2, tmp3;
  arbre = CreerNoeud(12);
  tmp = CreerNoeud(9);
  AjouterFilsGauche(arbre, tmp);
  tmp2 = CreerNoeud(1);
  AjouterFilsGauche(tmp, tmp2);
  tmp3 = CreerNoeud(5);
  AjouterFilsDroit(tmp, tmp3);
  tmp = CreerNoeud(8);
  AjouterFilsDroit(arbre, tmp);
  tmp2 = CreerNoeud(4);
  AjouterFilsDroit(tmp, tmp2);
  tmp3 = CreerNoeud(7);
  AjouterFilsGauche(tmp2, tmp3);
  tmp3 = CreerNoeud(6);
  AjouterFilsDroit(tmp2, tmp3);
  SauverArbreDansFichier(arbre, "arbre3");
  return arbre;
}

void imprimer (Noeud_t a) {
  if (a != NULL){
    imprimer(FilsGauche(a));
    printf("%ld", ValeurDuNoeud(a));
    printf(" ");
    imprimer(FilsDroit(a));
  }
}

int taille (Noeud_t a) {
  if (a == NULL){
    return 0;
  }
  if (EstFeuille(a)){
    return 1;
  }
  else{
    return 1 + taille(FilsGauche(a)) +  taille(FilsDroit(a));
  }
}

int hauteur (Noeud_t a) {
  if (a != NULL ){
    int d;
    int g;
    d = 1 + hauteur(FilsDroit(a));
    g = 1 + hauteur(FilsGauche(a));
    return max(g,d);
  }
  return -1;
}

int nbFeuilles(Noeud_t a) {
  if (a == NULL){
    return 0;
  }
  if (EstFeuille(a)){
    return 1;
  }
  return nbFeuilles(FilsGauche(a)) + nbFeuilles(FilsDroit(a));
}


/* Comptage d'arbres */

int nbArbres(int n) {
  int i;
  int sum;
  sum = 0;
  if (n == 0){
    return 1;
  }
  for(i = 0; i < n; i++){
    sum += nbArbres(i) * nbArbres(n-1-i);
  }
  return sum;
}

int nbArbresEfficaces(int n){
  int i, sum;
  sum = 0;
  effi[0] = 1;
  effi[1] = 1;
  if (n == 0 || n == 1){
    return 1;
  }
  for (i = 0; i < n; i++){
    sum+=effi[i]*effi[n-i-1];
  }
  effi[n] = sum;
  return sum;
}

/* Manipulation d'arbres binaires de recherche */

Noeud_t abr1 (void) {
  Noeud_t tab[6];
  int i;
  value_t tab2[6] = {6,4,2,7,5,1};
  for (i = 0; i < 6; i++){
    tab[i] = CreerNoeud(tab2[i]);
  }
  AjouterFilsGauche(tab[0], tab[1]);
  AjouterFilsDroit(tab[0], tab[3]);
  AjouterFilsGauche(tab[1], tab[2]);
  AjouterFilsDroit(tab[1], tab[4]);
  AjouterFilsGauche(tab[2], tab[5]);
  return tab[0];
}

Noeud_t ajouter (value_t v, Noeud_t a) {
  if (ValeurDuNoeud(a) >= v){
    if (EstVide(FilsGauche(a))){
      AjouterFilsGauche(a, CreerNoeud(v));
      return a;
    }else{
      ajouter(v, FilsGauche(a));
    }
  }
  if (ValeurDuNoeud(a) <= v){
    if (EstVide(FilsDroit(a))){
      AjouterFilsDroit(a, CreerNoeud(v));
      return a;
    }else{
      ajouter(v, FilsDroit(a));
    }
  }
  return a;
}

Noeud_t abr2 (void) {
  int i;
  Noeud_t tab[6];
  value_t tab2[6] = {5,4,2,7,6,1};
  tab[0] = CreerNoeud(tab2[0]);
  for (i = 1; i < 6; i++){
    ajouter(tab2[i],tab[0]);
  }
  return tab[0];
}

Noeud_t abr3 (void) {
  int i;
  Noeud_t tab[6];
  value_t tab2[6] = {7,1,4,5,6,2};
  tab[0] = CreerNoeud(tab2[0]);
  for (i = 1; i < 6; i++){
    ajouter(tab2[i],tab[0]);
  }
  return tab[0];
}

int appartient (value_t v, Noeud_t a) {
  if(!EstVide(a)){
    cmp++;
    if(ValeurDuNoeud(a) > v){
      return appartient(v, FilsGauche(a));
    }
    cmp++;
    if(ValeurDuNoeud(a) == 1){
      return 1;
    }
    return appartient(v, FilsDroit(a));
  }
  return 0;
}

int valeur_minimale (Noeud_t abr) {
  if(EstVide(FilsGauche(abr))){
    return ValeurDuNoeud(abr);
  }
  return valeur_minimale(FilsGauche(abr));
}

int valeur_maximale (Noeud_t abr) {
  if(EstVide(FilsDroit(abr))){
    return ValeurDuNoeud(abr);
  }
  return valeur_maximale(FilsDroit(abr));
}

/* Entier mysterieux */
int construct(Noeud_t arbre, value_t m, value_t n){
  value_t l;
  if(m+1 != n){
    l = (m+n)/2;
    ajouter(l, arbre);
    if(m != l){
      construct(arbre, m, l);
    }
    if(n != l){
      construct(arbre, l, n);
    }
  }
  return 0;
}


Noeud_t construitArbreEntierMysterieux (value_t i, value_t j) {
  value_t k;
  Noeud_t arbre;
  k = (i+j)/2;
  arbre = CreerNoeud(k);
  construct(arbre, i, k);
  construct(arbre, k, j);
  ajouter(i, arbre);
  ajouter(j, arbre);
  return arbre;
}

void jouer (int n, int x) {
  Noeud_t arbre;
  char c;
  value_t t;
  arbre = construitArbreEntierMysterieux(n, x);
  t = ValeurDuNoeud(arbre);
  printf("Number of %d to %d \n", n, x);
  printf("%ld is correct ? More small ? More huge ? Put(c, s or h) : ", t);
  c = getchar();
  printf("\n");
  while(c != 'c'){
    if(c == 10){

    }else{
      if(c == 's'){
        arbre = FilsGauche(arbre);
        if(EstVide(arbre)){
          printf("Computer have not loose, you have lied");
          exit(0);
        }
        t = ValeurDuNoeud(arbre);
      }
      if(c == 'h'){
        arbre = FilsDroit(arbre);
        if(EstVide(arbre)){
          printf("Computer have not loose, you have lied");
          exit(0);
        }
        t = ValeurDuNoeud(arbre);
      }
      printf("%ld is correct ? More small ? More huge ? Put(c, s or h) : ", t);
    }
    c = getchar();
  }
  printf("Computer is happy \n");
}

/* Tests sur les arbres binaires */

void testArbreBinaire(Noeud_t a) {
   imprimer(a); printf("\n");
   printf("Taille     = %d\n",(taille(a)));
   printf("Hauteur    = %d\n",(hauteur(a)));
   printf("nbFeuilles = %d\n",(nbFeuilles(a)));
}

/* Tests sur les arbres binaires de recherche */
void testABR (Noeud_t a) {
   int i;
   imprimer(a); printf("\n");
   printf("Taille     = %d\n",(taille(a)));
   printf("Hauteur    = %d\n",(hauteur(a)));
   printf("nbFeuilles = %d\n",(nbFeuilles(a)));
   printf("Valeurs présentes dans l'arbre : ");
   for (i = 1; i <= 10; i++) {
      if (appartient(i,a)) {
         printf("%d ",i);
      }
   }
   printf("%d",cmp);
   printf("\n");
}

/* Programme principal */
int main (int argc, char **argv) {

   int i;
   int n;
   int m;
   printf("Test arbre 1");
   testArbreBinaire(arbre1());
   printf("\n");
   printf("Test arbre 2");
   testArbreBinaire(arbre2());
   printf("\n");
   printf("Test arbre 3");
   testArbreBinaire(arbre3());
   printf("\n");
   printf("Test nbArbre");
   printf("\n");
   for (i = 0; i <= 19; i++) {
      printf("Le nombre d'arbres à %d noeuds est %d\n",i,(nbArbres(i)));
   }
   printf("\n");
   printf("Test nbArbresEfficaces");
   printf("\n");
   for (i = 0; i <= 19; i++) {
      printf("Le nombre d'arbres à %d noeuds est %d\n",i,(nbArbresEfficaces(i)));
   }
   printf("\n");
   testABR(abr1());
   printf("\n");
   testABR(abr2());
   printf("\n");
   testABR(abr3());
   printf("\n");
   printf("Arbre mysterieux entre 12 et 24:\n");
   imprimer(construitArbreEntierMysterieux(12,24));
   printf("\n");
   printf("\n");
   printf("JOUER");
   printf("\n");
   printf("n doit être inférieur à m");
   printf("\n");
   printf("n : ");
   scanf("%d",&n);
   printf("m : ");
   scanf("%d",&m);
   printf("\n");
   jouer(n,m);

   return 0;
}
