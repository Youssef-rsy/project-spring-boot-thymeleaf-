package icda.taf.projet.projetCours.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Cours {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_idEnseignant")
	private Enseignant enseignant;
	
	@ManyToMany(mappedBy="cours", cascade=CascadeType.ALL)
	private List<Etudiant>  etudiants=new ArrayList<>();
	
	
	public Cours() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cours(String nom) {
		super();
		this.nom = nom;
	}
	
	public Cours(Long id, String nom, Enseignant enseignant, List<Etudiant> etudiants) {
		super();
		this.id = id;
		this.nom = nom;
		this.enseignant = enseignant;
		this.etudiants = etudiants;
	}
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	public List<Etudiant> getEtudiants() {
		return etudiants;
	}
	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	
	
}
