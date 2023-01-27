package peli;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Sanalista {
	
	private ArrayList<String> lista = new ArrayList <>();
	
	public Sanalista(String tiedosto) {
		try (Scanner sc = new Scanner(new File(tiedosto))) {
			while (sc.hasNextLine()) {
				lista.add(sc.nextLine());
		}
	}
		catch (Exception e){
			System.out.println("Virhe: " + e.getMessage());
		}
		
	}
	
	public ArrayList<String> annasanat(){
		return lista;
	}
	
}