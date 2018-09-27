package icda.taf.projet.projetCours.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import icda.taf.projet.projetCours.Entity.Cours;
import icda.taf.projet.projetCours.Entity.Etudiant;
import icda.taf.projet.projetCours.service.CoursServiceInteface;

@Controller
public class CoursController {

	@Autowired
	CoursServiceInteface courservice;
	List<Cours> lstcour ;
	Cours cour;
	
	@RequestMapping("addcour")
	public String addCours(String name, Model model){
		System.out.println(name);
		courservice.addCours(new Cours(name));
		lstcour = courservice.allCours();
		model.addAttribute("lstcour", lstcour);
		return "cours";
	}
	
	@RequestMapping("cours")
	public String listCours(Model model){
		lstcour = courservice.allCours();
		model.addAttribute("lstcour", lstcour);
		return "cours";
		
	}
	@RequestMapping("/getcours")
	public @ResponseBody String getlistCours(Model model){
		lstcour = courservice.allCours();
		 String html =" <div class=\"col-md-12\" id=\"updated\" >"
			 		+ "<label for=\"sel1\">Select un cours:</label>"
			 		+ "<select class=\"form-control\" id=\"sel1\">";
			 		
		String option ="";
		for (Cours cours : lstcour) {
			option+="<option value=\""+cours.getId()+"\"> "+cours.getNom()+"}</option>";
		}
		option+="</select> </div></div>";
		
		 html+=option;
		return html;
		
	}
	
	@RequestMapping(value="/deletecour")
	public String deleteCours(long courid ,Model model){
		courservice.deleteCours(courid);
		lstcour = courservice.allCours();
		model.addAttribute("lstcour", lstcour);
		return "cours";
		
	}
	

	@RequestMapping(value="/updatecour")
	public @ResponseBody  Cours readCours(long courid ){
		return courservice.getCours(courid);
		
	}
	@RequestMapping(value="updateinfos")
	public String updateCour(long idtoup , String name){
		System.out.println("id="+idtoup+"   nom="+name);
		cour = courservice.getCours(idtoup);
		cour.setNom(name);
		courservice.updateCours(cour);
		return "cours";
	}
	
	//listetudiant
	@RequestMapping(value="/listetudiant")
	public @ResponseBody String listetudiant(long courid){
		cour = courservice.getCours(courid);
		List<Etudiant> lst =cour.getEtudiants();
		String html="";
		for(Etudiant etudiant :lst){
			html+= "<tr>"
					+ "<td > "+etudiant.getNom()+"</td> "
					+ "<td> "+etudiant.getPrenom()+"</td>"
					+"<td> "+etudiant.getSpecialite()+"</td>"
					+ "</tr>";
		
		}
		System.out.println(html);
		return html;
	}
}
