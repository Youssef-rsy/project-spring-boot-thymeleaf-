package icda.taf.projet.projetCours.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import icda.taf.projet.projetCours.Entity.Enseignant;
import icda.taf.projet.projetCours.metier.EnseignantDaoInt;
@Service
public class EnseignantServiceImplementation implements EnseignantServiceInterface {

	@Autowired
	EnseignantDaoInt metier;
	
	@Override
	public Enseignant addEnseignant(Enseignant enseignant) {
		// TODO Auto-generated method stub
		return metier.addEnseignant(enseignant);
	}

	@Override
	public Enseignant updateEnseignant(Enseignant enseignant) {
		// TODO Auto-generated method stub
		return metier.updateEnseignant(enseignant);
	}

	@Override
	public List<Enseignant> allEnseignant() {
		// TODO Auto-generated method stub
		return metier.allEnseignant();
	}

	@Override
	public void deleteEnseignant(long id) {
		// TODO Auto-generated method stub
		metier.deleteEnseignant(id);
	}

	@Override
	public Enseignant getEnseignant(long id) {
		// TODO Auto-generated method stub
		return metier.getEnseignant(id);
	}

}
