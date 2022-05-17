package virtualclass;

public class Materials {

	private String subject;
	private int subjectId;
	private long postedDate;

	public long getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(long postedDate) {
		this.postedDate = postedDate;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	@Override
	public String toString() {
		return "Materials [subject=" + subject + ", subjectId=" + subjectId + ", postedDate=" + postedDate + "]";
	}

}
