package virtualclass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class VirtualClass {
	Map<Integer, Details> stuMap = new HashMap<Integer, Details>();
	Map<Integer, Map<String, Role>> login = new HashMap<>();
	List<Materials> ppt = new ArrayList<>();
	Map<Question, Answer> doubt = new HashMap<>();
	Map<Integer, Details> signup = new HashMap<Integer, Details>();

	public VirtualClass() {
		Details det = new Details();
		det.setId(1);
		det.setAge(20);
		det.setName("Karthi");
		stuMap.put(1, det);
		Map<String, Role> temp = new HashMap<String, Role>();
		temp.put("1", Role.Student);
		login.put(1, temp);
		Details det1 = new Details();
		det1.setId(2);
		det1.setAge(28);
		det1.setName("george");
		stuMap.put(2, det1);
		Map<String, Role> temp1 = new HashMap<String, Role>();
		temp1.put("2", Role.Faculty);
		login.put(2, temp1);
		Details det2 = new Details();
		det2.setId(2);
		det2.setAge(28);
		det2.setName("george");
		stuMap.put(2, det2);
		Map<String, Role> temp2 = new HashMap<String, Role>();
		temp2.put("3", Role.Admin);
		login.put(3, temp2);
		Materials m = new Materials();
		m.setPostedDate(System.currentTimeMillis());
		m.setSubject("Maths");
		ppt.add(m);
	}

	public String signup(Details obj, int id) {
		signup.put(id, obj);
		return "Signup Successful";
	}

	public String signupRequests(int val) {
		int k = 0;
		for (int id : signup.keySet()) {
			if (k == val) {
				Details obj = signup.get(id);
				stuMap.put(id, obj);
				Map<String, Role> temp = new HashMap<String, Role>();
				temp.put(obj.getPassword(), obj.getRole());
				login.put(obj.getId(), temp);
				signup.remove(id);
			}
			k++;
		}
		return "Successful";
	}

	public String listRequests() {
		StringBuilder sb = new StringBuilder();
		for (int id : signup.keySet()) {
			sb.append(signup.get(id));
			sb.append("\n");
		}
		return sb.toString();
	}

	public String editProfile(Details obj, int id) throws Exception {
		nullChecker(obj);
		stuMap.put(id, obj);
		return "edit successful";
	}

	public void nullChecker(Object obj) throws Exception {
		if (Objects.isNull(obj)) {
			throw new Exception("Error");
		}
	}

	public Details getProfile(int id) {
		return stuMap.get(id);
	}

	public String askDoubt(Question question) {
		doubt.put(question, null);
		return "Question added";
	}

	public String answerQuestion(Answer answer, int val) throws Exception {
		Question question = questions(val);
		nullChecker(question);
		if (question == null) {
			throw new Exception("Enter a valid question number");
		}
		doubt.put(question, answer);
		return "answer added";
	}

	public String listDoubt() {
		StringBuilder temp = new StringBuilder();
		for (Question s : doubt.keySet()) {
			temp.append(s.toString());
			temp.append("\n");
		}
		return temp.toString();
	}

	public String listAnswers() throws Exception {
		StringBuilder temp = new StringBuilder();
		for (Answer s : doubt.values()) {
			if (s == null) {
				throw new Exception("Empty");
			}
			temp.append(s.toString());
			temp.append("\n");
		}
		return temp.toString();
	}

	public Question questions(int val) {
		int k = 0;
		for (Question s : doubt.keySet()) {
			if (k == val) {
				return s;
			}
			k++;
		}
		return null;
	}

	public String showStudyMaterials() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ppt.size(); i++) {
			sb.append(ppt.get(i));
			sb.append("\n");
		}
		return sb.toString();
	}

	public Role loginAndRole(int id, String password) throws Exception {
		Map<String, Role> temp = login.get(id);
		if (temp == null) {
			throw new Exception("User not found");
		} else if (temp.get(password) == null) {
			throw new Exception("Password incorrect");
		}
		return temp.get(password);
	}

	public Details studentChecker(int id) throws Exception {
		Details obj = stuMap.get(id);
		if (obj == null) {
			throw new Exception("Student not found");
		}
		return obj;
	}

}
