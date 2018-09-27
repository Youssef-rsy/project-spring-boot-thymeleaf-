package icda.taf.projet.projetCours.service;

import java.util.List;

import icda.taf.projet.projetCours.Entity.Permanent;

public interface PermantServiceInterface {
	public Permanent addPermanent(Permanent permanent);
	public Permanent updatePermanent(Permanent permanent);
	public List<Permanent> allPermanent();
	public void deletePermanent(long id);
	public Permanent getPermanent(long id);
}
