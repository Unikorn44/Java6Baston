package fr.m2i;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Menu {
	
	private int _choix;

	
	public int getChoix() {
		return _choix;
	}

	public void setChoix(int choix) {
		this._choix = choix;
	}
	

	
	
	public void choixPersonnage() {	
		
		System.out.println("Choisissez votre héros : 1-Guerrier 2-Sorcier 3-Healer");
		//lecture console
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		
		//try catch pour lecture console
		try {
			this.setChoix(Integer.parseInt(buff.readLine()));			
			//this.getChoix();
		} catch(Exception err) {
			
		}

	}

}
