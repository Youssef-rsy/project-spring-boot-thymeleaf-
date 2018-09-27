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
import icda.taf.projet.projetCours.Entity.Permanent;
import icda.taf.projet.projetCours.service.CoursServiceInteface;
import icda.taf.projet.projetCours.service.EnseignantServiceInterface;
import icda.taf.projet.projetCours.service.PermantServiceInterface;

@Controller
public class PermanentController {
	
	@Autowired
	private PermantServiceInterface permanentservice;
	private List<Permanent> lstpermanent;
	
	
	@Autowired
	private CoursServiceInteface courservice;
	private List<Cours> lstcour ;
	private Cours cour;
	
	@Autowired
	private EnseignantServiceInterface ensservice;
	private Enseignant ens;
	
	@RequestMapping("/addpermanent")
	public String addCours(Permanent permanent, Model model){
		System.out.println(permanent.getNom() +" "+ permanent.getPrenom() +" "+permanent.getService()+" "+permanent.getGrade()+" "+permanent.getAdresse().getRue()+" "+permanent.getAdresse().getVille()+" " );
		permanentservice.addPermanent(permanent);
		lstcour = courservice.listOfNonAssignedCours();
		model.addAttribute("lstcour", lstcour);
		System.out.println("--------------->"+lstcour.size());
		lstpermanent = permanentservice.allPermanent();
		model.addAttribute("lstpermanent", lstpermanent);
		return "permanats";
	}
	
	@RequestMapping("permanents")
	public String listCours(Model model){
		lstpermanent = permanentservice.allPermanent();
		model.addAttribute("lstpermanent", lstpermanent);
		lstcour = courservice.listOfNonAssignedCours();
		model.addAttribute("lstcour", lstcour);
		return "permanats";
		
	}
	@RequestMapping(value="/deletepermanent")
	public String deleteCours(long permanentid ,Model model){
		permanentservice.deletePermanent(permanentid);
		lstpermanent = permanentservice.allPermanent();
		model.addAttribute("lstpermanent", lstpermanent);
		lstcour = courservice.listOfNonAssignedCours();
		model.addAttribute("lstcour", lstcour);
		System.out.println("--------------->"+lstcour.size());
		return "permanats";
		
	}

	@RequestMapping(value="/updatepermanent")
	public @ResponseBody Permanent readPermanent( String permanentid ){
		System.out.println(permanentid);
		return permanentservice.getPermanent(Long.parseLong(permanentid));
		
	}
	
	@RequestMapping(value="updateinfospermanent")
	public String updatePermanent(long idpermanent , Permanent permanent){
		System.out.println(permanent.getNom() +" "+ permanent.getPrenom() +" "+permanent.getService()+" "+permanent.getGrade()+" "+permanent.getAdresse().getRue()+" "+permanent.getAdresse().getVille()+" " );
		Permanent et = permanentservice.getPermanent(idpermanent);
		et.setNom(permanent.getNom());
		et.setCours(permanent.getCours());
		et.setService(permanent.getService());
		et.setGrade(permanent.getGrade());
		et.setPrenom(permanent.getPrenom());
		et.getAdresse().setRue(permanent.getAdresse().getRue());
		et.getAdresse().setVille(permanent.getAdresse().getVille());
		permanentservice.updatePermanent(et);
		
		return "permanats";
	}
	
	@RequestMapping(value="affichercourspermanent")
	public @ResponseBody String affichercoursPermanent(long permanentid ){
		Permanent et = permanentservice.getPermanent(permanentid);
		System.out.println("affciher cours permanent");
		String html = "";
		for(int i=0 ;i<et.getCours().size();i++){
			html+= "<tr><td > "+et.getCours().get(i).getNom()+"</td> "
					+ "<td><a href=\"/delcourapermanent?idpermanent="+permanentid+"&idc="+et.getCours().get(i).getId()+"\" ><img src=\"image/delete.png\" /></a>"
							+ "</tr>";
		}
		//							+ "<a href=\"#\" th:onclick=\"|students('"+et.getCours().get(i).getId()+"',' "+et.getCours().get(i).getNom()+"')|\"  data-toggle=\"modal\" data-target=\".lststudents\"><img src=\"image/student.png\" /></a></td>"

		System.out.println(html);
		return html;
	}
	@RequestMapping(value="/courapermanent" )
	public @ResponseBody String  updateCourPermanent(long idpermanent , String cour){
		System.out.println("debut de la methode courepermanent");
		System.out.println(cour);
		Permanent et = permanentservice.getPermanent(idpermanent);
		Cours cours = courservice.getCoursByNom(cour);
		cours.setEnseignant(ensservice.getEnseignant(idpermanent));
		courservice.updateCours(cours);
		
		System.out.println("fin de la methode courepermanat");
		return "success !!";
	}
	@RequestMapping(value="/delcourapermanent" )
	public  String  deleteCourPermanent(long idpermanent , long idc , Model model){
		//System.out.println(Permanent.getNom() +" "+ Permanent.getPrenom() +" "+Permanent.getSpecialite()+" "+Permanent.getAdresse().getRue()+" "+Permanent.getAdresse().getVille()+" " );
		System.out.println(idc);
		Cours cours = courservice.getCours(idc);
		cours.setEnseignant(null);
		courservice.updateCours(cours);
		System.out.println("fin");
		lstpermanent = permanentservice.allPermanent();
		model.addAttribute("lstpermanent", lstpermanent);
		lstcour = courservice.listOfNonAssignedCours();
		model.addAttribute("lstcour", lstcour);
		return "permanats";
	}
	
	

}
