package com.satya.core.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.satya.core.bean.MenuVo;

public class StaticService {
	public static String[] USAProvinces={
	    "Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland",
	    "Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Carolina","North Dakota","Ohio",
	    "Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming"};
		
	public static  Map<String,List<MenuVo>> personmenu=new HashMap<String,List<MenuVo>>();
	public static void findMenu(){
		 List<MenuVo> healthProfile=new ArrayList<MenuVo>();
		 healthProfile.add(new MenuVo("Medication", "perMedication")) ;
		 healthProfile.add(new MenuVo("Lab Tets", "perLabTests")) ;
		 healthProfile.add(new MenuVo("Illness", "perIllness")) ;
		 healthProfile.add(new MenuVo("Encounter", "perEncounter")) ;
		 
		 
		 
		 List<MenuVo> home=new ArrayList<MenuVo>();
		 home.add(new MenuVo("Summary", "userhome"));
		 home.add(new MenuVo("Profile", "perProfile"));
		 home.add(new MenuVo("Logout", "logout"));
		 
		 List<MenuVo> search=new ArrayList<MenuVo>();
		 search.add(new MenuVo("Institution", "perInstSearch"));
		 search.add(new MenuVo("Provider", "perProvSearch"));
		 
		 List<MenuVo> appointment=new ArrayList<MenuVo>();
		 appointment.add(new MenuVo("Appointments", "perAppointments"));
		 appointment.add(new MenuVo("New Appointment", "perMakeAppointment"));
		 
		// String[] search={"Institution","Provider"};
	     //String[] appointment={"Appointments","New Appointment"};
	    // String[] home={"Summary","Profile","Logout"};
	     personmenu.put("Health Profile", healthProfile);
	     personmenu.put("Search",search);
	     personmenu.put("Appointment",appointment);
	     personmenu.put("Home",home);
		 }
}
