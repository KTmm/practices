import java.text.DecimalFormat;
import java.util.LinkedHashMap;

/**An instance representing a class's final grades
 * @author yingzhou*/
public class FinalGrades {
	/**Sum of each student's average grade in the class*/
	private double sumMean;
	
	/**A Map storing each student's name and average grade.
	 * key: student name, value: average grade of this student*/
	private LinkedHashMap<String, Double> classGrades = new LinkedHashMap<String, Double>();
	
	/**This method adds a student into the classGrades map and updates the classMean
	 * @param : a student object
	 * @throws studentRepeatException */
	public void addStudent(Student student) throws studentRepeatException{
		if(classGrades.containsKey(student.getName())){
			throw new studentRepeatException("Student Already Exists!");
		}
		classGrades.put(student.getName(), student.getMean());
		sumMean += student.getMean();
	}
	
	/**This method removes a student into the classGrades map and updates the classMean
	 * @param : a student object*/
	public void removeStudent(Student student){
		classGrades.remove(student.getName());
		if (classGrades.size() == 0){
			System.out.println("No student in the database!");
		}
		sumMean -= student.getMean();
	}
	
	/**@return the mean grades of all students*/
	public double getClassMean(){
		return sumMean/ classGrades.size();
	}
	
	/**This method prints summary of each student's average grade and the class'es average grade
	 * @see summary prints in the console */
	public void printReport(){
		DecimalFormat df = new DecimalFormat("#.00");
		for (String name : classGrades.keySet()){
			System.out.println(name + " "  + df.format(classGrades.get(name)) + '\n');
		}
		System.out.println("OVERALL " + df.format(getClassMean()));
	}
	
}
