package icda.taf.projet.projetCours.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import icda.taf.projet.projetCours.Entity.Vacataire;
import icda.taf.projet.projetCours.metier.VacataireDaoInt;
@Service
public class VacataireServiceImplementation implements VacataireServiceInterface {

	@Autowired
	VacataireDaoInt metier;
	@Override
	public Vacataire addVacataire(Vacataire vacataire) {
		// TODO Auto-generated method stub
		return metier.addVacataire(vacataire);
	}

	@Override
	public Vacataire updateVacataire(Vacataire vacataire) {
		// TODO Auto-generated method stub
		return metier.updateVacataire(vacataire);
	}

	@Override
	public List<Vacataire> allVacataire() {
		// TODO Auto-generated method stub
		return metier.allVacataire();
	}

	@Override
	public void deleteVacataire(long id) {
		// TODO Auto-generated method stub
		metier.deleteVacataire(id);
	}

	@Override
	public Vacataire getVacataire(long id) {
		// TODO Auto-generated method stub
		return metier.getVacataire(id);
	}

}
