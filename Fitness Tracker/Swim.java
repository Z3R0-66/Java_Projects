/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

public class Swim extends Activity{
	private String title;
	private String notes;
	private int caloriesBurned;
	private double distance;
	private int laps;
	private String stroke;
	private int minutes;
	private int dayOfYear; 
	
	public Swim(int dayOfYear, String title, String notes, int caloriesBurned, double distance, int laps, String stroke, int minutes) {
		super(dayOfYear, title, caloriesBurned, minutes);
		this.setDistance(distance);
		this.setLaps(laps);
		this.setStroke(stroke);
		this.setMinutes(minutes);
		
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

	public int getLaps() {
		return laps;
	}

	public void setLaps(int laps) {
		this.laps = laps;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getStroke() {
		return stroke;
	}

	public void setStroke(String stroke) {
		this.stroke = stroke;
	}
	
	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	
	@Override
	public String toString() {
		String str = "\nActivity - Swim on Day " + dayOfYear +
				     "\nSwim: " + title +
					 "\nNotes: " + notes +
					 "\nCalories: " + caloriesBurned +
					 "\nDistance: " + distance + " miles" +
					 "\nLaps: " + laps +
					 "\nStroke: " + stroke+"\n";
		return str;
	}
	
	public static void main(String[] args) {
		Swim swim = new Swim(4, "Gym Swim", "Swimming in gym pool", 300, 5, 20, "Backstroke", 100);
		System.out.println(swim.toString());
	}

	public int getDayOfYear() {
		return dayOfYear;
	}

	public void setDayOfYear(int dayOfYear) {
		this.dayOfYear = dayOfYear;
	}


	
}
