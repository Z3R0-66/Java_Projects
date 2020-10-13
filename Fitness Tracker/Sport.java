/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

public class Sport extends Activity {
	private String title;
	private String notes;
	private int minutes;
	private int distance;
	private int caloriesBurned;
	private int dayOfYear;
	
	public Sport(int dayOfYear, String title, String notes, int minutes, int distance, int caloriesBurned) {
		super(dayOfYear, title, caloriesBurned, minutes);
		this.setTitle(title);
		this.setNotes(notes);
		
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

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public int getCaloriesBurned() {
		return caloriesBurned;
	}

	public void setCaloriesBurned(int caloriesBurned) {
		this.caloriesBurned = caloriesBurned;
	}
	
	@Override
	public String toString() {
		String str = "\nSport - Choice of Sport on Day " + dayOfYear +
					 "\nSport Title: " + title +
					 "\nNotes: " + notes +
					 "\nMinutes: " + minutes + " mins" +
					 "\nDistance " + distance + " miles\n";
		return str;
	}
	
	public static void main(String[] args) {
		Sport sport = new Sport(15, "Pickup Soccer", "Playing striker for 30 minute halves in pickup", 60, 10, 2000);
		System.out.println(sport.toString());
	}

	public int getDayOfYear() {
		return dayOfYear;
	}

	public void setDayOfYear(int dayOfYear) {
		this.dayOfYear = dayOfYear;
	}

}

