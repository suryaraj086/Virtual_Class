package virtualclass;

public class Question {
	private long postedDate;
	private int id;
	private String name;
	private String question;

	public long getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(long postedDate) {
		this.postedDate = postedDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "Question [postedDate=" + postedDate + ", id=" + id + ", name=" + name + ", question=" + question + "]";
	}

}
