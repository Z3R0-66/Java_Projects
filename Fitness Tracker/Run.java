/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;


public class Run extends Activity {
	private String title;
	private String notes;
	private int caloriesBurned;
	private int minutes;
	private double distance;
	private int dayOfYear;
	
	public Run(int dayOfYear, String title, String notes, int caloriesBurned, int minutes, double distance) {
		super(dayOfYear, title, caloriesBurned, minutes);
		this.notes = notes;
		this.distance = distance;	
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getNotes() {
		return notes;
	}
	
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public int getCaloriesBurned() {
		return caloriesBurned;
	}
	
	public void setCaloriesBurned(int caloriesBurned) {
		this.caloriesBurned = caloriesBurned;
	}
	
	public int getMinutes() {
		return minutes;
	}
	
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	
	public double getDistance() {
		return distance;
	}
	
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	
	@Override
	public String toString() {
		String str = "\nActivity - Run on Day " + dayOfYear +
					 "\nRun: " + title + 
				     "\nNotes: " + notes +
					 "\nCalories: " + caloriesBurned +
					 "\nDistance: " + distance + " miles"+
					 "\nMinutes: " + minutes + " min\n";
		return str;
	}
	
	public static void main(String[] args) {
		Run run = new Run(1, "Gym Run", "Treadmill run in gym", 200, 100, 5.2);
		//System.out.println(r);
		System.out.println(run.toString());
	}

	public int getDayOfYear() {
		return dayOfYear;
	}

	public void setDayOfYear(int dayOfYear) {
		this.dayOfYear = dayOfYear;
	}

}
