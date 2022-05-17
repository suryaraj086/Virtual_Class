package virtualclass;

public class ObjectSetter {

	static int id = 4;

	public static int idGenerate() {
		return id++;
	}

	public static Question questionSetter(long time, String name, String question) {
		Question ques = new Question();
		ques.setName(name);
		ques.setPostedDate(time);
		ques.setQuestion(question);
		return ques;
	}

	public static Answer answerSetter(long time, String name, String answer) {
		Answer ans = new Answer();
		ans.setTime(time);
		ans.setAnswer(answer);
		ans.setName(name);
		return ans;
	}

	public static Details detailsSetter(String name, String address, int age, int role, String password) {
		Details detail = new Details();
		detail.setName(name);
		detail.setAddress(address);
		detail.setAge(age);
		detail.setId(idGenerate());
		detail.setPassword(password);
		if (role == 1) {
			detail.setRole(Role.Student);
		} else {
			detail.setRole(Role.Faculty);
		}
		return detail;
	}

}
