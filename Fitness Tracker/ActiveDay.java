/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;

/**
 * Defines Active Day class
 * @author Ariam Colan
 *
 */

public class ActiveDay {
	private int dayOfYear;
	private ArrayList<Run> runList;
	private ArrayList<Bike> bikeList;
	private ArrayList<Swim> swimList;
	private ArrayList<Sport> sportList;
	private DailySteps dailySteps;

	
	private int sumCalories;
	private int sumMinutes;
	private double sumDistance=5;

	public ActiveDay(int dayOfYear) 
        {
		super();
		this.dayOfYear = dayOfYear;
		this.runList = new ArrayList<>();
		this.bikeList = new ArrayList<>();
		this.swimList = new ArrayList<>();
		this.sportList = new ArrayList<>();
		this.setDailySteps(null);
//                totalCaloriesBurned();
//                totalIntensityMinutes();
                
	}
	
	public int totalCaloriesBurned() {
		
		if(this.runList != null) {
			for(Run run: this.runList) {
				this.sumCalories += run.getCaloriesBurned();
			}
		}
		System.out.println("Debug 1");
		if(this.bikeList != null) {
			for(Bike bike: this.bikeList) {
				this.sumCalories += bike.getCaloriesBurned();
			}
		}
		
		if(this.swimList != null) {
			for(Swim swim: this.swimList) {
				this.sumCalories += swim.getCaloriesBurned();
			}
		}
		
		if(this.sportList != null) {
			for(Sport sport: this.sportList) {
				this.sumCalories += sport.getCaloriesBurned();
			}
		}
                return sumCalories;
	}
	
	public int totalIntensityMinutes() {
		if(this.runList != null) {
			for(Run run: this.runList) {
				this.sumMinutes += run.getMinutes();
			}
		}
		
		if(this.bikeList != null) {
			for(Bike bike: this.bikeList) {
				this.sumMinutes += bike.getMinutes();
			}
		}
		
		if(this.swimList != null) {
			for(Swim swim: this.swimList) {
				this.sumMinutes += swim.getMinutes();
			}
		}
		
		if(this.sportList != null) {
			for(Sport sport: this.sportList) {
				this.sumMinutes += sport.getMinutes();
			}
		}
                return sumMinutes;
	}
	
        public double totalSumDistance()
        {
            if(this.runList != null) {
			for(Run run: this.runList) {
				this.sumDistance += run.getDistance();
			}
		}
		
		if(this.bikeList != null) {
			for(Bike bike: this.bikeList) {
				this.sumDistance += bike.getDistance();
			}
		}
		
		if(this.swimList != null) {
			for(Swim swim: this.swimList) {
				this.sumDistance += swim.getDistance();
			}
		}
		
		if(this.sportList != null) {
			for(Sport sport: this.sportList) {
				this.sumDistance += sport.getDistance();
			}
		}
                return sumDistance;
        }
        
	public String dailySummary() {
		String summary = "";
		String intro = "Summary of Day " + dayOfYear;
		String separator = " --------------------------------------------";
		summary = intro + '\n' +
				  separator + '\n' +
				  this.runList.toString() + '\n' + separator + '\n' +
				  this.bikeList.toString() + '\n' + separator + '\n' +
				  this.swimList.toString() + '\n' + separator + '\n' +
				  this.sportList.toString() + '\n' + separator;
		return summary;
		/*summary = this.bike.getNotes() + ", " + this.run.getNotes() + ", " +
				  this.run.getNotes() + ", " + this.sport.getNotes() + ".";
		return summary;*/
	}
	
	public ActiveDay(int dayOfYear, ArrayList<Run> run, ArrayList<Bike> bike, ArrayList<Swim> swim, ArrayList<Sport> sport) {
		this.dayOfYear = dayOfYear;
		this.runList = run;
		this.bikeList = bike;
		this.swimList = swim;
		this.sportList = sport;
	}
	
	public ActiveDay(int dayOfYear, ArrayList<Run> run, ArrayList<Bike> bike, ArrayList<Swim> swim) {
		this.dayOfYear = dayOfYear;
		this.runList = run;
		this.bikeList = bike;
		this.swimList = swim;
		this.sportList = null;
	}
	
	public ActiveDay(int dayOfYear, ArrayList<Run> run, ArrayList<Bike> bike) {
		this.dayOfYear = dayOfYear;
		this.runList = run;
		this.bikeList = bike;
		this.swimList = null;
		this.sportList = null;
	}
	
	/*public ActiveDay(int dayOfYear, ArrayList<Run> run) {
		this.dayOfYear = dayOfYear;
		this.runList = run;
		this.bikeList = null;
		this.swimList = null;
		this.sportList = null;
	}

	public ActiveDay(int dayOfYear, ArrayList<Bike> bike) {
		this.dayOfYear = dayOfYear;
		this.runList = null;
		this.bikeList = bike;
		this.swimList = null;
		this.sportList = null;
	}
	
	public ActiveDay(int dayOfYear, ArrayList<Swim> swim) {
		this.dayOfYear = dayOfYear;
		this.runList = null;
		this.bikeList = null;
		this.swimList = swim;
		this.sportList = null;
	}
	
	public ActiveDay(int dayOfYear, ArrayList<Sport> sport) {
		this.dayOfYear = dayOfYear;
		this.runList = null;
		this.bikeList = null;
		this.swimList = null;
		this.sportList = sport;
	}
	*/
	
	public int getDayOfYear() {
		return dayOfYear;
	}

	public void setDayOfYear(int dayOfYear) {
		this.dayOfYear = dayOfYear;
	}

	public ArrayList<Bike> getBikeList() {
		return bikeList;
	}

	public void setBike(ArrayList<Bike> bike) {
		this.bikeList = bike;
	}

	public ArrayList<Swim> getSwimList() {
		return swimList;
	}

	public void setSwim(ArrayList<Swim> swim) {
		this.swimList = swim;
	}

	public ArrayList<Run> getRunList() {
		return runList;
	}

	public void setRun(ArrayList<Run> run) {
		this.runList = run;
	}

	public ArrayList<Sport> getSportList() {
		return sportList;
	}

	public void setSport(ArrayList<Sport> sport) {
		this.sportList = sport;
	}
	
	
	/*public static void main(String[] args) {
		Swim swim = new Swim(4, "Gym Swim", "Swimming in gym pool", 300, 5, 20, "Backstroke", 100);
		Sport sport = new Sport(7, "Pickup Soccer", "Playing striker for 30 minute halves in pickup", 60, 10, 2000);
		Run run = new Run(10, "Gym Run", "Treadmill run in gym", 200, 100, 5.2);
		Bike bike = new Bike (12, "City Bike Tour", "Tour around the city on bike", 500, 200, 30, "Pittsburgh");
		

		ActiveDay day1 = new ActiveDay(dayOfYear, runList, bikeList, swimList, sportList);
		System.out.println(swim.toString() + " " + sport.toString() + " "
						   + run.toString() + " " + bike.toString());
		System.out.println(str.toString());
		
		System.out.println(dailySummary());
		//System.out.println("Total Calories Burned on Day 1 is: " + totalCaloriesBurned();
		//System.out.println("Total Intensity Minutes on Day 1 is: " + day1.totalIntensityMinutes());
	*/

	public DailySteps getDailySteps() {
		return dailySteps;
	}

	public void setDailySteps(DailySteps dailySteps) {
		this.dailySteps = dailySteps;
	}
	
}
