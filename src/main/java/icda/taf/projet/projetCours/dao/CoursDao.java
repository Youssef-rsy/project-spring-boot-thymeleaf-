package icda.taf.projet.projetCours.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import icda.taf.projet.projetCours.Entity.Cours;
@Repository
public interface CoursDao extends JpaRepository<Cours , Long> {

	public Cours findByNom(String nom);
}
