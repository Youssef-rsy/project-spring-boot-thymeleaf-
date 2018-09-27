package icda.taf.projet.projetCours.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import icda.taf.projet.projetCours.Entity.Etudiant;
import icda.taf.projet.projetCours.metier.EtudiantDaoInt;
@Service
public class EtudiantServiceImplementation implements EtudiantServiceInterfce {

	@Autowired
	EtudiantDaoInt metier;
	@Override
	public Etudiant addEtudiant(Etudiant etudiant) {
		// TODO Auto-generated method stub
		return metier.addEtudiant(etudiant);
	}

	@Override
	public Etudiant updateEtudiant(Etudiant etudiant) {
		// TODO Auto-generated method stub
		return metier.updateEtudiant(etudiant);
	}

	@Override
	public List<Etudiant> allEtudiant() {
		// TODO Auto-generated method stub
		return metier.allEtudiant();
	}

	@Override
	public void deleteEtudiant(long id) {
		// TODO Auto-generated method stub
		metier.deleteEtudiant(id);
	}

	@Override
	public Etudiant getEtudiant(long id) {
		// TODO Auto-generated method stub
		return metier.getEtudiant(id);
	}

}
