package icda.taf.projet.projetCours.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.stereotype.Service;

import icda.taf.projet.projetCours.Entity.Cours;
import icda.taf.projet.projetCours.metier.CoursDaoInt;
@Service
public class CoursServiceImplementation implements CoursServiceInteface {

	@Autowired
	CoursDaoInt metier;
	@Override
	public Cours addCours(Cours cours) {
		// TODO Auto-generated method stub
		return metier.addCours(cours);
	}

	@Override
	public Cours updateCours(Cours cours) {
		// TODO Auto-generated method stub
		return metier.updateCours(cours);
	}

	@Override
	public List<Cours> allCours() {
		// TODO Auto-generated method stub
		return metier.allCours();
	}

	@Override
	public void deleteCours(long id) {
		// TODO Auto-generated method stub
		metier.deleteCours(id);
	}

	@Override
	public Cours getCours(long id) {
		// TODO Auto-generated method stub
		return metier.getCours(id);
	}

	@Override
	public Cours getCoursByNom(String nom) {
		// TODO Auto-generated method stub
		return metier.getCoursByNom(nom);
	}

	@Override
	public List<Cours> listOfNonAssignedCours() {
		// TODO Auto-generated method stub
		return metier.listOfNonAssignedCours();
	}

}
