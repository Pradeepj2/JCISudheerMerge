package com.jci.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "jciboe")
public class jciboeModel {

	@Id
	@Column(name = "Boe_no", nullable = false)
	private String Boe_no; // Primary key, assumed to be BigInt

	@Column(name = "Boe_Date ", nullable = false)
	private String Boe_Date ;

	@Column(name = "BOS_details", nullable = false)
	private String BOS_details;

	@Column(name = "Lc_details", nullable = false)
	private String Lc_details;
	
	@Column(name = "Jci_bank_advising", nullable = false)
	private String Jci_bank_advising;
	
	@Column(name = "Boe_amt", nullable = false)
	private double Boe_amt;

	public String getBoe_no() {
		return Boe_no;
	}

	public void setBoe_no(String boe_no) {
		Boe_no = boe_no;
	}

	public String getBoe_Date() {
		return Boe_Date;
	}

	public void setBoe_Date(String boe_Date) {
		Boe_Date = boe_Date;
	}

	public String getBOS_details() {
		return BOS_details;
	}

	public void setBOS_details(String bOS_details) {
		BOS_details = bOS_details;
	}

	public String getLc_details() {
		return Lc_details;
	}

	public void setLc_details(String lc_details) {
		Lc_details = lc_details;
	}

	public String getJci_bank_advising() {
		return Jci_bank_advising;
	}

	public void setJci_bank_advising(String jci_bank_advising) {
		Jci_bank_advising = jci_bank_advising;
	}

	public double getBoe_amt() {
		return Boe_amt;
	}

	public void setBoe_amt(double boe_amt) {
		Boe_amt = boe_amt;
	}
	
	


    public jciboeModel() {
	super();
	// TODO Auto-generated constructor stub
    }

public jciboeModel(String boe_no, String boe_Date, String bOS_details, String lc_details, String jci_bank_advising,
		double boe_amt) {
	super();
	Boe_no = boe_no;
	Boe_Date = boe_Date;
	BOS_details = bOS_details;
	Lc_details = lc_details;
	Jci_bank_advising = jci_bank_advising;
	Boe_amt = boe_amt;
   }

	@Override
	public String toString() {
		return "jciboeModel [Boe_no=" + Boe_no + ", Boe_Date=" + Boe_Date + ", BOS_details=" + BOS_details
				+ ", Lc_details=" + Lc_details + ", Jci_bank_advising=" + Jci_bank_advising + ", Boe_amt=" + Boe_amt
				+ "]";
	 }

	
}