package icda.taf.projet.projetCours.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import icda.taf.projet.projetCours.Entity.Enseignant;

public interface EnseignatDao extends JpaRepository<Enseignant, Long> {

}
