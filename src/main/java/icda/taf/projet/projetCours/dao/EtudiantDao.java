package icda.taf.projet.projetCours.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import icda.taf.projet.projetCours.Entity.Etudiant;

public interface EtudiantDao extends JpaRepository<Etudiant, Long> {

}
