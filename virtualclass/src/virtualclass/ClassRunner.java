package virtualclass;

import java.util.Scanner;

public class ClassRunner {
	public static void main(String args[]) {
		VirtualClass vc = new VirtualClass();
		Scanner scan = new Scanner(System.in);
		Boolean temp = new Boolean(true);
		while (temp) {
			System.out.println("1.Signin\n2.Signup");
			int sign = scan.nextInt();
			switch (sign) {
			case 1: {
				System.out.println("Enter the id");
				int id = scan.nextInt();
				scan.nextLine();
				System.out.println("Enter the password");
				String password = scan.nextLine();
				Role val = null;
				try {
					val = vc.loginAndRole(id, password);
				} catch (Exception e) {
					System.out.println(e.getMessage());
					continue;
				}
				switch (val) {
				case Student:
					System.out.println("Edit profile");
					System.out.println("Study materials");
					System.out.println("Ask Doubts");
					System.out.println("Answers");
					int num = scan.nextInt();
					switch (num) {
					case 1:
						Details obj = vc.getProfile(id);
						try {
							System.out.println(obj);
							vc.editProfile(obj, id);
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					case 2:
						System.out.println(vc.showStudyMaterials());
						break;
					case 3:
						scan.nextLine();
						System.out.println("Enter the question");
						String question = scan.nextLine();
						Question ques = ObjectSetter.questionSetter(System.currentTimeMillis(),
								vc.getProfile(id).getName(), question);
						System.out.println(vc.askDoubt(ques));
						break;
					case 4:
						try {
							System.out.println(vc.listAnswers());
						} catch (Exception e2) {
							System.out.println(e2.getMessage());
						}
						break;
					default:
						break;
					}
					break;
				case Faculty:
					System.out.println("Edit profile");
					System.out.println("Study materials");
					System.out.println("Doubts");
					System.out.println("Answer the question");
					int num1 = scan.nextInt();
					switch (num1) {
					case 1:
						Details obj = vc.getProfile(id);
						try {
							System.out.println(obj);
							vc.editProfile(obj, id);
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					case 2:
						System.out.println(vc.showStudyMaterials());
						break;
					case 3:
						System.out.println(vc.listDoubt());
						break;
					case 4:
						System.out.println(vc.listDoubt());
						System.out.println("Enter the question number");
						int nums = scan.nextInt();
						scan.nextLine();
						System.out.println("Enter the answer");
						String answer = scan.nextLine();
						Answer ans = ObjectSetter.answerSetter(System.currentTimeMillis(), vc.getProfile(id).getName(),
								answer);
						try {
							System.out.println(vc.answerQuestion(ans, nums));
						} catch (Exception e1) {
							System.out.println(e1.getMessage());
						}
						break;
					default:
						break;
					}
					break;
				case Admin:
					System.out.println("1.Edit profile");
					System.out.println("2.Study materials");
					System.out.println("3.Doubts");
					System.out.println("4.Answers\n5.Signup request");
					int num2 = scan.nextInt();
					switch (num2) {
					case 1:
						Details obj = vc.getProfile(id);
						try {
							System.out.println(obj);
							vc.editProfile(obj, id);
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					case 2:
						System.out.println(vc.showStudyMaterials());
						break;
					case 3:
						System.out.println(vc.listDoubt());
						break;
					case 4:
						try {
							System.out.println(vc.listAnswers());
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						break;
					case 5:
						System.out.println(vc.listRequests());
						int signupid = scan.nextInt();
						System.out.println(vc.signupRequests(signupid));
						break;
					default:
						break;
					}
					break;
				default:
					break;
				}
				break;
			}
			case 2: {
				scan.nextLine();
				System.out.println("Enter the name");
				String name = scan.nextLine();
				System.out.println("Enter the address");
				String add = scan.nextLine();
				System.out.println("Enter the age");
				int age = scan.nextInt();
				System.out.println("1.Student \n2.Teacher");
				int role = scan.nextInt();
				scan.nextLine();
				System.out.println("Enter the password");
				String pass = scan.nextLine();
				System.out.println("confirm password");
				String pass1 = scan.nextLine();
				if (!pass.equals(pass1)) {
					System.out.println("Wrong password");
					continue;
				}
				Details detail = ObjectSetter.detailsSetter(name, add, age, role, pass);
				int iden = detail.getId();
				System.out.println("your id is " + iden);
				vc.signup(detail, iden);
				break;
			}
			default: {
				break;
			}
			}

		}
		scan.close();
	}
}