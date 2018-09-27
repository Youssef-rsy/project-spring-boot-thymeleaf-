package icda.taf.projet.projetCours.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import icda.taf.projet.projetCours.Entity.Personne;
import icda.taf.projet.projetCours.metier.PersonneDaoInt;
@Service
public class PersonneServiceImplementation implements PersonneServiceInterface {

	@Autowired
	PersonneDaoInt metier;
	@Override
	public Personne addPersonne(Personne personne) {
		// TODO Auto-generated method stub
		return metier.addPersonne(personne);
	}

	@Override
	public Personne updatePersonne(Personne personne) {
		// TODO Auto-generated method stub
		return metier.updatePersonne(personne);
	}

	@Override
	public List<Personne> allPersonne() {
		// TODO Auto-generated method stub
		return metier.allPersonne();
	}

	@Override
	public void deletePersonne(long id) {
		// TODO Auto-generated method stub
		metier.deletePersonne(id);
	}

	@Override
	public Personne getPersonne(long id) {
		// TODO Auto-generated method stub
		return metier.getPersonne(id);
	}

}
