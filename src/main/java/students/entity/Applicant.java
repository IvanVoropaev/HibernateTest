package students.entity;

import java.util.List;

public class Applicant {
	
	private Long applicantId;
	//много-к-одному (много Applicant с одной и той же Profession)
	private Profession profession; 
	//один-ко-многим (много ApplicantResult у одного Applicant)
	private List<ApplicantResult> applicantResultList;
	private String firstName;
	private String middleName;
	private String lastName;
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	private Integer entranceYear;
	
	public Long getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(Long applicantId) {
		this.applicantId = applicantId;
	}
	public Profession getProfession() {
		return profession;
	}
	public void setProfession(Profession profession) {
		this.profession = profession;
	}
	public List<ApplicantResult> getApplicantResultList() {
		return applicantResultList;
	}
	public void setApplicantResultList(List<ApplicantResult> applicantResultList) {
		this.applicantResultList = applicantResultList;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public Integer getEntranceYear() {
		return entranceYear;
	}
	public void setEntranceYear(Integer entranceYear) {
		this.entranceYear = entranceYear;
	}
	
	
}
