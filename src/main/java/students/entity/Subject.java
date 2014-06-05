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
	 * @ManyToMany - эта аннотация говорит о том, что поле будет 
	 * использовано для связи много-ко-многим.
	 * 
     * @JoinTable - указывает имя таблицы, которая используется для 
     * организации связи много-ко-многим. Параметр joinColumns указывает 
     * название столбца, которые явялется ссылкой на текущий класс, 
     * т.е. на Subject (точнее ссылкой на таблицу SUBJECT). 
     * ПараметрinverseJoinColumns указывает на колонку, в которй 
     * находится ссылка на класс с другой стороны отношения – в данном 
     * случае этоProfession.
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
