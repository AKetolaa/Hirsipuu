package peli;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hirsipuu{
	private int arvaukset;
	private String sana;
	private ArrayList<Character> arvatut = new ArrayList<>();
	
	public Hirsipuu(ArrayList<String> lista, int arvaukset) {
		Random rand = new Random();
		this.sana = lista.get(rand.nextInt(lista.size()));
		this.arvaukset = arvaukset;
	}
	
	public boolean arvaa (Character merkki) {
		arvatut.add(merkki);
		if (this.sana.contains(Character.toString(merkki))) {
			return true;
		}
		else {
			this.arvaukset--;
		}
		return false;
	}
	
	public List<Character> arvaukset(){
		return arvatut;
	}
	
	public int arvauksiaOnJaljella() {
		return this.arvaukset;
	}
	
	public String sana() {
		return this.sana;
	}
	
	public boolean onLoppu(char[] kirjaimet) {
		if(sana.equals(String.valueOf(kirjaimet))) {
			return true;
		}
		return false;
	}
}