/**The class includes the main methods to printout the grades summary*/
public class RunReport {

	/**
	 * @param args
	 * @throws invalidGradeException 
	 * @throws noStudentNameException 
	 * @throws studentRepeatException 
	 * @throws noGradesException 
	 * @throws noStudentsSpecifiedException 
	 */
	public static void main(String[] args) throws noStudentNameException, invalidGradeException, studentRepeatException, noGradesException, noStudentsSpecifiedException {
		{
			Student JON = new Student("JON : 19 14 15 15 16");
			Student JEREMY = new Student("JEREMY : 15  11   10   15   16");
			Student JESSE = new Student ("JESSE", new int[] {19 ,17 ,20 ,19 ,18});
			Student MIKE = new Student ("MIKE", new int[] {19 ,17 ,20 ,19 ,18});
			Student NANCY = new Student ("NANCY", new int[] {16 ,17 ,15 ,19 ,18});
			FinalGrades finalgrade = new FinalGrades();
			finalgrade.addStudent(JON);
			finalgrade.addStudent(JEREMY);
			finalgrade.addStudent(JESSE);
			finalgrade.addStudent(MIKE);
			finalgrade.addStudent(NANCY);
			finalgrade.removeStudent(JON);
			finalgrade.printReport();
		}

	}

}
