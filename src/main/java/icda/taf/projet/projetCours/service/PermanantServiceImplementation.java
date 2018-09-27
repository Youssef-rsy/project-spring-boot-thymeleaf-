package icda.taf.projet.projetCours.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import icda.taf.projet.projetCours.Entity.Permanent;
import icda.taf.projet.projetCours.dao.PermanenttDao;
import icda.taf.projet.projetCours.metier.PernanatDaoInt;
@Service
public class PermanantServiceImplementation implements PermantServiceInterface{

	@Autowired
	PernanatDaoInt metier;
	
	@Override
	public Permanent addPermanent(Permanent permanent) {
		// TODO Auto-generated method stub
		return metier.addPermanent(permanent);
	}

	@Override
	public Permanent updatePermanent(Permanent permanent) {
		// TODO Auto-generated method stub
		return metier.updatePermanent(permanent);
	}

	@Override
	public List<Permanent> allPermanent() {
		// TODO Auto-generated method stub
		return metier.allPermanent();
	}

	@Override
	public void deletePermanent(long id) {
		// TODO Auto-generated method stub
		metier.deletePermanent(id);
	}

	@Override
	public Permanent getPermanent(long id) {
		// TODO Auto-generated method stub
		return metier.getPermanent(id);
	}

}
