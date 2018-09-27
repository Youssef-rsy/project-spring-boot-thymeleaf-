package icda.taf.projet.projetCours.service;

import java.util.List;

import icda.taf.projet.projetCours.Entity.Enseignant;

public interface EnseignantServiceInterface {
	public Enseignant addEnseignant(Enseignant enseignant);
	public Enseignant updateEnseignant(Enseignant enseignant);
	public List<Enseignant> allEnseignant();
	public void deleteEnseignant(long id);
	public Enseignant getEnseignant(long id);
}
