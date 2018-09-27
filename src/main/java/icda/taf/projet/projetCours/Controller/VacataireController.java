package icda.taf.projet.projetCours.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import icda.taf.projet.projetCours.Entity.Cours;
import icda.taf.projet.projetCours.Entity.Enseignant;
import icda.taf.projet.projetCours.Entity.Vacataire;
import icda.taf.projet.projetCours.Entity.Vacataire;
import icda.taf.projet.projetCours.service.CoursServiceInteface;
import icda.taf.projet.projetCours.service.EnseignantServiceInterface;
import icda.taf.projet.projetCours.service.PermantServiceInterface;
import icda.taf.projet.projetCours.service.VacataireServiceInterface;

@Controller
public class VacataireController {
	
	@Autowired
	private VacataireServiceInterface vacataireservice;
	private List<Vacataire> lstvacataire;
	
	
	@Autowired
	private CoursServiceInteface courservice;
	private List<Cours> lstcour ;
	private Cours cour;
	
	@Autowired
	private EnseignantServiceInterface ensservice;
	private Enseignant ens;
	
	@RequestMapping("/addvacataire")
	public String addCours(Vacataire vacataire, Model model){
		System.out.println(vacataire.getNom() +" "+ vacataire.getPrenom() +" "+vacataire.getService()+" "+vacataire.getEmployeur()+" "+vacataire.getAdresse().getRue()+" "+vacataire.getAdresse().getVille()+" " );
		vacataireservice.addVacataire(vacataire);
		lstcour = courservice.listOfNonAssignedCours();
		model.addAttribute("lstcour", lstcour);
		System.out.println("--------------->"+lstcour.size());
		lstvacataire = vacataireservice.allVacataire();
		model.addAttribute("lstvacataire", lstvacataire);
		return "vacataires";
	}
	
	@RequestMapping("vacataires")
	public String listCours(Model model){
		lstvacataire = vacataireservice.allVacataire();
		model.addAttribute("lstvacataire", lstvacataire);
		lstcour = courservice.listOfNonAssignedCours();
		model.addAttribute("lstcour", lstcour);
		return "vacataires";
		
	}
	@RequestMapping(value="/deletevacataire")
	public String deleteCours(long vacataireid ,Model model){
		vacataireservice.deleteVacataire(vacataireid);
		lstvacataire = vacataireservice.allVacataire();
		model.addAttribute("lstvacataire", lstvacataire);
		lstcour = courservice.listOfNonAssignedCours();
		model.addAttribute("lstcour", lstcour);
		System.out.println("--------------->"+lstcour.size());
		return "vacataires";
		
	}

	@RequestMapping(value="/updatevacataire")
	public @ResponseBody Vacataire readvacataire( String vacataireid ){
		System.out.println(vacataireid);
		return vacataireservice.getVacataire(Long.parseLong(vacataireid));
		
	}
	
	@RequestMapping(value="updateinfosvacataire")
	public String updateVacataire(long idvacataire , Vacataire vacataire){
		System.out.println(vacataire.getNom() +" "+ vacataire.getPrenom() +" "+vacataire.getService()+" "+vacataire.getEmployeur()+" "+vacataire.getAdresse().getRue()+" "+vacataire.getAdresse().getVille()+" " );
		Vacataire et = vacataireservice.getVacataire(idvacataire);
		et.setNom(vacataire.getNom());
		et.setCours(vacataire.getCours());
		et.setService(vacataire.getService());
		et.setEmployeur(vacataire.getEmployeur());
		et.setPrenom(vacataire.getPrenom());
		et.getAdresse().setRue(vacataire.getAdresse().getRue());
		et.getAdresse().setVille(vacataire.getAdresse().getVille());
		vacataireservice.updateVacataire(et);
		
		return "vacataires";
	}
	
	@RequestMapping(value="affichercoursvacataire")
	public @ResponseBody String affichercoursvacataire(long vacataireid ){
		Vacataire et = vacataireservice.getVacataire(vacataireid);
		System.out.println("affciher cours vacataire");
		String html = "";
		for(int i=0 ;i<et.getCours().size();i++){
			html+= "<tr><td > "+et.getCours().get(i).getNom()+"</td> "
					+ "<td><a href=\"/delcouravacataire?idvacataire="+vacataireid+"&idc="+et.getCours().get(i).getId()+"\" ><img src=\"image/delete.png\" /></a>"
							+ "</tr>";
		}
		//							+ "<a href=\"#\" th:onclick=\"|students('"+et.getCours().get(i).getId()+"',' "+et.getCours().get(i).getNom()+"')|\"  data-toggle=\"modal\" data-target=\".lststudents\"><img src=\"image/student.png\" /></a></td>"

		System.out.println(html);
		return html;
	}
	@RequestMapping(value="/couravacataire" )
	public @ResponseBody String  updateCourvacataire(long idvacataire , String cour){
		System.out.println("debut de la methode courevacataire");
		System.out.println(cour);
		Vacataire et = vacataireservice.getVacataire(idvacataire);
		Cours cours = courservice.getCoursByNom(cour);
		cours.setEnseignant(ensservice.getEnseignant(idvacataire));
		courservice.updateCours(cours);
		
		System.out.println("fin de la methode courepermanat");
		return "success !!";
	}
	@RequestMapping(value="/delcouravacataire" )
	public  String  deleteCourvacataire(long idvacataire , long idc , Model model){
		//System.out.println(vacataire.getNom() +" "+ vacataire.getPrenom() +" "+vacataire.getSpecialite()+" "+vacataire.getAdresse().getRue()+" "+vacataire.getAdresse().getVille()+" " );
		System.out.println(idc);
		Cours cours = courservice.getCours(idc);
		cours.setEnseignant(null);
		courservice.updateCours(cours);
		System.out.println("fin");
		lstvacataire = vacataireservice.allVacataire();
		model.addAttribute("lstvacataire", lstvacataire);
		lstcour = courservice.listOfNonAssignedCours();
		model.addAttribute("lstcour", lstcour);
		return "vacataires";
	}
	
	

}
