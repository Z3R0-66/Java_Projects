/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
public class Activity 
{
	private int dayOfYear;
	private String title;
	private int caloriesBurned;
	private int minutes;
	
	public Activity(int dayOfYear, String title, int caloriesBurned, int minutes) {
		this.setDayOfYear(dayOfYear);
		this.setTitle(title);
		this.setCaloriesBurned(caloriesBurned);
		this.setMinutes(minutes);
	}

	public int getDayOfYear() {
		return dayOfYear;
	}

	public void setDayOfYear(int dayOfYear) {
		this.dayOfYear = dayOfYear;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
}
