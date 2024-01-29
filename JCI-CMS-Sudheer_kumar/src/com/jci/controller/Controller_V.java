package com.jci.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.google.gson.Gson;
import com.jci.model.EntryofSaleModel;
import com.jci.model.UserRegistrationModel;
import com.jci.model.EntryofpcsoModel;
import com.jci.model.JciDIHoModel;
import com.jci.model.Jciclaim_NominationModel;
import com.jci.model.JcicontractModel;
import com.jci.model.MillAcceptanceModel;
import com.jci.model.PcsoDateModel;
import com.jci.model.RoDetailsModel;
import com.jci.service.RoDetailsService;
import com.jci.service_phase2.JciContractService;
import com.jci.service_phase2.JciDIHoService;
import com.jci.service_phase2.MillAccptanceService;
import com.jci.service_phase2.MillService;
import com.jci.service_phase2.NominalOfficialService;
import com.jci.service_phase2.PcsoentryService;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

@Controller
public class Controller_V {

	@Autowired
	PcsoentryService pcsoentryservice;

	@Autowired
	JciDIHoService jciDIHoService;

	@Autowired
	RoDetailsService roDetailsservice;
	
	@Autowired
    NominalOfficialService nominalOfficialService;
	
	
	
	@Autowired
	MillService millService;
	
	@Autowired
	JciContractService jciContractService;
	
//	@Autowired
//	EntryofTdsService entryofTdsService;

//	@Autowired
//	SessionFactory sessionFactory;
//	protected Session currentSession(){
//		return sessionFactory.getCurrentSession();
//	}

	@RequestMapping("entryofpcso")
	public ModelAndView EntryofpcsoModel(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("entryofpcso");
		final List<EntryofpcsoModel> allentryofpcsolist = (List<EntryofpcsoModel>) this.pcsoentryservice.getAlldata();
		mv.addObject("entryofpcsolist", (Object) allentryofpcsolist);
		if (username == null) {
			mv = new ModelAndView("index");
		}
		return mv;
	}

	@RequestMapping("entryofpcsosave")
	public ModelAndView saveUserMid(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView("entryofpcsosave");
		String username = (String) request.getSession().getAttribute("usrname");
		try {
			List<EntryofpcsoModel> ll = new ArrayList<>();
			int c = 0;
			int count = Integer.valueOf(request.getParameter("count"));
			String referenceno = request.getParameter("referenceno");
			String referencedate = request.getParameter("referencedate");
			String pcsodate = request.getParameter("pcsodate");
			for (int i = 0; i < count; i++) {
				EntryofpcsoModel entryofpcso = new EntryofpcsoModel();
				String millcode = request.getParameter("millcode" + c);
				String millname = request.getParameter("millname" + c);
				String tallocation = request.getParameter("totalallocation" + c);
				entryofpcso.setReference_no(referenceno);
				entryofpcso.setReference_date(referencedate);
				entryofpcso.setPcso_date(pcsodate);
				if (tallocation != "" && tallocation != null) {
					entryofpcso.setMill_code(millcode);
					entryofpcso.setMill_name(millname);
					entryofpcso.setTotal_allocation(tallocation);
					ll.add(entryofpcso);
				}
				c++;
			}
			mv.addObject("entryofpcso", (Object) ll);
			mv.addObject("referencedate", (Object) referencedate);
			mv.addObject("pcsodate", (Object) pcsodate);

		} catch (Exception e) {
			System.out.println(e);
		}
		if (username == null) {
			mv = new ModelAndView("index");
		}
		return mv;
	}

	@RequestMapping("saveentryofpcsodata")
	public ModelAndView entryofpcsosave(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		String username = (String) request.getSession().getAttribute("usrname");
		try {

			int c = 0;
			int count = Integer.valueOf(request.getParameter("count"));
			Date date = new Date();
			String referenceno = request.getParameter("refno");
			String referencedate = request.getParameter("refdate");
			String pcsodate = request.getParameter("pcsodate");
			double sumoftotalallocation = Double.parseDouble(request.getParameter("sumoftotalallocation"));
			for (int i = 0; i < count; i++) {
				EntryofpcsoModel entryofpcso = new EntryofpcsoModel();
				String millcode = request.getParameter("millcode" + c);
				String millname = request.getParameter("millname" + c);
				String tallocation = request.getParameter("totalallocation" + c);
				entryofpcso.setReference_no(referenceno);
				SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");

				// Date refdate = formatter1.parse(referencedate);
				entryofpcso.setReference_date(referencedate);
				// Date pcsodt = formatter1.parse(pcsodate);
				entryofpcso.setPcso_date(pcsodate);
				String createddate = formatter1.format(date);
				entryofpcso.setCreated_date(createddate);
				entryofpcso.setMill_code(millcode);
				entryofpcso.setMill_name(millname);
				entryofpcso.setTotal_allocation(tallocation);
				entryofpcso.setMillwise_contract(0);
				entryofpcso.setPcsowise_contract(0);
				entryofpcso.setSumof_totalallocation(sumoftotalallocation);
				pcsoentryservice.create(entryofpcso);
				c++;
			}
			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-success\"><b>Success !</b> Record created successfully.</div>\r\n" + "");

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		if (username == null) {
			return new ModelAndView("index");
		}
		return new ModelAndView(new RedirectView("entryofpcso.obj"));
	}

	@RequestMapping("pcsolist")
	public ModelAndView pcsolist(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("PCSO_List");
		List<Date> pcso = pcsoentryservice.getAll();
		mv.addObject("pcsolist", pcso);
		if (username == null) {
			mv = new ModelAndView("index");
		}
		return mv;
	}

	@RequestMapping("contractgenerationPCSOWise")
	public ModelAndView contractgeneration(HttpServletRequest req) {
		String username = (String) req.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("contractgeneration");
		List<Date> pcso = pcsoentryservice.getAll();
		mv.addObject("pcso", (Object) pcso);
		if (username == null) {
			mv = new ModelAndView("index");
		}
		return mv;
	}

	@ResponseBody
	@RequestMapping(value = "pcsoDates", method = RequestMethod.GET)
	public List<Date> pcsoDates(final HttpServletRequest request) {
		List<Date> pcso = pcsoentryservice.getAll();
		return pcso;
	}

	@ResponseBody
	@RequestMapping(value = "pcso_details", method = RequestMethod.GET)
	public String pcso_details(final HttpServletRequest request) {

		String outerArray = request.getParameter("pcso1");
		outerArray = outerArray.replaceAll("/", "'").replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\"", "'");
		final String[] bpArr = outerArray.split(",");
		final List<String> list = Arrays.asList(bpArr);
		List<PcsoDateModel> pcso = pcsoentryservice.pcso_details(outerArray);
		Gson gson = new Gson();
		return gson.toJson(pcso);
	}

	// Starting Making Controller From here on 12/09/2023

	/*
	 * @RequestMapping("/viewmillaccept") public String MillAccept() { return
	 * "MillAcceptance"; }
	 */
	/*
	 * @RequestMapping("/dispatch") public String Dispatch() { return
	 * "DispatchInstruction"; }
	 */



	@RequestMapping("dispatch")
	public ModelAndView Dispatch(HttpServletRequest request) {
		
		
		
		String username = (String) request.getSession().getAttribute("usrname");
		int regionCode = Integer.parseInt((String) request.getSession().getAttribute("region"));
		ModelAndView mv = new ModelAndView("DispatchInstruction");
		mv.addObject("regionCode", regionCode);
		int t = jciDIHoService.Countrow();
		int r = jciDIHoService.CountFinancial();
		mv.addObject("fctotal", r);
		List<String> fcrefs = jciDIHoService.totalFCRef();
		mv.addObject("f", fcrefs);
		mv.addObject("total", t);
		mv.addObject("fctotal", r);
		List<String> cno = jciDIHoService.ContractNo();
		mv.addObject("cno", cno);
		// Fetching Allowed Qty.
		List<String> allowqty = jciDIHoService.AllowedQty();
		mv.addObject("allowqty", allowqty);
		// Fetching Data from Reginal Office
		List<String> roname = jciDIHoService.RegionalOffice();
		mv.addObject("roname", roname);

		// Fetching Data of DPC Based On Rocode

		List<String> DPC = jciDIHoService.DPC();
		mv.addObject("DPC", DPC);
		
		
		// Fetching Data of Contract No from JciContract Table
		
		List<String> Contract_qty = jciDIHoService.FetchContract_qty();
		mv.addObject("Contract_qty", Contract_qty);

		// Fetching Data From Regional Office of two Column,
		List<Object> rocodeAndRoName = jciDIHoService.MultiRegionoffice();
		
		// saving current date
		
		   SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	        Date currentDate = new Date();



	        // Format the current date and time
	        String formattedDate = sdf.format(currentDate);
	        System.out.println(formattedDate);
	        mv.addObject("currentDate", formattedDate);

		mv.addObject("rcrn", rocodeAndRoName);
		final List<RoDetailsModel> RegionList = (List<RoDetailsModel>) this.roDetailsservice.getAll();
		System.out.println();
		System.out.println();
		System.out.println(RegionList);
		System.out.println();
		System.out.println();
		System.out.println();
		
		mv.addObject("RegionList", (Object) RegionList);
		if (username == null) {
			mv = new ModelAndView("index");
		}
		return mv;
	}

	// for AJAX CAll
	@ResponseBody
	@RequestMapping(value = "findroname", method = RequestMethod.GET)
	public String ROname(@RequestParam("id") String id) {
		Gson gson = new Gson();
		List<String> result = new ArrayList<>();
		result = jciDIHoService.findroname(id);
		return gson.toJson(result);
	}



	@RequestMapping("dispatchHoInstruction")
	public ModelAndView saveHo(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		String username = (String) request.getSession().getAttribute("usrname");

		System.out.println("--------------Hello-----------");
		System.out.println("--------------Hello-----------");
		System.out.println("--------------Hello-----------");
		System.out.println("--------------Hello-----------");
		String[] dpc = request.getParameterValues("dpc");
		System.out.println();
		System.out.println();
		String dpcs = "";
		for (String s : dpc) {
			System.out.println(s);
			dpcs = dpcs + s + ",";

		}

		
		
		   String ContractNo = request.getParameter("ContractNo");  
		   String ContractDate = request.getParameter("ContractDate");    
		   String Cropyear= request.getParameter("Cropyear"); 
		   String FCRefNo = request.getParameter("FCRefNo");  String ContractedQty =
		  request.getParameter("ContractedQty");  
		   double myDouble =Double.parseDouble(ContractedQty);  
		   String AllowedQty = request.getParameter("AllowedQty");  
		   String RegionalOffice = request.getParameter("region"); 
		  System.out.println("AllowedQty===="+AllowedQty); 
		  System.out.println("RegionalOffice===="+RegionalOffice);  
		  String LastdateofShipment = request.getParameter("LastdateofShipment"); 
		  String DINo = request.getParameter("DINo");  
		  String DIDate = request.getParameter("DIDate"); 
		  String JuteVariety = request.getParameter("JuteVariety");  
		  String Remarks = request.getParameter("Remarks");  
		  
		 double grade1 =(Double) Double.parseDouble(request.getParameter("grade1"));  
		 double grade2 =(Double) Double.parseDouble(request.getParameter("grade2"));  
		 double grade3 =(Double) Double.parseDouble(request.getParameter("grade3"));  
		 double grade4 =(Double) Double.parseDouble(request.getParameter("grade4"));  
		 double grade5 =(Double) Double.parseDouble(request.getParameter("grade5"));  
		 double grade6 =(Double) Double.parseDouble(request.getParameter("grade6"));  
		 double grade7 =(Double) Double.parseDouble(request.getParameter("grade7"));  
		 double grade8 =(Double) Double.parseDouble(request.getParameter("grade8"));  
		  

		   
		  JciDIHoModel jciDIHoModel = new JciDIHoModel(); 
		  jciDIHoModel.setContract_No(ContractNo);
		  // date Formatting in Indian Format
		  
		  SimpleDateFormat  inputDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		  SimpleDateFormat outDataFormat=new SimpleDateFormat("dd-MM-yyyy");
		  //String parsedDateString = null;
		 // String parsedDateString1 = null;  
		  //String  parsedDateString2 = null;  
		  String parsedDateString3=null;
		  
		  try {  
			    
			  //Convert the Date to a formatted string
		    Date date1 = inputDateFormat.parse(LastdateofShipment); 
//		  parsedDateString1 = outDataFormat.format(date1);   
		 
		  //Date date2 = inputDateFormat.parse(DIDate); 
		 // parsedDateString2 = outDataFormat.format(date2); 

		  parsedDateString3 = outDataFormat.format(new Date());   
		  
		  
		  
		   
		  } 
		  catch(ParseException e) {  
			  //Handle the ParseException 
		  System.err.println("Error parsing date: " + e.getMessage()); 
		  e.printStackTrace(); 
		  }  
		  jciDIHoModel.setContract_Date(ContractDate);  
		  jciDIHoModel.setCrop_year(Cropyear);  
		  jciDIHoModel.setFC_Ref_No(FCRefNo);
		    double myDouble1 = Double.parseDouble(ContractedQty); 
		  jciDIHoModel.setContracted_Qty(myDouble1); 
		  double myDouble2 = Double.parseDouble(AllowedQty);  
		  jciDIHoModel.setAllowed_qty(myDouble2);
		   jciDIHoModel.setRegional_office(RegionalOffice); 
		   jciDIHoModel.setDPC(dpcs);
		  jciDIHoModel.setLast_date_of_Shipment(LastdateofShipment);  
		  jciDIHoModel.setDI_no(DINo);  
		  jciDIHoModel.setDI_Date(DIDate);
		
		   
		  jciDIHoModel.setJute_variety(JuteVariety); 
		  jciDIHoModel.setRemarks(Remarks); 
		  jciDIHoModel.setCreated_by("7");  
		  
		  Date date= new Date();
		  System.out.println(date);  
		  
		 // jciDIHoModel.setCreation_date(new Timestamp(0)); 
		  
		  
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        Date currentDate = new Date();

	        // Format the current date and time
	        String formattedDate = sdf.format(currentDate);
		  
		  
		  jciDIHoModel.setCreation_date(formattedDate);  
		  jciDIHoModel.setGr1_qty(grade1);  
		  jciDIHoModel.setGr2_qty(grade2); 
		  jciDIHoModel.setGr3_qty(grade3); 
		  jciDIHoModel.setGr4_qty(grade4); 
		  jciDIHoModel.setGr5_qty(grade5);  
		  jciDIHoModel.setGr6_qty(grade6); 
		  jciDIHoModel.setGr7_qty(grade7);  
		  jciDIHoModel.setGr8_qty(grade8);
		 jciDIHoService.create(jciDIHoModel);
		
		 redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n");

		return new ModelAndView(new RedirectView("jcilist.obj"));
		
	}
	// Fetching All Data from

	@RequestMapping("jcilist")
	public String jciHoList(Model model) {
		
		 List<JciDIHoModel> AllList = (List<JciDIHoModel>) jciDIHoService.getAll();
		 model.addAttribute("AllList",AllList);
	
		return "ViewJCIHO";
	}
	
	// Nomination Settlement form
	
// Showing the Form of Nominal  form for fILLING
	@RequestMapping("viewmnominalform")
	public ModelAndView ViewNominalform(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("Nominationofofficial");
		if (username == null) {
			mv = new ModelAndView("index");
		}
		List<String>millid=nominalOfficialService.millid_MillReceipt();	
		// fetching the Contract No From JciContract Table
		List<UserRegistrationModel> OM_official = nominalOfficialService.getom_official();
		List<UserRegistrationModel> FA_official = nominalOfficialService.getfa_official();
		System.err.println("omname and fa name"+OM_official + FA_official );
		
        List<String>contractno= nominalOfficialService.contractno_ContractTable();
        
        mv.addObject("OM_official",OM_official);
        mv.addObject("FA_official",FA_official);
        mv.addObject("contractno", contractno);
		mv.addObject("millid", millid);
		return mv;
	}
	
	// For Handling AJAX Url for Fetching the Mill Receipt Table Data.
	
	@ResponseBody
	@RequestMapping(value = "fetchmillreceiptdata", method = RequestMethod.GET)
	public String FetchDataMillReciept(@RequestParam("millid") String millid)
	{
		
		System.out.println("Hello Shristy---------------- ");
		System.out.println("Hello Shristy---------------- ");
		System.out.println("Hello Shristy---------------- ");
		System.out.println("Hello Shristy---------------- ");
		
		System.out.println("Hello Shristy---------------- ");

		List<Object>millReceiptData=nominalOfficialService.FetchMillReceiptData(millid);

		System.out.println(millReceiptData);
	


		// Convert the a JSON in string
		Gson gson = new Gson();
		String jsonResponse = gson.toJson(millReceiptData);
		

		return jsonResponse;
		
		
	
	}
		

	
	
	
	@RequestMapping("savenominal")
	public ModelAndView saveNominalform(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		String username = (String) request.getSession().getAttribute("usrname");
		
		  String Mill = request.getParameter("Mill");  
		   String ContractNo = request.getParameter("ContractNo");    
		   String ChallanNo= request.getParameter("ChallanNo"); 
		   String MRNo = request.getParameter("MRNo");  
		   String BaleMark = request.getParameter("BaleMark");    
		   String jutegrade= request.getParameter("jutegrade"); 
		   String CropYear = request.getParameter("CropYear");  
		   double QualityClaim = (Double) Double.parseDouble(request.getParameter("QualityClaim"));    
		   double MoistureContent=  (Double) Double.parseDouble(request.getParameter("MoistureContent")); 
		   double NCVPercentage =(Double) Double.parseDouble( request.getParameter("NCVPercentage"));  
		   double ClaimAmount = (Double) Double.parseDouble (request.getParameter("ClaimAmount"));    
		   String omofficial= request.getParameter("omofficial");

		   
		   String FAofficial = request.getParameter("FAomofficial");  
		   String DateofInpection1 = request.getParameter("DateofInpection"); 
		   
		   // date Formatting in Indian Format
			  
			  SimpleDateFormat  inputDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
			  SimpleDateFormat outDataFormat=new SimpleDateFormat("dd-MM-yyyy");
			  String DateofInpection = null;
			  try {  
				  Date date =inputDateFormat.parse(DateofInpection1);  
				  //Convert the Date to a formatted string
			    DateofInpection = outDataFormat.format(date);   
			  }
			  catch(ParseException e)
			  {
				  e.printStackTrace();
			  }
		   
		   
		   
		  Long SettlementId= (Long) Long.parseLong(request.getParameter("SettlementId"));
		   
		   // Creating object of 
		   Jciclaim_NominationModel jciclaim_NominationModel=new Jciclaim_NominationModel();
		   jciclaim_NominationModel.setMill(Mill);
		   jciclaim_NominationModel.setContractNo(ContractNo);
		   jciclaim_NominationModel.setChallanNo(ChallanNo);
		   jciclaim_NominationModel.setQuality_settlement(QualityClaim);
		  
		   jciclaim_NominationModel.setMoisture_settlement(MoistureContent);
		   jciclaim_NominationModel.setNcv_settlement(NCVPercentage);
		   jciclaim_NominationModel.setClaimAmount(ClaimAmount);
		   jciclaim_NominationModel.setOMOfficial(omofficial);
		   jciclaim_NominationModel.setFAOfficial(FAofficial);
		   jciclaim_NominationModel.setDateofInspection(DateofInpection);
		   jciclaim_NominationModel.setSettlement_id(SettlementId);
		   
		   // setting Static Value for Remaining
		   jciclaim_NominationModel.setSettlement_amt(12.5);
		   jciclaim_NominationModel.setInspection_by("Inspection Setup");
		   jciclaim_NominationModel.setSupporting_doc("Supporting Documment");
		   jciclaim_NominationModel.setInspection_date("2023-07-23");
		   jciclaim_NominationModel.setDispute_flag(0);
		   jciclaim_NominationModel.setCreated_by("Today India");
		   jciclaim_NominationModel.setCreated_on("Today");
		   
		   nominalOfficialService.create(jciclaim_NominationModel);
		   
		   
		   //ModelAndView mv=new ModelAndView();
		  // mv.addObject("jciclaim_NominationModel", jciclaim_NominationModel);
		  // mv.setViewName("viewlistnominal");

			 redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n");

			return new ModelAndView(new RedirectView("viewlistnominal.obj"));
		  
          
      }
	
	@RequestMapping("viewlistnominal")
	public String ViewNominal(Model model) {

		 List<Jciclaim_NominationModel> AllList = (List<Jciclaim_NominationModel>) nominalOfficialService.getAll();
		 model.addAttribute("jciclaim_NominationModel",AllList);
	
		return "viewlistnominal";
	}
	

	@RequestMapping("entryoftds")
	public ModelAndView EntryofTDSForm(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("EntryofTds");
		if (username == null) {
			mv = new ModelAndView("index");
		}
		return mv;
	}
	
	@RequestMapping("saveentryTDS")
	public ModelAndView saveEntryOfTDS(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		String username = (String) request.getSession().getAttribute("usrname");
		
		 ModelAndView mv=new ModelAndView("");
		
		 return mv;
	
	}
	
	// Mill Acceptance Form
	
	@RequestMapping("millacceptform")
	public ModelAndView MillAcceptanceForm(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("MillAcceptance");
		if (username == null) {
			mv = new ModelAndView("index");
		}
		
		//  Fetching Data From Jci Contract Number
		 List<String> cno = millService.ContractNo();
		 mv.addObject("cno", cno);
		
		
		return mv;
	}
	

	// for AJAX CAll for Sending the Contract No.
	@ResponseBody
	@RequestMapping(value = "contractno", method = RequestMethod.GET)
	public String SendContractNo(@RequestParam("contractno") String contractno)
	{
		System.err.println("This is JCI ContractNo-----------------------");
		System.err.println("This is JCI ContractNo-----------------------");
		System.err.println(contractno);
		System.err.println(contractno);
		System.err.println(contractno);
		
		//String ContractDate=millService.ContractDate(contractno);
		
		
		List<Object>ContractListData=millService.FetchContractData(contractno);
		
		System.err.println(ContractListData);
		System.err.println(ContractListData);
		System.err.println(ContractListData);
		System.err.println(ContractListData);
		System.err.println(ContractListData);

		Gson gson = new Gson();
	
		return gson.toJson(ContractListData);
	

	}
	
	
	// ContractNofor Fc Data Fetch
	@ResponseBody
	@RequestMapping(value = "contractnoforfc", method = RequestMethod.GET)
	public String SendContractNoForFC(@RequestParam("contractno") String contractno)
	{
		
		System.out.println("Hello Fc Data");
		
	
		//String ContractDate=millService.ContractDate(contractno);
		List<Object>FcTableData=millService.fetchContractDate_FcRef_ContractQty_AllowedQty(contractno);
		// for Last DAte Shipment fetch from jcipayment_arrangement
		
		Object LastDateShipment= millService.LastDateShipment(contractno);

		
		System.out.println(LastDateShipment);
		// Create a map to hold your data
		Map<String, Object> jsonData = new HashMap<>();
		jsonData.put("FcTableData", FcTableData);
		jsonData.put("LastDateShipment", LastDateShipment);

		// Convert the map to a JSON string
		Gson gson = new Gson();
		String jsonResponse = gson.toJson(jsonData);

		return jsonResponse;
		
		
	
	}
		

	
	
	
	@RequestMapping("savemillacceptance")
	//public ModelAndView saveMillAccept(HttpServletRequest request, RedirectAttributes redirectAttributes,@RequestParam("Upload") CommonsMultipartFile file,HttpSession s) {
		public ModelAndView saveMillAccept(HttpServletRequest request, RedirectAttributes redirectAttributes,@RequestParam("upload") final MultipartFile SupportingDocument,HttpSession s) throws IllegalStateException, IOException {
		
		
		String username = (String) request.getSession().getAttribute("usrname");
		
	
		
		
		  String ContractNo = request.getParameter("ContractNo");  
		   String ContractDate = request.getParameter("ContractDate");    
		   String Quantity= request.getParameter("Quantity"); 
		  String ContractValueOnline = request.getParameter("ContractValueOnline");  
		   String ContractValueLc = request.getParameter("ContractValueLc");    
		   String paymentDue= request.getParameter("paymentDue"); 
		 
           final File theDir = new File("C:\\Users\\sudheer.kumar1\\upload");
           if (!theDir.exists()) {
               theDir.mkdirs();
           }
           final String filename = SupportingDocument.getOriginalFilename();
           File serverFile = new File(theDir, filename);
           SupportingDocument.transferTo(serverFile);

		   // Creating object of 
			MillAcceptanceModel millAcceptanceModel=new MillAcceptanceModel();
			millAcceptanceModel.setContractNo(ContractNo);
			millAcceptanceModel.setContractDate(ContractDate);
			millAcceptanceModel.setQuantity(Quantity);
			millAcceptanceModel.setContractValueOnline(ContractValueOnline);
			millAcceptanceModel.setContractValueLc(ContractValueLc);
			millAcceptanceModel.setPaymentDue(paymentDue);
			millAcceptanceModel.setUpload(filename);
			
		
		   
		   // setting Static Value for Remaining
			
		
			
		   
		 millService.create(millAcceptanceModel);
		   jciContractService.ContractFlagStausUpdate(ContractNo);
		   
	

			 redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n");

			return new ModelAndView(new RedirectView("viewmillaccept.obj"));
		  
          
      }
//	@RequestMapping("viewmillaccept")
//	public ModelAndView MillAcceptance(HttpServletRequest request) {
//		String username = (String) request.getSession().getAttribute("usrname");
//		ModelAndView mv = new ModelAndView("ViewMillAcceptance");
//		if (username == null) {
//			mv = new ModelAndView("index");
//		}
//		return mv;
//	}
	// for Downloading the Uploaded Document
	@RequestMapping("downloadSupportingDocument")
    public void downloadImage(@RequestParam("filename") String filename, HttpServletResponse response) {
        String imageDirectory = "C:\\Users\\sudheer.kumar1\\upload"; // Replace with your image directory path
        String imagePath = imageDirectory + File.separator + filename;

        File imageFile = new File(imagePath);

        // Check if the file exists
        if (imageFile.exists()) {
            try {
                // Set the content type based on the file type
                String contentType = determineContentType(filename);
                response.setContentType(contentType);

                // Set the content length and attachment disposition
                response.setContentLength((int) imageFile.length());
                //response.setHeader("Content-Disposition", "attachment; filename=" + filename);
                response.setHeader("Content-Disposition", "");
                // Stream the file content to the response
                FileInputStream fileInputStream = new FileInputStream(imageFile);
                OutputStream responseOutputStream = response.getOutputStream();

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                    responseOutputStream.write(buffer, 0, bytesRead);
                }

                fileInputStream.close();
                responseOutputStream.close();
            } catch (IOException e) {
                // Handle IO exception
                e.printStackTrace();
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    // Utility method to determine content type based on filename
    private String determineContentType(String filename) {
        if (filename.endsWith(".pdf")) {
            return "application/pdf";
        } else if (filename.endsWith(".jpg") || filename.endsWith(".jpeg")) {
            return "image/jpeg";
        } else if (filename.endsWith(".png")) {
            return "image/png";
        } else {
            return "application/octet-stream"; // Default to binary data if content type is unknown
        }

    }
	
	
	@RequestMapping("viewmillaccept")
	public String ViewMillAcceptance(Model model) {
		
		 List<MillAcceptanceModel> AllList = (List<MillAcceptanceModel>) millService.getAll();
		 model.addAttribute("AllList",AllList);
	
		return "ViewMillAcceptance";
	}
	
	


}



