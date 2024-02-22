package com.jci.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jcicontract")
public class JcicontractModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contract_id")
	private Long contract_id;

	@Column(name = "Pcso_date", length = 250)
	private String Pcso_date; // 

	@Column(name = "Contract_identification_no", length = 255, unique = true) 
	private String Contract_identification_no;

	@Column(name = "Contract_no", unique = true)
	private String Contract_no;


	@Column(name = "Contract_date", nullable = false)
	private String Contract_date; 

	@Column(name = "Contract_qty", nullable = false)
	private String Contract_qty;

	@Column(name = "Contract_value", nullable = false)
	private double Contract_value;

	@Column(name = " Mill_code", nullable = false)
	private int Mill_code;
	
	@Column(name = "Mill_name", nullable = false)
	private String Mill_name;
	
	@Column(name = "Mill_qty", nullable = false)
	private double Mill_qty;
	
	@Column(name = "Delivery_type", nullable = false)
	private String Delivery_type;
	

	@Column(name = "Grade_composition_id", nullable = false)
	private double Grade_composition_id;
	
	@Column(name = "Payment_duedate", nullable = false)
	private String Payment_duedate;
	
	@Column(name = "Contract_cancellation_flag",columnDefinition =  "INT DEFAULT 0")
	private int Contract_cancellation_flag;
	
	@Column(name = "Contract_cancel_date")
	private String Contract_cancel_date;
	
	@Column(name = "Contract_acceptance_flag",columnDefinition = "INT DEFAULT 0")
	private int Contract_acceptance_flag;
	
	
	
	@Column(name = "Contract_acceptance_date")
	private String Contract_acceptance_date;
	
	@Column(name = "Contract_acceptance_doc",length = 250)
	private String Contract_acceptance_doc;
	
	
	@Column(name = "Intial_Payment_date")
	private String Intial_Payment_date;
	
	@Column(name = "Intial_Payment_flag",columnDefinition = "INT DEFAULT 0")
	private int Intial_Payment_flag;
	
	@Column(name = "Contract_status",columnDefinition = "VARCHAR(255) DEFAULT 'Mill Acceptance Pending'")
	private String Contract_status;
	
	@Column(name = "Created_date")
	private String Created_date;
	
	@Column(name = "Created_by")
	private String Created_by;
	
	
	@Column(name = "Acceptance_doc_path",length = 250)
	private String Acceptance_doc_path;

	public Long getContract_id() {
		return contract_id;
	}

	public void setContract_id(Long contract_id) {
		this.contract_id = contract_id;
	}

	public String getPcso_date() {
		return Pcso_date;
	}

	public void setPcso_date(String pcso_date) {
		Pcso_date = pcso_date;
	}

	public String getContract_identification_no() {
		return Contract_identification_no;
	}

	public void setContract_identification_no(String contract_identification_no) {
		Contract_identification_no = contract_identification_no;
	}

	public String getContract_no() {
		return Contract_no;
	}

	public void setContract_no(String contract_no) {
		Contract_no = contract_no;
	}

	public String getContract_date() {
		return Contract_date;
	}

	public void setContract_date(String contract_date) {
		Contract_date = contract_date;
	}

	public String getContract_qty() {
		return Contract_qty;
	}

	public void setContract_qty(String contract_qty) {
		Contract_qty = contract_qty;
	}

	public double getContract_value() {
		return Contract_value;
	}

	public void setContract_value(double contract_value) {
		Contract_value = contract_value;
	}

	public int getMill_code() {
		return Mill_code;
	}

	public void setMill_code(int mill_code) {
		Mill_code = mill_code;
	}

	public String getMill_name() {
		return Mill_name;
	}

	public void setMill_name(String mill_name) {
		Mill_name = mill_name;
	}

	public double getMill_qty() {
		return Mill_qty;
	}

	public void setMill_qty(double mill_qty) {
		Mill_qty = mill_qty;
	}

	public String getDelivery_type() {
		return Delivery_type;
	}

	public void setDelivery_type(String delivery_type) {
		Delivery_type = delivery_type;
	}

	public double getGrade_composition_id() {
		return Grade_composition_id;
	}

	public void setGrade_composition_id(double grade_composition_id) {
		Grade_composition_id = grade_composition_id;
	}

	public String getPayment_duedate() {
		return Payment_duedate;
	}

	public void setPayment_duedate(String payment_duedate) {
		Payment_duedate = payment_duedate;
	}

	public int getContract_cancellation_flag() {
		return Contract_cancellation_flag;
	}

	public void setContract_cancellation_flag(int contract_cancellation_flag) {
		Contract_cancellation_flag = contract_cancellation_flag;
	}

	public String getContract_cancel_date() {
		return Contract_cancel_date;
	}

	public void setContract_cancel_date(String contract_cancel_date) {
		Contract_cancel_date = contract_cancel_date;
	}

	public int getContract_acceptance_flag() {
		return Contract_acceptance_flag;
	}

	public void setContract_acceptance_flag(int contract_acceptance_flag) {
		Contract_acceptance_flag = contract_acceptance_flag;
	}

	public String getContract_acceptance_date() {
		return Contract_acceptance_date;
	}

	public void setContract_acceptance_date(String contract_acceptance_date) {
		Contract_acceptance_date = contract_acceptance_date;
	}

	public String getContract_acceptance_doc() {
		return Contract_acceptance_doc;
	}

	public void setContract_acceptance_doc(String contract_acceptance_doc) {
		Contract_acceptance_doc = contract_acceptance_doc;
	}

	public String getIntial_Payment_date() {
		return Intial_Payment_date;
	}

	public void setIntial_Payment_date(String intial_Payment_date) {
		Intial_Payment_date = intial_Payment_date;
	}

	public int getIntial_Payment_flag() {
		return Intial_Payment_flag;
	}

	public void setIntial_Payment_flag(int intial_Payment_flag) {
		Intial_Payment_flag = intial_Payment_flag;
	}

	public String getContract_status() {
		return Contract_status;
	}

	public void setContract_status(String contract_status) {
		Contract_status = contract_status;
	}

	public String getCreated_date() {
		return Created_date;
	}

	public void setCreated_date(String created_date) {
		Created_date = created_date;
	}

	public String getCreated_by() {
		return Created_by;
	}

	public void setCreated_by(String created_by) {
		Created_by = created_by;
	}
	

	public String getAcceptance_doc_path() {
		return Acceptance_doc_path;
	}

	public void setAcceptance_doc_path(String acceptance_doc_path) {
		Acceptance_doc_path = acceptance_doc_path;
	}

	
	@Override
	public String toString() {
		return "JcicontractModel [contract_id=" + contract_id + ", Pcso_date=" + Pcso_date
				+ ", Contract_identification_no=" + Contract_identification_no + ", Contract_no=" + Contract_no
				+ ", Contract_date=" + Contract_date + ", Contract_qty=" + Contract_qty + ", Contract_value="
				+ Contract_value + ", Mill_code=" + Mill_code + ", Mill_name=" + Mill_name + ", Mill_qty=" + Mill_qty
				+ ", Delivery_type=" + Delivery_type + ", Grade_composition_id=" + Grade_composition_id
				+ ", Payment_duedate=" + Payment_duedate + ", Contract_cancellation_flag=" + Contract_cancellation_flag
				+ ", Contract_cancel_date=" + Contract_cancel_date + ", Contract_acceptance_flag="
				+ Contract_acceptance_flag + ", Contract_acceptance_date=" + Contract_acceptance_date
				+ ", Contract_acceptance_doc=" + Contract_acceptance_doc + ", Intial_Payment_date="
				+ Intial_Payment_date + ", Intial_Payment_flag=" + Intial_Payment_flag + ", Contract_status="
				+ Contract_status + ", Created_date=" + Created_date + ", Created_by=" + Created_by
				+ ", Acceptance_doc_path=" + Acceptance_doc_path + "]";
	}
//	

	
	
}
