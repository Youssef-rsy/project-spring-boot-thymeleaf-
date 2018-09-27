package icda.taf.projet.projetCours.metier;

import java.util.List;

import icda.taf.projet.projetCours.Entity.Personne;

public interface PersonneDaoInt {

	public Personne addPersonne(Personne personne);
	public Personne updatePersonne(Personne personne);
	public List<Personne> allPersonne();
	public void deletePersonne(long id);
	public Personne getPersonne(long id);
	
}
