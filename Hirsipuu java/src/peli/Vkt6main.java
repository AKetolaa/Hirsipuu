package peli;

import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Character.toLowerCase;

public class Vkt6main {

	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
		boolean ok = false;
		
		do {
			try {
				System.out.println("Give name of the list to be used > ");
				System.out.println("If using my list type sanat.txt");
				System.out.println("If you want to use your own words type file route to txt file");
				String tiedosto = sc.nextLine();
				Sanalista sanalista = new Sanalista(tiedosto);
				ArrayList <String> sanat = sanalista.annasanat();
				Hirsipuu peli = new Hirsipuu(sanat, 8);
				
				String sana = peli.sana();
				char [] kirjaimet = new char [sana.length()];
				int i = 0;
				while (i<sana.length()) {
					kirjaimet[i] = '_';
					if (sana.charAt(i)==' ') {
						kirjaimet[i] = ' ';
					}
					
					i++;
					
				}
				
				System.out.println("Let the game beging!");
				System.out.println(kirjaimet);
				int arvaustenLkm = peli.arvauksiaOnJaljella();
				System.out.println("Guesses left: " + arvaustenLkm);
				
				while (arvaustenLkm > 0) {
					char arvaus = kirjain();
					boolean toimiiko = peli.arvaa(arvaus);
					if(toimiiko) {
						System.out.println("All good");
						for (int j = 0; j < sana.length(); j++) {
							if(sana.charAt(j)==arvaus) {
								kirjaimet[j] = arvaus;
								}
							}
						if (peli.onLoppu(kirjaimet)) {
					    System.out.println(kirjaimet);
						System.out.println("You won!");
						break;
						}
						
					}else {
							System.out.println("Letter not found");
						}
						
						arvaustenLkm = peli.arvauksiaOnJaljella();
						System.out.println(kirjaimet);
						System.out.println("Guesses left: " +arvaustenLkm);
						System.out.println("Guessed letters" +peli.arvaukset());
						if (arvaustenLkm == 0) {
							System.out.println("You lost");
						}
						ok = true;
					}
				}
				catch (Exception e){
					System.out.println("Error");
					System.out.println("Virhe: " + e.getMessage());
				}
			}
			
			while (ok != true);
		sc.close();
	}
		
	public static Character kirjain(){
        Scanner sc = new Scanner(System.in);
        boolean ok = false;
        
        do{
            try{
                System.out.println("Arvaa kirjain: ");
                String apu = sc.nextLine();
                char kirjain = toLowerCase(apu.charAt(0));
                ok = true;
                return kirjain;
            }catch (Exception e){
                System.out.println("Virhe syotteessa.");
                System.out.println("Virhe: " + e.getMessage());
            }
        }while (ok != true);
        sc.close();
        
        return null;
    }

}