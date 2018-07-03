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
import com.chorechart.dao.KidsDAO;
import com.chorechart.model.Chores;
import com.chorechart.model.Kids;
import com.chorechart.model.Parents;
import com.chorechart.model.kid_chore;

@Controller
@RequestMapping("kids")
public class KidsController {
	 @Autowired
	 private KidsDAO kidsDAO;
	 
	 @Autowired
	 private ChoresDAO choresDAO;
	 
	 @RequestMapping(value = "/loginChilds",method=RequestMethod.GET)
	  public ModelAndView  showLoginChilds() {
		 ModelAndView kid = new ModelAndView("loginChilds");
		 kid.addObject("kids",new Kids());
		 return kid;
		 
	  }
	 
	 @RequestMapping(value = "/findKidUser",method=RequestMethod.POST)
	  public ModelAndView findKidUser(HttpServletRequest request, HttpServletResponse response,
			  @ModelAttribute Kids kids,BindingResult result,ModelMap model) {
		 
		 //List<kid_chore> kidUser = choresDAO.displayChoresOfUser(kids.getLoginId(),kids.getPassword());
		 Kids userKid = new Kids();
		 userKid=kidsDAO.returnUser(kids.getLoginId(), kids.getPassword());
		 ModelAndView modelandview = new ModelAndView("kidsView");
		 List<kid_chore> choreslistAll = new ArrayList<kid_chore>();
		 choreslistAll=choresDAO.displayAssignedChoresOfUser(kids.getLoginId());
		// System.out.println("In login controller"+choreslistAll);
		 modelandview.addObject("listOfAllChores", choreslistAll);
		 modelandview.addObject("kidObj",userKid);
		 return modelandview;
	  }
	 
	 @RequestMapping(value="/addChoreKidProcess",method=RequestMethod.POST)
	 public ModelAndView assignChoretoKid(@ModelAttribute("parentObj")Parents parents,@ModelAttribute("kidSelected")Kids kidSelected,HttpServletRequest request, HttpServletResponse response,
			  @ModelAttribute Chores newChore,BindingResult result) {
				
		 choresDAO.assignChoreToKid(kidSelected.getLoginId(),newChore.getChoreId(),newChore.getChorePoints());
		 List<kid_chore> choreslist = new ArrayList<kid_chore>();
		 choreslist=choresDAO.displayCompletedChoresOfUser(kidSelected.getLoginId());
		 ModelAndView modelandview = new ModelAndView("ChildActivityFromParent");
		 modelandview.addObject("parentFName",parents.getFirstName());
		 modelandview.addObject("parentLName", parents.getLastName());
		 modelandview.addObject("userName",parents.getUserName());
		 modelandview.addObject("allChoresOfKids",choreslist);
		 modelandview.addObject("parentObj",parents);
		 modelandview.addObject("loginId",kidSelected.getLoginId());
		 return modelandview;
	}
	 
	 @RequestMapping(value="/complete",method=RequestMethod.GET)
	 public ModelAndView completeChore(@RequestParam("loginId")String kidsName,@RequestParam("choreId")int choreId,HttpServletRequest request, HttpServletResponse response,
			  @ModelAttribute Chores newChore,BindingResult result) {
				
		 choresDAO.setCompleteStatus(kidsName, choreId);
		 List<kid_chore> choreslist = new ArrayList<kid_chore>();
		 choreslist=choresDAO.displayAssignedChoresOfUser(kidsName);
		 ModelAndView modelandview = new ModelAndView("kidsView");
		 modelandview.addObject("listOfAllChores",choreslist);
		 modelandview.addObject("loginId",kidsName);
		 return modelandview;
	}

}
