package icda.taf.projet.projetCours.metier;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import icda.taf.projet.projetCours.Entity.Enseignant;
@Service
@Transactional
public class EnseignantDaoImple implements EnseignantDaoInt {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Enseignant addEnseignant(Enseignant enseignant) {
		// TODO Auto-generated method stub
		em.persist(enseignant);
		return enseignant;
	}

	@Override
	public Enseignant updateEnseignant(Enseignant enseignant) {
		// TODO Auto-generated method stub
		 em.merge(enseignant);
		return enseignant;
	}

	@Override
	public List<Enseignant> allEnseignant() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("from Enseignant");
		return q.getResultList();
	}

	@Override
	public void deleteEnseignant(long id) {
		// TODO Auto-generated method stub
		em.remove(getEnseignant(id));
	}

	@Override
	public Enseignant getEnseignant(long id) {
		// TODO Auto-generated method stub
		return em.find(Enseignant.class, id);
	}

}
