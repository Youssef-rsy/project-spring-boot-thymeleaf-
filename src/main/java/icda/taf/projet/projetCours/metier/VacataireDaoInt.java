package icda.taf.projet.projetCours.metier;

import java.util.List;

import icda.taf.projet.projetCours.Entity.Vacataire;

public interface VacataireDaoInt {

	public Vacataire addVacataire(Vacataire vacataire);
	public Vacataire updateVacataire(Vacataire vacataire);
	public List<Vacataire> allVacataire();
	public void deleteVacataire(long id);
	public Vacataire getVacataire(long id);
}
