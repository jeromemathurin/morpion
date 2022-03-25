package fr.jemat.morpion;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MorpionApplication {

	static String Joueur1, Joueur2, JoueurActif;
	static int NbTourJ1, NbTourJ2 = 0 ;
	static String [][] grill= new String[7][7];
	static boolean CaseVerif = false;
	static int CaseViderestante = 9;
	
	public static void main(String[] args) {
		SpringApplication.run(MorpionApplication.class, args);
		
		afficheTitre();
		saisiNomJoueur();
		etatGrill();
		for(int i = CaseViderestante; i>0; i--) {
			SaisieJoueur();		
			System.out.println(NbTourJ1);
			System.out.println(NbTourJ2);
			etatGrill();
		}
		
		WinEndGame();
		System.out.println("Game Over !");
		
		

	}
	

	/**
	 * 
	 */
	public static void incrementationTour() {
		// incrementation des nb tours de chaque joueur
		// Selection du joueur
		if(NbTourJ1 <= NbTourJ2) {
			JoueurActif = "X";
			NbTourJ1++;
		} else {
			JoueurActif = "O";
			NbTourJ2++;
		}
	}
	
	/**
	 * Saisie des joueurs
	 * @return 
	 */
	public static void SaisieJoueur() {
		//Scanner scan = new Scanner(System.in);
		try {
			// incrementation des nb tours de chaque joueur
			// Selection du joueur
			incrementationTour();
			System.out.println("joueurActif: " + JoueurActif);
			if (JoueurActif=="X") {
				System.out.println("Nom du Joueur: " + Joueur1);
			} else {
				System.out.println("Nom du Joueur: " + Joueur2);
			}
			
			/** case 11 choix 1 	case 13 choix 2	   case 15 choix 3
			 * case 31 choix 4 		case 33 choix 5 	case 35 choix 6
			 * case 51 choix 7 		case 53 choix 8 	case 55 choix 9 
			*/
			//saisi du choix joueur actif
			System.out.println("Saisir votre réponse");
			int choixJoueur = ScanJoueurInt();
			//remplir la grille de jeu
			if(choixJoueur > 0 && choixJoueur < 10) {
				System.out.println("Choix du joueur : " + choixJoueur);
				String rep = "nok";
				while(rep=="nok") {
					switch(choixJoueur) {
					case 1:
						// controle si la case choisi est libre					
						rep = VerifCase(1,1);
						System.out.println("reponse : " + rep);
						if(rep == "nok") {
							choixJoueur = ScanJoueurInt();
						}
						break;
					case 2:
						// controle si la case choisi est libre
						rep = VerifCase(1,3);
						System.out.println("reponse : " + rep);
						if(rep == "nok") {
							choixJoueur = ScanJoueurInt();
						}
						break;
					case 3:
						// controle si la case choisi est libre
						rep = VerifCase(1,5);
						System.out.println("reponse : " + rep);
						if(rep == "nok") {
							choixJoueur = ScanJoueurInt();
						}
						break;
					case 4:
						// controle si la case choisi est libre
						rep = VerifCase(3,1);
						System.out.println("reponse : " + rep);
						if(rep == "nok") {
							choixJoueur = ScanJoueurInt();
						}
						break;
					case 5:
						// controle si la case choisi est libre
						rep = VerifCase(3,3);
						System.out.println("reponse : " + rep);
						if(rep == "nok") {
							choixJoueur = ScanJoueurInt();
						}
						break;
					case 6:
						// controle si la case choisi est libre
						rep = VerifCase(3,5);
						System.out.println("reponse : " + rep);
						if(rep == "nok") {
							choixJoueur = ScanJoueurInt();
						}
						break;
					case 7:
						// controle si la case choisi est libre
						rep = VerifCase(5,1);
						System.out.println("reponse : " + rep);
						if(rep == "nok") {
							choixJoueur = ScanJoueurInt();
						}
						break;
					case 8:
						// controle si la case choisi est libre
						rep = VerifCase(5,3);
						System.out.println("reponse : " + rep);
						if(rep == "nok") {
							choixJoueur = ScanJoueurInt();
						}
						break;
					case 9:
						// controle si la case choisi est libre
						rep = VerifCase(5,5);
						System.out.println("reponse : " + rep);
						if(rep == "nok") {
							choixJoueur = ScanJoueurInt();
						}
						break;
					}
				}
				
					
			} else {
				System.out.println("Attention ce nombre n'est pas compris entre 1 et 9.");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Attention ce n'est pas un nombre.");
		}
		DecompteCaseVide();
		System.out.println("Case vide restantes : " + CaseViderestante);
	}
	
	//affichage du titre
	public static void afficheTitre() {
		System.out.println("--------- Le Morpion ---------");
		System.out.println("------------------------------");
	}
	
	//creation des joueurs
	public static ArrayList<String> saisiNomJoueur() {
		Scanner scan = new Scanner(System.in);
		for(int i=1; i<=2; i++) {
			System.out.println("Nom joueur "+i+" :");
			String joueur = scan.nextLine();
			if(i==1) {
				Joueur1 =joueur;
				NbTourJ1=0;
				System.out.println("joueur "+i+" is "+ Joueur1 );
			} else {
				Joueur2 =joueur;
				NbTourJ1=0;
				System.out.println("joueur "+i+" is "+ Joueur2 );
			}
		}
		ArrayList<String> listeJoueurs = new ArrayList<>();
		listeJoueurs.add(Joueur1);
		listeJoueurs.add(Joueur2);
		return listeJoueurs;
	}
	
	/**
	 * creation de la grille de jeu 
	 * Affichage 
	 */
	public static void etatGrill() {
		//String [][] grill= new String[7][7];
		for(int i=0; i <= grill.length-1 ; i++) {
			for(int j=0; j<= grill.length-1; j++) {
				if(i==0 || i==2 || i==4 || i==6) {
					//System.out.print(" _i="+i+"j="+j+"_ ");
					//grill[i][j]= ""+i + j ;
					if(j==0) {
						System.out.print(" ---");
						grill[i][j]= " ---";
					}else if(j==6)
					{
						System.out.print("----");
						grill[i][j]= "------";
					} else {
						System.out.print("-");
						grill[i][j]= "---";
					}
				} else if (j==0 || j==2 || j==4 || j==6) {
					//System.out.print(" _i="+i+"j="+j+"_ ");
					grill[i][j]= " |";
					//System.out.print(grill[i][j]);
					System.out.print(" |");
				} else {
					//System.out.print(" _break"+"i="+i+"j="+j+"_ ");
					//grill[i][j]= " break"+i + j ;
					if(grill[i][j]==null) {
						grill[i][j] = " ";
					}
					System.out.print(grill[i][j]);
					
				}
				
				//System.out.println("|"+i+j+"|");

			}
			System.out.println("");

		}
		
		
	}
	
	public static int ScanJoueurInt() {

		Scanner scan = new Scanner(System.in);
		int choixJoueur = scan.nextInt();
		
		return choixJoueur;
	}
	
	public static String ScanJoueurString() {
		Scanner scan = new Scanner(System.in);
		String choixJoueur = scan.nextLine();
		
		return choixJoueur;
	}
	
	public static String VerifCase(int a, int b) {
		String rep = "nok";
		if(grill[a][b]=="X" || grill[a][b]=="O") {
			System.out.println("Cette case a déjà été joué, Choisissez une autre case.");			
		} else {
			grill[a][b]=JoueurActif;
			rep = "ok";
		}
		return rep;
	} 
	
	public static void DecompteCaseVide() {
		CaseViderestante--;
	}

	/**
	 * calculer les points
	 */
	public static void WinEndGame() {
		int [] pointTotal = {0,0};
		int [] pointXO = {0,0};
				if (grill[1][1] == grill[3][1] && grill[3][1] == grill[5][1]) {
					pointXO = attribPointXO();
					//incrémentation des points de chaque joueur
					pointTotal[0] = pointTotal[0] + pointXO[0];
					pointTotal[1] = pointTotal[1] + pointXO[1];
				}
				if (grill[1][1] == grill[1][3] && grill[1][3] == grill[1][5]) {
					pointXO = attribPointXO();
					//incrémentation des points de chaque joueur
					pointTotal[0] = pointTotal[0] + pointXO[0];
					pointTotal[1] = pointTotal[1] + pointXO[1];
				}
				if (grill[1][1] == grill[3][3] && grill[3][3] == grill[5][5]) {
					pointXO = attribPointXO();
					//incrémentation des points de chaque joueur
					pointTotal[0] = pointTotal[0] + pointXO[0];
					pointTotal[1] = pointTotal[1] + pointXO[1];
				}
				if (grill[1][3] == grill[3][3] && grill[3][3] == grill[5][3]) {
					pointXO = attribPointXO();
					//incrémentation des points de chaque joueur
					pointTotal[0] = pointTotal[0] + pointXO[0];
					pointTotal[1] = pointTotal[1] + pointXO[1];
				}
				if (grill[1][5] == grill[3][5] && grill[3][5] == grill[5][5]) {
					pointXO = attribPointXO();
					//incrémentation des points de chaque joueur
					pointTotal[0] = pointTotal[0] + pointXO[0];
					pointTotal[1] = pointTotal[1] + pointXO[1];
				}
				if (grill[3][1] == grill[3][3] && grill[3][3] == grill[3][5]) {
					pointXO = attribPointXO();
					//incrémentation des points de chaque joueur
					pointTotal[0] = pointTotal[0] + pointXO[0];
					pointTotal[1] = pointTotal[1] + pointXO[1];
				}
				if (grill[5][1] == grill[5][3] && grill[5][3] == grill[5][5]) {
					pointXO = attribPointXO();
					//incrémentation des points de chaque joueur
					pointTotal[0] = pointTotal[0] + pointXO[0];
					pointTotal[1] = pointTotal[1] + pointXO[1];
				}
				if (grill[1][5] == grill[3][3] && grill[3][3] == grill[5][1]) {
					pointXO = attribPointXO();
					//incrémentation des points de chaque joueur
					pointTotal[0] = pointTotal[0] + pointXO[0];
					pointTotal[1] = pointTotal[1] + pointXO[1];
				}
				//Affichage des points de chaque joueur
		System.out.println("Total de point de "+ Joueur1 +" : " + pointTotal[0]);
		System.out.println("Total de point de "+ Joueur2 +" : " + pointTotal[1]);
		
		//Affichage du vainqueur
		if(pointTotal[0] > pointTotal[1]) {
			System.out.println("Vainqueur "+ Joueur1 +" !");
			System.out.println(pointTotal[0] +" pt(s)");
		} else if (pointTotal[0] < pointTotal[1]) {
			System.out.println("Vainqueur "+ Joueur2 +" !");
			System.out.println(pointTotal[1] +" pts");
		} else {
			System.out.println("Désolé il n'y a pas de vainqueur ");
			System.out.println("Bravo aux joueurs " + Joueur1 + " et " + Joueur2);
		}
	}
	
	/**
	 * Attribution des points en fonction du joueur X ou O
	 * @return 
	 */
	public static int[] attribPointXO() {
		int [] point = {0,0} ;
		if(grill[1][1] == "X") {
			point[0]++;
		} else {
			point[1]++;
		}
		return point;
	}

}
