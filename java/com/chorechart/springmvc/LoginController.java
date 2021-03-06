package com.chorechart.springmvc;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import org.springframework.web.servlet.ModelAndView;

import com.chorechart.dao.ChoresDAO;
import com.chorechart.dao.KidsDAO;
import com.chorechart.dao.ParentsDAO;
import com.chorechart.dao.RegisterDAO;
import com.chorechart.model.Chores;
import com.chorechart.model.Kids;
import com.chorechart.model.Parents;
import com.chorechart.model.Register;
import com.chorechart.model.kid_chore;
import com.chorechart.validation.FormValidator;


@Controller
@SessionAttributes("parentObj")

public class LoginController {

	
	 @Autowired
	  private RegisterDAO registerDAO;
	 
	 @Autowired
	 private ParentsDAO parentsDAO; 
	 
	 @Autowired
	 private KidsDAO kidsDAO;
	 
	 @Autowired
	 private ChoresDAO choresDAO;
	 
	
	 
	 //@Autowired
	// private FormValidator formValidator;
	 
//	 @InitBinder
//	 protected void initBinder(WebDataBinder binder) {
//	      binder.addValidators(formValidator);
//	 }
	  
	 @RequestMapping(value = "/index",method=RequestMethod.GET)
	  public void showIndex() {
	  }
	
	 
	 @RequestMapping(value = "/loginParents",method=RequestMethod.GET)
	  public ModelAndView showLoginParents() {
		 ModelAndView parent = new ModelAndView("loginParents");
		 parent.addObject("parents",new Parents());
		 return parent;
 	  }
	 
	 
//	 @RequestMapping(value = "/loginChilds",method=RequestMethod.GET)
//	  public ModelAndView  showLoginChilds() {
//		 ModelAndView kid = new ModelAndView("loginChilds");
//		 kid.addObject("kids",new Kids());
//		 return kid;
//		 
//	  }

	 @RequestMapping(value = "/register",method=RequestMethod.GET)
	  public ModelAndView showRegister() {
	  ModelAndView mav = new ModelAndView("register");
	  mav.addObject("register", new Register());
	  return mav;
	  }

	

	 @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	  public String addUser(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute Register register,BindingResult result) {
		//Validation code
		  //  formValidator.validate(register, result);
		     
		    //Check validation errors
		    if (result.hasErrors()) {
		        return "register";
		    }
	  registerDAO.insertUser(register);
	  return "redirect:index.jsp";
	  }
	 
	 @RequestMapping(value = "/addKid",method=RequestMethod.GET)
	  public ModelAndView showKid(HttpServletRequest request, HttpServletResponse response,
			  @ModelAttribute Parents parents,BindingResult result) {
		 ModelAndView kid = new ModelAndView("addKid");
		 kid.addObject("kids",new Kids());
		 kid.addObject("parentObj",parents);
		 return kid;
		 
	  }
	 
	 @RequestMapping(value = "/addKidProcess", method = RequestMethod.POST)
	  public ModelAndView addKidUser(@ModelAttribute("parentObj")Parents parents,HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute Kids kids,BindingResult result) {
		 kidsDAO.addKid(kids);
		 List<Kids> list = new ArrayList<Kids>();
		 list=kidsDAO.returnListKids(parents.getUserName());
		 List<Chores> choreslist = new ArrayList<Chores>();
		 choreslist=choresDAO.displayChores();
		 ModelAndView modelandview = new ModelAndView("parentsView");
		 modelandview.addObject("parentFName",parents.getFirstName());
		 modelandview.addObject("parentLName", parents.getLastName());
		 modelandview.addObject("userName",parents.getUserName());
		 modelandview.addObject("listOfKids",list);
		 modelandview.addObject("listOfChores",choreslist);
		 modelandview.addObject("parentObj",parents);
		 return modelandview;
	  }
	 
//	
	 
	 
	 @RequestMapping(value = "/findParentUser",method=RequestMethod.POST)
	  public ModelAndView findUser(HttpServletRequest request, HttpServletResponse response,
			  @ModelAttribute Parents parents,BindingResult result,ModelMap model) {
		 Parents parentUser = parentsDAO.showParents(parents.getUserName(), parents.getPassword());
		 List<Chores> choreslist = new ArrayList<Chores>();
		 choreslist=choresDAO.displayChores();
		 
		 parentsDAO.showAllKids(parents.getUserName());
		 List<Kids> list = new ArrayList<Kids>();
		 list=parentsDAO.showAllKids(parents.getUserName());
		// return "redirect:parentsView.jsp";
		 model.addAttribute("parentFName",parentUser.getFirstName());
		 model.addAttribute("parentLName", parentUser.getLastName());
		 model.addAttribute("userName",parents.getUserName());
		 model.addAttribute("listOfKids", list);
		 ModelAndView modelandview = new ModelAndView("parentsView");
		 modelandview.addObject("listOfKids",list);
		 modelandview.addObject("listOfChores", choreslist);
		 modelandview.addObject("parentObj",parentUser);
		 //return new ModelAndView("parentsView","parents",parentUser);
		 return modelandview;
	  }
	 
//	
//	 
	 @RequestMapping(value = "/ChildActivityFromParent", method = RequestMethod.GET)
	  public ModelAndView showChildChore(@RequestParam("loginId")String kidsName,@ModelAttribute("parentObj")Parents parents,HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute Chores newChore,BindingResult result) {
		 //String kidsName= request.getParameter("name");
		 List<kid_chore> kidsChoresList = new ArrayList<kid_chore>();
		 kidsChoresList=choresDAO.displayCompletedChoresOfUser(kidsName);
		 List<Chores> choreslist = new ArrayList<Chores>();
		 choreslist=choresDAO.displayChores();
		 Kids kidSelected = new Kids();
		 kidSelected.setLoginId(kidsName);
		 ModelAndView modelandview = new ModelAndView("ChildActivityFromParent");
		 modelandview.addObject("parentFName",parents.getFirstName());
		 modelandview.addObject("parentLName", parents.getLastName());
		 modelandview.addObject("userName",parents.getUserName());
		 modelandview.addObject("allChoresOfKids",kidsChoresList);
		 modelandview.addObject("listOfChores",choreslist);
		 modelandview.addObject("parentObj",parents);
		 modelandview.addObject("kidSelected",kidSelected);
		 
		 return modelandview;
	  }
	 //ChildActivityFromParent
	 @RequestMapping(value = "/parentsView", method = RequestMethod.GET)
	  public ModelAndView showParentsView(@RequestParam("loginId")String kidsName,@ModelAttribute("parentObj")Parents parents,HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute Chores newChore,BindingResult result) {
		 //String kidsName= request.getParameter("name");
		 List<kid_chore> kidsChoresList = new ArrayList<kid_chore>();
		 kidsChoresList=choresDAO.displayCompletedChoresOfUser(kidsName);
		 List<Chores> choreslist = new ArrayList<Chores>();
		 choreslist=choresDAO.displayChores();
		 Kids kidSelected = new Kids();
		 kidSelected.setLoginId(kidsName);
		 ModelAndView modelandview = new ModelAndView("ChildActivityFromParent");
		 modelandview.addObject("parentFName",parents.getFirstName());
		 modelandview.addObject("parentLName", parents.getLastName());
		 modelandview.addObject("userName",parents.getUserName());
		 modelandview.addObject("allChoresOfKids",kidsChoresList);
		 modelandview.addObject("listOfChores",choreslist);
		 modelandview.addObject("parentObj",parents);
		 modelandview.addObject("kidSelected",kidSelected);
		 
		 return modelandview;
	  }
	 

	 @ModelAttribute("relations")
	 public List<String> getRelations(){
		 List<String> relations = new ArrayList<String>();
		 relations.add("Mother");
		 relations.add("Father");
		 relations.add("GrandParent");
		 relations.add("OlderSibling");
		 return relations;
	 
	 }
}
