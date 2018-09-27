package icda.taf.projet.projetCours.Entity;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="PERMANENT")
public class Permanent  extends Enseignant{
private String grade;


public Permanent() {
	super();
	// TODO Auto-generated constructor stub
}

public Permanent(Long id, String nom, String prenom, Adresse adresse, String service, List<Cours> cours) {
	super(id, nom, prenom, adresse, service, cours);
	// TODO Auto-generated constructor stub
}

public Permanent(Long id, String nom, String prenom, Adresse adresse) {
	super(id, nom, prenom, adresse);
	// TODO Auto-generated constructor stub
}

public Permanent(Long id, String nom, String prenom, Adresse adresse, String service, List<Cours> cours, String grade) {
	super(id, nom, prenom, adresse, service, cours);
	this.grade = grade;
}

public String getGrade() {
	return grade;
}

public void setGrade(String grade) {
	this.grade = grade;
}



}
