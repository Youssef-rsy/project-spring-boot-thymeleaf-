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
import icda.taf.projet.projetCours.Entity.Etudiant;
import icda.taf.projet.projetCours.service.CoursServiceInteface;
import icda.taf.projet.projetCours.service.EtudiantServiceInterfce;

@Controller
public class EtudiantsController {
	
	@Autowired
	private EtudiantServiceInterfce etudiantservice;
	private List<Etudiant> lstetudiant;
	
	
	@Autowired
	CoursServiceInteface courservice;
	List<Cours> lstcour ;
	Cours cour;
	
	
	@RequestMapping("/addetudiant")
	public String addCours(Etudiant etudiant, Model model){
		System.out.println(etudiant.getNom() +" "+ etudiant.getPrenom() +" "+etudiant.getSpecialite()+" "+etudiant.getAdresse().getRue()+" "+etudiant.getAdresse().getVille()+" " );
		etudiantservice.addEtudiant(etudiant);
		lstcour = courservice.allCours();
		model.addAttribute("lstcour", lstcour);
		lstetudiant = etudiantservice.allEtudiant();
		model.addAttribute("lstetudiant", lstetudiant);
		return "etudiants";
	}
	
	@RequestMapping("etudiants")
	public String listCours(Model model){
		lstetudiant = etudiantservice.allEtudiant();
		model.addAttribute("lstetudiant", lstetudiant);
		lstcour = courservice.allCours();
		model.addAttribute("lstcour", lstcour);
		return "etudiants";
		
	}
	
	@RequestMapping(value="/deleteetudiant")
	public String deleteCours(long etudiantid ,Model model){
		etudiantservice.deleteEtudiant(etudiantid);
		lstetudiant = etudiantservice.allEtudiant();
		model.addAttribute("lstetudiant", lstetudiant);
		lstcour = courservice.allCours();
		model.addAttribute("lstcour", lstcour);
		return "etudiants";
		
	}
	@RequestMapping(value="/updateEtudiant")
	public @ResponseBody Etudiant readEtudiant( String etudiantid ){
		System.out.println(etudiantid);
		return etudiantservice.getEtudiant(Long.parseLong(etudiantid));
		
	}
	
	@RequestMapping(value="updateinfosetudiant")
	public String updateetudiant(long idetu , Etudiant etudiant){
		System.out.println(etudiant.getNom() +" "+ etudiant.getPrenom() +" "+etudiant.getSpecialite()+" "+etudiant.getAdresse().getRue()+" "+etudiant.getAdresse().getVille()+" " );
		Etudiant et = etudiantservice.getEtudiant(idetu);
		et.setNom(etudiant.getNom());
		et.setCours(etudiant.getCours());
		et.setSpecialite(etudiant.getSpecialite());
		et.setPrenom(etudiant.getPrenom());
		et.getAdresse().setRue(etudiant.getAdresse().getRue());
		et.getAdresse().setVille(etudiant.getAdresse().getVille());
		etudiantservice.updateEtudiant(et);
		
		return "etudiants";
	}
	@RequestMapping(value="affichercoursetudiant")
	public @ResponseBody String affichercoursetudiant(long etudiantid ){
		Etudiant et = etudiantservice.getEtudiant(etudiantid);
		String html = "";
		for(int i=0 ;i<et.getCours().size();i++){
			html+= "<tr><td > "+et.getCours().get(i).getNom()+"</td> "
					+ "<td><a href=\"/delcouraetud?idetu="+etudiantid+"&idc="+et.getCours().get(i).getId()+"\" ><img src=\"image/delete.png\" /></a></td></tr>";
		
		}
		System.out.println(html);
		return html;
	}
	
	@RequestMapping(value="/couraetud" )
	public @ResponseBody String  updateCouretudiant(long idetu , String cour){
		//System.out.println(etudiant.getNom() +" "+ etudiant.getPrenom() +" "+etudiant.getSpecialite()+" "+etudiant.getAdresse().getRue()+" "+etudiant.getAdresse().getVille()+" " );
		System.out.println(cour);
		Etudiant et = etudiantservice.getEtudiant(idetu);
		int nbr = 0;
		for(int i=0 ;i<et.getCours().size();i++){
			System.out.println(et.getCours().get(i).getNom() != cour);
			if(et.getCours().get(i).getNom() != cour){
				nbr++;
			}
		}
		if(nbr==0){
			et.getCours().add(courservice.getCoursByNom(cour));
		}
		etudiantservice.updateEtudiant(et);
		return "success !!";
	}
	
	@RequestMapping(value="/delcouraetud" )
	public  String  deleteCouretudiant(long idetu , long idc){
		//System.out.println(etudiant.getNom() +" "+ etudiant.getPrenom() +" "+etudiant.getSpecialite()+" "+etudiant.getAdresse().getRue()+" "+etudiant.getAdresse().getVille()+" " );
		System.out.println(idc);
		lstcour.clear();
		Etudiant et = etudiantservice.getEtudiant(idetu);
		System.out.println("1");
		for(int i=0 ;i<et.getCours().size();i++){
			System.out.println(et.getCours().get(i).getId() != idc);
			if(et.getCours().get(i).getId() != idc ){
				lstcour.add(et.getCours().get(i));
			}
		}
		System.out.println("2");
		et.getCours().clear();
		System.out.println("lenth ="+et.getCours().size());
		et.getCours().addAll(lstcour);
		System.out.println("lenth ="+et.getCours().size());
		etudiantservice.updateEtudiant(et);
		System.out.println("fin");
		return "etudiants";
	}
	
	
	
	

}
