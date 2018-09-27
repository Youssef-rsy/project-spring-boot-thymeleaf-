package icda.taf.projet.projetCours.metier;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import icda.taf.projet.projetCours.Entity.Etudiant;
@Service
@Transactional
public class EtudiantDaoImple implements EtudiantDaoInt {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Etudiant addEtudiant(Etudiant etudiant) {
		// TODO Auto-generated method stub
		em.persist(etudiant);
		return etudiant;
	}

	@Override
	public Etudiant updateEtudiant(Etudiant etudiant) {
		// TODO Auto-generated method stub
		 em.merge(etudiant);
		return etudiant;
	}

	@Override
	public List<Etudiant> allEtudiant() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("from Etudiant");
		return q.getResultList();
	}

	@Override
	public void deleteEtudiant(long id) {
		// TODO Auto-generated method stub
		em.remove(getEtudiant(id));
	}

	@Override
	public Etudiant getEtudiant(long id) {
		// TODO Auto-generated method stub
		return em.find(Etudiant.class, id);
	}

}
