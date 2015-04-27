package db.project3.dto;

import javax.persistence.Embeddable;

@Embeddable
public class Subject {
	private String subjectDesc;

	public String getSubjectDesc() {
		return subjectDesc;
	}

	public void setSubjectDesc(String subjectDesc) {
		this.subjectDesc = subjectDesc;
	}
	
}
