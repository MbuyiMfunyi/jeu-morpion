package morpion;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		System.out.println("############bienvenue dans le jeu du Morpion #############################  ");
		
		Scanner entier1= new Scanner(System.in);
		System.out.println("entrez un entier entr 3 et 5: ");
		int entier= entier1.nextInt();
		
		if(entier<3 || entier >5){
			System.out.println("taille non valide veuillez entrer un nombre entre 3 et 5 !!!");
			main(args);
		}else{
				int[][]tableau = new int[entier+2][entier+2];
				
				mesMesthodes.afficherMonTableau(tableau);
		
		
		Scanner premierJouer1= new Scanner(System.in);
		System.out.println("quel jouer doit commencer le joueur1 ou le joueur 2 ? : ");
		int premierJouer= premierJouer1.nextInt();
		System.out.println("le premier joueur est le numero "+  premierJouer);
		
		if(premierJouer !=1 &&  premierJouer !=2){
			Principal.main(args);
		}
		
		
	
	
	
	
	
	 int continuer=0;
	 while(continuer==0){
		 if(premierJouer==1){

				Scanner ligneJouer1= new Scanner(System.in);
				System.out.println("dans quel ligne le jouer 1 veut il jouer ? : ");
				int ligne1= ligneJouer1.nextInt(); 
				
				Scanner colonneJouer1= new Scanner(System.in);
				System.out.println("dans quel colonne le jouer 1 veut il jouer ? : ");
				int colonne1= colonneJouer1.nextInt(); 
				
				if(tableau[ligne1][colonne1]==0){
					tableau[ligne1][colonne1]=1;
					mesMesthodes.testertout(tableau,ligne1,colonne1);
					premierJouer=2;
					mesMesthodes.afficherMonTableau(tableau);
					System.out.println(" ");
					
				}else {System.out.println("Rejouer ");
				premierJouer=1;
				mesMesthodes.afficherMonTableau(tableau);
				}}
		 
		 if(premierJouer==2){

				Scanner ligneJouer2= new Scanner(System.in);
				System.out.println("dans quel ligne le jouer 2 veut il jouer ? : ");
				int ligne2= ligneJouer2.nextInt(); 
				
				Scanner colonneJouer2= new Scanner(System.in);
				System.out.println("dans quel colonne le jouer 2 veut il jouer ? : ");
				int colonne2= colonneJouer2.nextInt(); 
				
				if(tableau[ligne2][colonne2]==0){
					tableau[ligne2][colonne2]=2;
					mesMesthodes.testertout(tableau,ligne2,colonne2);
					premierJouer=2;
					mesMesthodes.afficherMonTableau(tableau);
					System.out.println(" ");
					
				}else System.out.println("Rejouer ");
				premierJouer=2;
				mesMesthodes.afficherMonTableau(tableau);
			}}}}
	
	
      public static class mesMesthodes{
	   
	  public static void afficherMonTableau(int[][] tableau){
		  
		  for(int i=0; i<tableau.length; i++){
			  
			  System.out.println(" ");
			  for(int j=0; j<tableau.length; j++){
				  
				  
				  
				  tableau[0][j]=99;
				  tableau[i][0]=99;
				  tableau[tableau.length-1][j]=99;
				  tableau[i][tableau.length-1]=99;
				  
				  
				  if(tableau[i][j]==1){
					  System.out.print(("x"));
				  }
				  if(tableau[i][j]==2){
					  System.out.print(("0"));}
				  
				  if(tableau[i][j]==99){
					  System.out.print(("#"));
				  }
				  if(tableau[i][j]==0){
					  System.out.print((" "));
				  }
				  
			  }
			  
		  }}
	  public static int combienDirection(int [][] t, int i, int j, int deltai, int deltaj){
		  int couleur= t[i][j];
		  int compteur =0;
		  
		  while(i+deltaj>=0 && i+deltai<t.length && j+deltaj>=0 && j+deltaj<t[0].length && t[i+deltai][j+deltaj]==couleur){
			compteur=compteur+1;
			i=i+deltai;
			j=j+deltaj;
		  }
		 return compteur; 
	  }
	  
	  public static boolean testerligne(int [][]t, int i, int j){
		  int g=combienDirection(t,i,j,0,-1);
		  int d=combienDirection(t,i,j,0,1 );
		  
		  if((g+d)>=2){
			  return true;
		  }else{
			  return false;
		  }
		  
	  }
	  
	  
	  public static boolean testercolonne(int[][] t, int i, int j) {
		  int g= combienDirection(t, i, j, 1, 0);
		  int d = combienDirection(t, i, j , 1,1);
		  if ((g+d)>=2) {
			  return true;
		  }else {
			  return false;
		  }
	  }
	  
	  public static boolean testerdiagonale1(int[][] t, int i, int j) {
		  int g = combienDirection(t, i, j, -1, -1);
		  int d = combienDirection(t, i, j, 1, 1);
		  if((g+d)>=2) {
			return true;  
		  }else {
			  return false;
		  }
		  
	  }
	  
	  
	  public static boolean testerdiagonale2(int[][] t, int i, int j) {
		  int g = combienDirection(t, i, j, -1, 1);
		  int d = combienDirection(t, i, j, 1, -1);
		  if(g+d>=2) {
			return true;  
		  }else {
			  return false;
		  }
		  
	  }
	  
	  
	  
	 public static boolean testertout( int[][] t , int i ,  int j) {
		 
		 if (testerligne(t , i , j) == true ⎮⎮ testercolonne(t, i, j) == true ⎮⎮ testerdiagonale1(t, i, j) == true ⎮⎮  
				 testerdiagonale2(t, i, j)== true) {
			 
			 System.out.println("VOUS AVEZ GAGNEZ !!!!!!!!!");
			 return true;
		 }else {
			 return false; }
	 }
	 
	  
      }
      
}


		  
	


