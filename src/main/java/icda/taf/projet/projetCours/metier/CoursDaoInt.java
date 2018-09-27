package icda.taf.projet.projetCours.metier;

import java.util.List;

import icda.taf.projet.projetCours.Entity.Cours;

public interface CoursDaoInt {

	public Cours addCours(Cours cours);
	public Cours updateCours(Cours cours);
	public List<Cours> allCours();
	public List<Cours> listOfNonAssignedCours();
	public void deleteCours(long id);
	public Cours getCours(long id);
	public Cours getCoursByNom(String nom);
}
