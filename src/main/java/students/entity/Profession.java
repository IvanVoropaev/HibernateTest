package students.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "profession")
public class Profession {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long professionId;
	
	@Column(name = "profession_name")
	private String professionName;
	
	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinTable(name = "speciality_subject",
	joinColumns = @JoinColumn(name = "profession_id"),
	inverseJoinColumns = @JoinColumn(name = "subject_id"))
	private Set<Subject> subjectList = new HashSet<Subject>();
	
	public Set<Subject> getSubjectList() {
		return subjectList;
	}
	public void setSubjectList(Set<Subject> subjectList) {
		this.subjectList = subjectList;
	}
	public Long getProfessionId() {
		return professionId;
	}
	public void setProfessionId(Long professionId) {
		this.professionId = professionId;
	}
	public String getProfessionName() {
		return professionName;
	}
	public void setProfessionName(String professionName) {
		this.professionName = professionName;
	}
	
}
