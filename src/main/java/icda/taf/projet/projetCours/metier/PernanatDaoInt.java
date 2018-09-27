package icda.taf.projet.projetCours.metier;

import java.util.List;

import icda.taf.projet.projetCours.Entity.Permanent;

public interface PernanatDaoInt {
	public Permanent addPermanent(Permanent permanent);
	public Permanent updatePermanent(Permanent permanent);
	public List<Permanent> allPermanent();
	public void deletePermanent(long id);
	public Permanent getPermanent(long id);
}
