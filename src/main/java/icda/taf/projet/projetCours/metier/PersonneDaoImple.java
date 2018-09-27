package icda.taf.projet.projetCours.metier;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import icda.taf.projet.projetCours.Entity.Personne;
@Service
@Transactional
public class PersonneDaoImple implements PersonneDaoInt {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Personne addPersonne(Personne personne) {
		// TODO Auto-generated method stub
		em.persist(personne);
		return personne;
	}

	@Override
	public Personne updatePersonne(Personne personne) {
		// TODO Auto-generated method stub
		 em.merge(personne);
		return personne;
	}

	@Override
	public List<Personne> allPersonne() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("from Personne");
		return q.getResultList();
	}

	@Override
	public void deletePersonne(long id) {
		// TODO Auto-generated method stub
		em.remove(getPersonne(id));
	}

	@Override
	public Personne getPersonne(long id) {
		// TODO Auto-generated method stub
		return em.find(Personne.class, id);
	}


}
