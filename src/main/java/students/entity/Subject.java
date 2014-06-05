package students.entity;

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
@Table(name = "subject")
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long subjectId;
	
	@Column(name = "subject_name")
	private String subjectName;
	
	/*
	 * @ManyToMany - ��� ��������� ������� � ���, ��� ���� ����� 
	 * ������������ ��� ����� �����-��-������.
	 * 
     * @JoinTable - ��������� ��� �������, ������� ������������ ��� 
     * ����������� ����� �����-��-������. �������� joinColumns ��������� 
     * �������� �������, ������� �������� ������� �� ������� �����, 
     * �.�. �� Subject (������ ������� �� ������� SUBJECT). 
     * ��������inverseJoinColumns ��������� �� �������, � ������ 
     * ��������� ������ �� ����� � ������ ������� ��������� � � ������ 
     * ������ ���Profession.
	 */
	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinTable(name = "speciality_subject", 
	joinColumns = @JoinColumn(name = "subject_id"),
	inverseJoinColumns = @JoinColumn(name = "profession_id"))
	private Set<Profession> professionList;
	
	public Long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public Set<Profession> getProfessionList() {
		return professionList;
	}
	public void setProfessionList(Set<Profession> professionList) {
		this.professionList = professionList;
	}
	
}
