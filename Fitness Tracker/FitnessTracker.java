/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class FitnessTracker {
	private ArrayList<Run> runList;
	private ArrayList<Bike> bikeList;
	private ArrayList<Swim> swimList;
	private ArrayList<Sport> sportList;
	private ArrayList<DailySteps> dailyStepsList;
	private ActiveDay[] activeDays;
        private static LocalDate lc=getToday();

    public static LocalDate getLc() 
    {
        return lc;
    }

    public ActiveDay[] getActiveDays() 
    {
        return activeDays;
    }

    public ArrayList<DailySteps> getDailyStepsList() {
        return dailyStepsList;
    }
	
        public static FitnessTracker getFitnessTracker(String path)
        {
            String runFileName=path+"\\";
            String bikeFileName=path+"\\";
            String swimFileName=path+"\\";
            String sportFileName=path+"\\";
            String dailyStepFile=path+"\\";

            return new FitnessTracker(runFileName,bikeFileName,swimFileName,sportFileName,dailyStepFile);
        }
	public FitnessTracker(String runFileName, String bikeFileName, String swimFileName, String sportFileName, String dailyStepFile)
        {
		this.runList = ActivityManager.readRuns(runFileName);
		this.bikeList = ActivityManager.readBike(bikeFileName);
		this.swimList = ActivityManager.readSwims(swimFileName);
		this.sportList = ActivityManager.readSport(sportFileName);
                this.dailyStepsList=ActivityManager.readSteps(dailyStepFile);

		this.activeDays = new ActiveDay[365];
		for(int i = 0; i<this.activeDays.length; i++) 
                {
			this.activeDays[i] = null;
		}
 
		populateActiveDayArray();
	}
	public void populateActiveDayArray()
        {
		if(!this.runList.isEmpty()) 
                {
			for(Run run: this.runList)
                        {
				int dayOfYear = run.getDayOfYear();
				if(this.activeDays[dayOfYear - 1] != null) 
                                {
                                    this.activeDays[dayOfYear - 1].getRunList().add(run);
				} 
                                else 
                                {
                                    this.activeDays[dayOfYear -1] = new ActiveDay(dayOfYear);
                                    this.activeDays[dayOfYear -1].getRunList().add(run);
				}
                                
			}
		}

		if(!this.dailyStepsList.isEmpty()) 
                {
                    for(DailySteps steps: this.dailyStepsList)
                    {
			int dayOfYear = steps.getDayOfYear();
			if(this.activeDays[dayOfYear -1] != null) 
                        {
                            this.activeDays[dayOfYear -1].setDailySteps(steps);
			}
                        else 
                        {
                            this.activeDays[dayOfYear -1] = new ActiveDay(dayOfYear);
                            this.activeDays[dayOfYear -1].setDailySteps(steps);
			}
                    }
		}
	}

	public ArrayList<Swim> getSwimList() {
		return swimList;
	}

	public void setSwimList(ArrayList<Swim> swimList) {
		this.swimList = swimList;
	}

	public ArrayList<Run> getRunList() {
		return runList;
	}

	public void setRunList(ArrayList<Run> runList) {
		this.runList = runList;
	}

	public ArrayList<Bike> getBikeList() {
		return bikeList;
	}

	public void setBikeList(ArrayList<Bike> bikeList) {
		this.bikeList = bikeList;
	}

	public ArrayList<Sport> getSportList() {
		return sportList;
	}

	public void setSportList(ArrayList<Sport> sportList) 
        {
		this.sportList = sportList;
	}
        public static LocalDate getToday()
        {
            return LocalDate.now().withDayOfYear(generateDayOfYear());
        }
        public static int generateDayOfYear()
        {
           Random random=new Random();
           return random.nextInt(364);
        }
        public int getDaysInCurrentWeek(LocalDate local)
        {
           DayOfWeek currentDay=local.getDayOfWeek();
           String days[]={"MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY","SUNDAY"};
           for(int i=0;i<days.length;i++)
               if(days[i].equalsIgnoreCase(currentDay+""))
                   return i+1;
            return -1;
        }
        public int getYearDay(LocalDate local)
        {
            return local.getDayOfYear();
        }
        public String getWeekActivities(LocalDate local,int day)
        {
            int dayOfYear=local.getDayOfYear();
            int dayOfWeek=getDaysInCurrentWeek(local);
            dayOfYear=dayOfYear-dayOfWeek+day;
            String activity="";
            if(dayOfYear>0 && dayOfYear<365)
            {
            activity="Run Activities of Current Week\n";
            for(int i=dayOfYear;(i<runList.size() && i<dayOfYear+7);i++)
            {
                activity+= "\nSport Title: " + runList.get(i).getTitle()+
			    "\nNotes: " + runList.get(i).getNotes() +
                            "\nMinutes: " + runList.get(i).getMinutes() + " mins" +
	 		    "\nDistance " + runList.get(i).getDistance() + " miles\n";
            }
            activity+="\nBike Activities of Current Week\n";
            for(int i=dayOfYear;(i<bikeList.size() && i<dayOfYear+7);i++)
            {
                activity+="\nBike: " + bikeList.get(i).getTitle() +
                          "\nNotes: " + bikeList.get(i).getNotes() +
			  "\nCalories: " + bikeList.get(i).getCaloriesBurned() +
                          "\nMinutes: " + bikeList.get(i).getMinutes() + " mins" +
			  "\nDistance: " + bikeList.get(i).getDistance() + " miles" +
                          "\nLocation: " + bikeList.get(i).getLocation()+"\n";
            }
            activity+="\nSwim Activities of Current Week\n";
            for(int i=dayOfYear;(i<swimList.size() && i<dayOfYear+7);i++)
            {
                activity+="\nSwim: " + swimList.get(i).getTitle()+
			"\nNotes: " + swimList.get(i).getNotes() +
			 "\nCalories: " + swimList.get(i).getCaloriesBurned()+
                        "\nDistance: " + swimList.get(i).getDistance()+ " miles" +
			 "\nLaps: " + swimList.get(i).getLaps() +
                        "\nStroke: " + swimList.get(i).getStroke()+"\n";
            }
            activity+="\nSport Activities of Current Week\n";
            for(int i=dayOfYear;(i<sportList.size() && i<dayOfYear+7);i++)
            {
                activity+="\nSport Title: " + sportList.get(i).getTitle() +
                           "\nNotes: " + sportList.get(i).getNotes() +
			   "\nMinutes: " + sportList.get(i).getMinutes()+ " mins" +
                           "\nDistance " + sportList.get(i).getDistance() + " miles\n";
            }
            activity+="\nDaily Step Activities of Current Week\n";
            for(int i=dayOfYear;(i<dailyStepsList.size() && i<dayOfYear+7);i++)
            {
                activity+="\nDaily Steps: " + dailyStepsList.get(i).getNumberOfSteps();
            }
            }
            return activity;
        }
}
