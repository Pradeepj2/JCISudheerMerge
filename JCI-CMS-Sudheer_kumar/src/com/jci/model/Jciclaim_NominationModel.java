package com.jci.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jciclaim_nomination")
public class Jciclaim_NominationModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Settlement_id")
	private Long Settlement_id; // Primary key, assumed to be BigInt

	@Column(name = "Mill", nullable = false)
	private String Mill;

	@Column(name = "ContractNo", nullable = false)
	private String ContractNo;

	@Column(name = "ChallanNo", nullable = false)
	private String ChallanNo;

	@Column(name = "ClaimAmount", nullable = false)
	private double ClaimAmount;

	@Column(name = "OMOfficial", nullable = false)
	private String OMOfficial;
	
	@Column(name = "FAOfficial", nullable = false)
	private String FAOfficial;

	@Column(name = "DateofInspection", nullable = false)

	private String DateofInspection;
	
	@Column(name = "Quality_settlement")
	private double Quality_settlement;

	@Column(name = "Moisture_settlement")
	private double Moisture_settlement;
	@Column(name = "Ncv_settlement")
	private double Ncv_settlement;

	@Column(name = "Settlement_amt")
	private double Settlement_amt;

	@Column(name = "Inspection_by")
	private String Inspection_by;

	@Column(name = "Supporting_doc")
	private String Supporting_doc;

	@Column(name = "Inspection_date")
	private String Inspection_date;

	@Column(name = "Dispute_flag", columnDefinition = "INT DEFAULT 0")
	private int Dispute_flag;

	@Column(name = "Created_by", nullable = false)
	private String Created_by;

	@Column(name = "Created_on")
	private String Created_on;

	public Long getSettlement_id() {
		return Settlement_id;
	}

	public void setSettlement_id(Long settlement_id) {
		Settlement_id = settlement_id;
	}

	public String getMill() {
		return Mill;
	}

	public void setMill(String mill) {
		Mill = mill;
	}

	public String getContractNo() {
		return ContractNo;
	}

	public void setContractNo(String contractNo) {
		ContractNo = contractNo;
	}

	public String getChallanNo() {
		return ChallanNo;
	}

	public void setChallanNo(String challanNo) {
		ChallanNo = challanNo;
	}

	public double getClaimAmount() {
		return ClaimAmount;
	}

	public void setClaimAmount(double claimAmount) {
		ClaimAmount = claimAmount;
	}

	public String getOMOfficial() {
		return OMOfficial;
	}

	public void setOMOfficial(String oMOfficial) {
		OMOfficial = oMOfficial;
	}

	public String getFAOfficial() {
		return FAOfficial;
	}

	public void setFAOfficial(String fAOfficial) {
		FAOfficial = fAOfficial;
	}

	public String getDateofInspection() {
		return DateofInspection;
	}

	public void setDateofInspection(String dateofInspection) {
		DateofInspection = dateofInspection;
	}

	public double getQuality_settlement() {
		return Quality_settlement;
	}

	public void setQuality_settlement(double quality_settlement) {
		Quality_settlement = quality_settlement;
	}

	public double getMoisture_settlement() {
		return Moisture_settlement;
	}

	public void setMoisture_settlement(double moisture_settlement) {
		Moisture_settlement = moisture_settlement;
	}

	public double getNcv_settlement() {
		return Ncv_settlement;
	}

	public void setNcv_settlement(double ncv_settlement) {
		Ncv_settlement = ncv_settlement;
	}

	public double getSettlement_amt() {
		return Settlement_amt;
	}

	public void setSettlement_amt(double settlement_amt) {
		Settlement_amt = settlement_amt;
	}

	public String getInspection_by() {
		return Inspection_by;
	}

	public void setInspection_by(String inspection_by) {
		Inspection_by = inspection_by;
	}

	public String getSupporting_doc() {
		return Supporting_doc;
	}

	public void setSupporting_doc(String supporting_doc) {
		Supporting_doc = supporting_doc;
	}

	public String getInspection_date() {
		return Inspection_date;
	}

	public void setInspection_date(String inspection_date) {
		Inspection_date = inspection_date;
	}

	public int getDispute_flag() {
		return Dispute_flag;
	}

	public void setDispute_flag(int dispute_flag) {
		Dispute_flag = dispute_flag;
	}

	public String getCreated_by() {
		return Created_by;
	}

	public void setCreated_by(String created_by) {
		Created_by = created_by;
	}

	public String getCreated_on() {
		return Created_on;
	}

	public void setCreated_on(String created_on) {
		Created_on = created_on;
	}

	@Override
	public String toString() {
		return "Jciclaim_NominationModel [Settlement_id=" + Settlement_id + ", Mill=" + Mill + ", ContractNo="
				+ ContractNo + ", ChallanNo=" + ChallanNo + ", ClaimAmount=" + ClaimAmount + ", OMOfficial="
				+ OMOfficial + ", FAOfficial=" + FAOfficial + ", DateofInspection=" + DateofInspection
				+ ", Quality_settlement=" + Quality_settlement + ", Moisture_settlement=" + Moisture_settlement
				+ ", Ncv_settlement=" + Ncv_settlement + ", Settlement_amt=" + Settlement_amt + ", Inspection_by="
				+ Inspection_by + ", Supporting_doc=" + Supporting_doc + ", Inspection_date=" + Inspection_date
				+ ", Dispute_flag=" + Dispute_flag + ", Created_by=" + Created_by + ", Created_on=" + Created_on + "]";
	}

	
	

}
