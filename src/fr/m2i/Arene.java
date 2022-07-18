package fr.m2i;

import fr.m2i.Personnage.*;

public class Arene {
	
	Affichage aff;
	Menu menu;
	private Personnage _p1;
	private Personnage _p2;
	private Guerrier _guerrier;
	private Sorcier _sorcier;
	private Healer _healer;
	
	
	
	
	public Arene () {
		this.aff = new Affichage();
		this.menu = new Menu();
	}

	public void execute() {
		_guerrier = new Guerrier("Crom", "Estelle");
		_sorcier = new Sorcier("Abracadabra", "Martin");
		_healer = new Healer("Fraise", "Thomas");
		
		this.miseEnPlace();
		
		this.Combat();
	}

	public void miseEnPlace() {
		for (int  i=1; i<3; i++) {
			menu.choixPersonnage();
			this.traitementChoixPersonnage(menu.getChoix(), i);			
		}
	}
	
	public void traitementChoixPersonnage(int choix, int i) {
		
		switch(choix){
			case 1:
				this.aff.affiche("Vous avez choisi le guerrier !");
				if(i==1) {
					this._p1 = this._guerrier;
				}else {
					this._p2 = _guerrier;					
				}
				break;
			case 2:
				this.aff.affiche("Vous avez choisi le sorcier !");
				if(i==1) {
					this._p1 = _sorcier;
				}else {
					this._p2 = _sorcier;					
				}
				break;
			case 3:
				this.aff.affiche("Vous avez choisi le healer !");
				if(i==1) {
					this._p1 = _healer;
				}else {
					this._p2 = _healer;					
				}
				break;
			default:
				this.aff.affiche("Le choix DOIT être entre 1 et 3");
				this.aff.affiche("ON RECOMMENCE A ZERO !!!");
				this.miseEnPlace();
		}
	}
	
	
	public void Combat() {
		
		while(this._p1.estVivant() && this._p2.estVivant()) {			
			this.aff.afficheInfoPersonnage(this._p1);
			this.aff.afficheInfoPersonnage(this._p2);
			int rand = (int) Math.round(Math.random());
			if (rand == 0) {
				this._p2.subir(this._p1.attaquer());
			} else {
				this._p1.subir(this._p2.attaquer());
			}
			this.aff.separateur();
		}
		
		if (this._p1.estVivant()) {
			aff.affiche(this._p1.getNom() + " " + this._p1.getPrenom() + " est le vainqueur");
		}
		
		if (this._p2.estVivant()) {
			aff.affiche(this._p2.getNom() + " " + this._p2.getPrenom() + " est le vainqueur");
		}
	}
}
