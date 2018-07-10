package com.chorechart.springmvc;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.chorechart.dao.ChoresDAO;
import com.chorechart.model.Chores;
import com.chorechart.model.Kids;
import com.chorechart.model.Parents;
import com.chorechart.model.kid_chore;

@Controller
//@RequestMapping("chores")

public class ChoresController {
	
	 @Autowired
	 private ChoresDAO choresDAO;
	 
//	 @RequestMapping(value = "/ChildActivityFromParent", method = RequestMethod.GET)
//	  public ModelAndView showChildChore(@RequestParam("loginId")String kidsName,@ModelAttribute("parentObj")Parents parents,HttpServletRequest request, HttpServletResponse response,
//	  @ModelAttribute Chores newChore,BindingResult result) {
//		 //String kidsName= request.getParameter("name");
//		 List<kid_chore> kidsChoresList = new ArrayList<kid_chore>();
//		 kidsChoresList=choresDAO.displayCompletedChoresOfUser(kidsName);
//		 List<Chores> choreslist = new ArrayList<Chores>();
//		 choreslist=choresDAO.displayChores();
//		 Kids kidLogin = new Kids();
//		 kidLogin.setLoginId(kidsName);
//		 ModelAndView modelandview = new ModelAndView("ChildActivityFromParent");
//		 modelandview.addObject("parentFName",parents.getFirstName());
//		 modelandview.addObject("parentLName", parents.getLastName());
//		 modelandview.addObject("userName",parents.getUserName());
//		 modelandview.addObject("allChoresOfKids",kidsChoresList);
//		 modelandview.addObject("listOfChores",choreslist);
//		 modelandview.addObject("parentObj",parents);
//		 modelandview.addObject("loginId",kidsName);
//		 
//		 return modelandview;
//	  }
	 
	 @RequestMapping(value = "/kidsView",method=RequestMethod.POST)
	  public ModelAndView addKidActivity(HttpServletRequest request, HttpServletResponse response,
			  @ModelAttribute("kidObj") Kids kids,BindingResult result,ModelMap model) {
		 ModelAndView modelandview = new ModelAndView("kidsView");
		// List<Chores> choreslistAll = new ArrayList<Chores>();
		 //choreslistAll=choresDAO.displayChores();
		 List<kid_chore> choreslistkid = new ArrayList<kid_chore>();
		 choreslistkid=choresDAO.displayChoresOfUser(kids.getLoginId());
		 modelandview.addObject("listOfChores", choreslistkid);
		 return modelandview;
	  }
	 
	 @RequestMapping(value = "/addChoreProcess", method = RequestMethod.POST)
	  public ModelAndView addNewChore(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute Chores newChore,BindingResult result) {
		 choresDAO.addChore(newChore);
		 List<Chores> choreslist = new ArrayList<Chores>();
		 choreslist=choresDAO.displayChores();
		 ModelAndView modelandview = new ModelAndView("parentsView");
		 return modelandview;
	  }
	 
		@RequestMapping(value="/approve",method=RequestMethod.GET)
		 public ModelAndView approveChore(@RequestParam("loginId")String kidsName,@RequestParam("choreId")int choreId,@RequestParam("pointsAwarded")int pointsAwarded,HttpServletRequest request, HttpServletResponse response,
				  @ModelAttribute Chores newChore,BindingResult result) {
			 choresDAO.setApproveStatus(kidsName, choreId);
			 List<kid_chore> choreslist = new ArrayList<kid_chore>();
			 choreslist=choresDAO.displayCompletedChoresOfUser(kidsName);
			 ModelAndView modelandview = new ModelAndView("ChildActivityFromParent");
			 modelandview.addObject("allChoresOfKids",choreslist);
			 modelandview.addObject("loginId",kidsName);
			 return modelandview;
		}
		
		 @RequestMapping(value = "/addChore",method=RequestMethod.GET)
		  public ModelAndView showChore(@ModelAttribute("kidSelected")Kids kidsName,HttpServletRequest request, HttpServletResponse response,
				  @ModelAttribute Parents parents,BindingResult result) {
			 ModelAndView chore = new ModelAndView("addChore");
			 chore.addObject("chores",new Chores());
			 chore.addObject("parentObj",parents);
			 chore.addObject("kidSelected",kidsName);
			 List<Chores> choreslist = new ArrayList<Chores>();
			 choreslist=choresDAO.displayChores();
			 chore.addObject("listOfChores",choreslist);
			// System.out.println("chores object has :"+chore);
			 return chore;
		  }

}
