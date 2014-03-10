package com.healthcare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "child_immunisation")
public class ChildImmunisation {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uhid;
	
	@Column
	private String child_last_name;
	private String child_middle_name;
	private String child_first_name;
	private String gender;
	private String mother_name;
	private String father_name;
	private Date dob;
	private Long age;
	private Date bcg_at_birth;
	private Date opvo_at_birth;
	private Date hepatatisb1_at_birth;
	private Date dpt1_at_6weeks;
	private Date opv1_at_6weeks;
	private Date hepatatisb2_at_6weeks;
	private Date dpt2_at_10weeks;
	private Date opv2_at_10weeks;
	private Date hepatatisb3_at_10weeks;
	private Date dpt3_at_14weeks;
	private Date opv3_at_14weeks;
	private Date hepatatisb4_at_10weeks;
	private Date measles_9_12_months;
	private Date vitamina_dose1_9_12_months;
	private Date mr_vaccine_16_24_months;
	private Date dpt_booster_16_24_months;
	private Date opv_booster_16_24_months;
	private Date vitamina_dose2_16_24_months;
	private Date vitamina_dose3_16_24_months;	
	private Date vitamina_dose4to9_2yrs;
	private Date dt5_2yrs;
	private Date tt10;
	private Date tt16;
	private String remarks;
	
	
	public ChildImmunisation() {
		
	}//default constructor
	
	public ChildImmunisation(String child_last_name,String child_middle_name,String child_first_name,
			String gender,String mother_name,String father_name,Date dob,Long age,Date bcg_at_birth,
			Date opvo_at_birth,Date hepatatisb1_at_birth,Date dpt1_at_6weeks,Date opv1_at_6weeks,
			Date hepatatisb2_at_6weeks,Date dpt2_at_10weeks,Date opv2_at_10weeks,Date hepatatisb3_at_10weeks,
			Date dpt3_at_14weeks,Date opv3_at_14weeks,Date hepatatisb4_at_10weeks,Date measles_9_12_months,
			Date vitamina_dose1_9_12_months,Date mr_vaccine_16_24_months,Date dpt_booster_16_24_months,
			Date opv_booster_16_24_months,Date vitamina_dose2_16_24_months,Date vitamina_dose3_16_24_months,
			Date vitamina_dose4to9_2yrs,Date dt5_2yrs,Date tt10,Date tt16,String remarks)
	{
		this.child_last_name=child_last_name;
		this.child_middle_name=child_middle_name;
		this.child_first_name=child_first_name;
		this.gender=gender;
		this.mother_name=mother_name;
		this.father_name=father_name;
		this.dob=dob;
		this.age=age;
		this.bcg_at_birth=bcg_at_birth;
		this.opvo_at_birth=opvo_at_birth;
		this.hepatatisb1_at_birth=hepatatisb1_at_birth;
		this.dpt1_at_6weeks=dpt1_at_6weeks;
		this.opv1_at_6weeks=opv1_at_6weeks;
		this.hepatatisb2_at_6weeks=hepatatisb2_at_6weeks;
		this.dpt2_at_10weeks=dpt2_at_10weeks;
		this.opv2_at_10weeks=opv2_at_10weeks;
		this.hepatatisb3_at_10weeks=hepatatisb3_at_10weeks;
		this.dpt3_at_14weeks=dpt3_at_14weeks;
		this.opv3_at_14weeks=opv3_at_14weeks;
		this.hepatatisb4_at_10weeks=hepatatisb4_at_10weeks;
		this.measles_9_12_months=measles_9_12_months;
		this.vitamina_dose1_9_12_months=vitamina_dose1_9_12_months;
		this.mr_vaccine_16_24_months=mr_vaccine_16_24_months;
		this.dpt_booster_16_24_months=dpt_booster_16_24_months;
		this.opv_booster_16_24_months=opv_booster_16_24_months;
		this.vitamina_dose2_16_24_months=vitamina_dose2_16_24_months;
		this.vitamina_dose3_16_24_months=vitamina_dose3_16_24_months;
		this.vitamina_dose4to9_2yrs=vitamina_dose4to9_2yrs;
		this.dt5_2yrs=dt5_2yrs;
		this.tt10=tt10;
		this.tt16=tt16;
		this.remarks=remarks;
		
	}// full constructor

	public Long getUhid() {
		return uhid;
	}

	public void setUhid(Long uhid) {
		this.uhid = uhid;
	}

	public String getChild_last_name() {
		return child_last_name;
	}

	public void setChild_last_name(String child_last_name) {
		this.child_last_name = child_last_name;
	}

	public String getChild_middle_name() {
		return child_middle_name;
	}

	public void setChild_middle_name(String child_middle_name) {
		this.child_middle_name = child_middle_name;
	}

	public String getChild_first_name() {
		return child_first_name;
	}

	public void setChild_first_name(String child_first_name) {
		this.child_first_name = child_first_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMother_name() {
		return mother_name;
	}

	public void setMother_name(String mother_name) {
		this.mother_name = mother_name;
	}

	public String getFather_name() {
		return father_name;
	}

	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public Date getBcg_at_birth() {
		return bcg_at_birth;
	}

	public void setBcg_at_birth(Date bcg_at_birth) {
		this.bcg_at_birth = bcg_at_birth;
	}

	public Date getOpvo_at_birth() {
		return opvo_at_birth;
	}

	public void setOpvo_at_birth(Date opvo_at_birth) {
		this.opvo_at_birth = opvo_at_birth;
	}

	public Date getHepatatisb1_at_birth() {
		return hepatatisb1_at_birth;
	}

	public void setHepatatisb1_at_birth(Date hepatatisb1_at_birth) {
		this.hepatatisb1_at_birth = hepatatisb1_at_birth;
	}

	public Date getDpt1_at_6weeks() {
		return dpt1_at_6weeks;
	}

	public void setDpt1_at_6weeks(Date dpt1_at_6weeks) {
		this.dpt1_at_6weeks = dpt1_at_6weeks;
	}

	public Date getOpv1_at_6weeks() {
		return opv1_at_6weeks;
	}

	public void setOpv1_at_6weeks(Date opv1_at_6weeks) {
		this.opv1_at_6weeks = opv1_at_6weeks;
	}

	public Date getHepatatisb2_at_6weeks() {
		return hepatatisb2_at_6weeks;
	}

	public void setHepatatisb2_at_6weeks(Date hepatatisb2_at_6weeks) {
		this.hepatatisb2_at_6weeks = hepatatisb2_at_6weeks;
	}

	public Date getDpt2_at_10weeks() {
		return dpt2_at_10weeks;
	}

	public void setDpt2_at_10weeks(Date dpt2_at_10weeks) {
		this.dpt2_at_10weeks = dpt2_at_10weeks;
	}

	public Date getOpv2_at_10weeks() {
		return opv2_at_10weeks;
	}

	public void setOpv2_at_10weeks(Date opv2_at_10weeks) {
		this.opv2_at_10weeks = opv2_at_10weeks;
	}

	public Date getHepatatisb3_at_10weeks() {
		return hepatatisb3_at_10weeks;
	}

	public void setHepatatisb3_at_10weeks(Date hepatatisb3_at_10weeks) {
		this.hepatatisb3_at_10weeks = hepatatisb3_at_10weeks;
	}

	public Date getDpt3_at_14weeks() {
		return dpt3_at_14weeks;
	}

	public void setDpt3_at_14weeks(Date dpt3_at_14weeks) {
		this.dpt3_at_14weeks = dpt3_at_14weeks;
	}

	public Date getOpv3_at_14weeks() {
		return opv3_at_14weeks;
	}

	public void setOpv3_at_14weeks(Date opv3_at_14weeks) {
		this.opv3_at_14weeks = opv3_at_14weeks;
	}

	public Date getHepatatisb4_at_10weeks() {
		return hepatatisb4_at_10weeks;
	}

	public void setHepatatisb4_at_10weeks(Date hepatatisb4_at_10weeks) {
		this.hepatatisb4_at_10weeks = hepatatisb4_at_10weeks;
	}

	public Date getMeasles_9_12_months() {
		return measles_9_12_months;
	}

	public void setMeasles_9_12_months(Date measles_9_12_months) {
		this.measles_9_12_months = measles_9_12_months;
	}

	public Date getVitamina_dose1_9_12_months() {
		return vitamina_dose1_9_12_months;
	}

	public void setVitamina_dose1_9_12_months(Date vitamina_dose1_9_12_months) {
		this.vitamina_dose1_9_12_months = vitamina_dose1_9_12_months;
	}

	public Date getMr_vaccine_16_24_months() {
		return mr_vaccine_16_24_months;
	}

	public void setMr_vaccine_16_24_months(Date mr_vaccine_16_24_months) {
		this.mr_vaccine_16_24_months = mr_vaccine_16_24_months;
	}

	public Date getDpt_booster_16_24_months() {
		return dpt_booster_16_24_months;
	}

	public void setDpt_booster_16_24_months(Date dpt_booster_16_24_months) {
		this.dpt_booster_16_24_months = dpt_booster_16_24_months;
	}

	public Date getOpv_booster_16_24_months() {
		return opv_booster_16_24_months;
	}

	public void setOpv_booster_16_24_months(Date opv_booster_16_24_months) {
		this.opv_booster_16_24_months = opv_booster_16_24_months;
	}

	public Date getVitamina_dose2_16_24_months() {
		return vitamina_dose2_16_24_months;
	}

	public void setVitamina_dose2_16_24_months(Date vitamina_dose2_16_24_months) {
		this.vitamina_dose2_16_24_months = vitamina_dose2_16_24_months;
	}

	public Date getVitamina_dose3_16_24_months() {
		return vitamina_dose3_16_24_months;
	}

	public void setVitamina_dose3_16_24_months(Date vitamina_dose3_16_24_months) {
		this.vitamina_dose3_16_24_months = vitamina_dose3_16_24_months;
	}

	public Date getVitamina_dose4to9_2yrs() {
		return vitamina_dose4to9_2yrs;
	}

	public void setVitamina_dose4to9_2yrs(Date vitamina_dose4to9_2yrs) {
		this.vitamina_dose4to9_2yrs = vitamina_dose4to9_2yrs;
	}

	public Date getDt5_2yrs() {
		return dt5_2yrs;
	}

	public void setDt5_2yrs(Date dt5_2yrs) {
		this.dt5_2yrs = dt5_2yrs;
	}

	public Date getTt10() {
		return tt10;
	}

	public void setTt10(Date tt10) {
		this.tt10 = tt10;
	}

	public Date getTt16() {
		return tt16;
	}

	public void setTt16(Date tt16) {
		this.tt16 = tt16;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
	

}//class
