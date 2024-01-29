package com.jci.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MillAcceptanceModel",schema = "dbo")
public class MillAcceptanceModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contract_id")
	private Long contract_id;

	@Column(name = "ContractNo")
	private String ContractNo; // 

	@Column(name = "ContractDate") 
	private String ContractDate;

	@Column(name = "Quantity")
	private String Quantity;


	@Column(name = "ContractValueOnline")
	private String ContractValueOnline; 

	@Column(name = "ContractValueLc")
	private String ContractValueLc;
	
	@Column(name = "paymentDue")
	private String paymentDue;
	
	@Column(name = "upload")
	private String upload;

	public Long getContract_id() {
		return contract_id;
	}

	public void setContract_id(Long contract_id) {
		this.contract_id = contract_id;
	}

	public String getContractNo() {
		return ContractNo;
	}

	public void setContractNo(String contractNo) {
		ContractNo = contractNo;
	}

	public String getContractDate() {
		return ContractDate;
	}

	public void setContractDate(String contractDate) {
		ContractDate = contractDate;
	}

	public String getQuantity() {
		return Quantity;
	}

	public void setQuantity(String quantity) {
		Quantity = quantity;
	}

	public String getContractValueOnline() {
		return ContractValueOnline;
	}

	public void setContractValueOnline(String contractValueOnline) {
		ContractValueOnline = contractValueOnline;
	}

	public String getContractValueLc() {
		return ContractValueLc;
	}

	public void setContractValueLc(String contractValueLc) {
		ContractValueLc = contractValueLc;
	}

	public String getPaymentDue() {
		return paymentDue;
	}

	public void setPaymentDue(String paymentDue) {
		this.paymentDue = paymentDue;
	}

	public String getUpload() {
		return upload;
	}

	public void setUpload(String upload) {
		this.upload = upload;
	}

	@Override
	public String toString() {
		return "MillAcceptanceModel [contract_id=" + contract_id + ", ContractNo=" + ContractNo + ", ContractDate="
				+ ContractDate + ", Quantity=" + Quantity + ", ContractValueOnline=" + ContractValueOnline
				+ ", ContractValueLc=" + ContractValueLc + ", paymentDue=" + paymentDue + ", upload=" + upload + "]";
	}
	
	
}
