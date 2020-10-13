/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

public class Bike extends Activity {
	private String title;
	private String notes;
	private int caloriesBurned;
	private int minutes;
	private double distance;
	private String location;
	private int dayOfYear;
	
	public Bike(int dayOfYear, String title, String notes, int caloriesBurned, int minutes, double distance, String location) {
		super(dayOfYear, title, caloriesBurned, minutes);
		this.setNotes(notes);
		this.setDistance(distance);
		this.setLocation(location);
		
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		String str = "\nActivity - Bike on Day " + dayOfYear +
					 "\nBike: " + title +
					 "\nNotes: " + notes +
					 "\nCalories: " + caloriesBurned +
					 "\nMinutes: " + minutes + " mins" +
					 "\nDistance: " + distance + " miles" +
					 "\nLocation: " + location+"\n";
		return str;
	}
	
	public static void main(String[] args) {
		Bike bike = new Bike (12, "City Bike Tour", "Tour around the city on bike", 500, 200, 30, "Pittsburgh");
		//System.out.println(k);
		System.out.println(bike.toString());
	}

	public int getDayOfYear() {
		return dayOfYear;
	}

	public void setDayOfYear(int dayOfYear) {
		this.dayOfYear = dayOfYear;
	}
	

}
