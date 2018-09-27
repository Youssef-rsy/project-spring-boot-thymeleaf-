package icda.taf.projet.projetCours.service;

import java.util.List;

import icda.taf.projet.projetCours.Entity.Etudiant;

public interface EtudiantServiceInterfce {
	public Etudiant addEtudiant(Etudiant etudiant);
	public Etudiant updateEtudiant(Etudiant etudiant);
	public List<Etudiant> allEtudiant();
	public void deleteEtudiant(long id);
	public Etudiant getEtudiant(long id);
}
