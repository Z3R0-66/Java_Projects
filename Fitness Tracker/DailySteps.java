/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

public class DailySteps {
	private int dayOfYear;
	private int numberOfSteps;
	
	public DailySteps(int dayOfYear, int numberOfSteps) {
		this.dayOfYear = dayOfYear;
		this.numberOfSteps = numberOfSteps;
	}
	public int getDayOfYear() {
		return dayOfYear;
	}
	public void setDayOfYear(int dayOfYear) {
		this.dayOfYear = dayOfYear;
	}
	public int getNumberOfSteps() {
		return numberOfSteps;
	}
	public void setNumberOfSteps(int numberOfSteps) {
		this.numberOfSteps = numberOfSteps;
	}
	
	public static void main(String[] args) {
		DailySteps ds = new DailySteps (14, 1000);
		System.out.println(ds.toString());
	}
	
	@Override
	public String toString() {
		String str = "\nActivity - Step on Day " + dayOfYear +
					 "\nDaily Steps: " + numberOfSteps+"\n";
		return str;
	}
}
