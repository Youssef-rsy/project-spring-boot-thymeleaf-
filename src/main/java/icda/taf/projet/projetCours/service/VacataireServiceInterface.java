package icda.taf.projet.projetCours.service;

import java.util.List;

import icda.taf.projet.projetCours.Entity.Vacataire;

public interface VacataireServiceInterface {
	public Vacataire addVacataire(Vacataire vacataire);
	public Vacataire updateVacataire(Vacataire vacataire);
	public List<Vacataire> allVacataire();
	public void deleteVacataire(long id);
	public Vacataire getVacataire(long id);
}
