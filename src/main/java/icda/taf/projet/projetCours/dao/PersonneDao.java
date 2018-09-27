package icda.taf.projet.projetCours.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import icda.taf.projet.projetCours.Entity.Personne;

public interface PersonneDao extends JpaRepository<Personne, Long>{

}
