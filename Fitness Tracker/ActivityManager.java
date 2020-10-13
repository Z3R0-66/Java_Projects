/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ActivityManager {
	public static ArrayList<DailySteps> readSteps(String fileName){
		ArrayList<DailySteps> dailyStepsList = new ArrayList<DailySteps>();
		int numOfValid = 0;
		int numOfInvalid = 0;
		try {
			Scanner s = new Scanner(new File(fileName+"steps.txt"));
			while(s.hasNextLine()) {
				String line = s.nextLine();
				String[] lineParts = line.split("@@");
				if(lineParts.length == 2) {
					try {
						int dayOfYear = Integer.parseInt(lineParts[0]);
						int numberOfSteps = Integer.parseInt(lineParts[1]);
						DailySteps ds = new DailySteps(dayOfYear, numberOfSteps);
						dailyStepsList.add(ds);
						numOfValid += 1;
					} catch(NumberFormatException nfe) {
						numOfInvalid +=1;
					}
				} else {
					numOfInvalid += 1;
				}
			}	
			System.out.println("Adding " + numOfValid + " daily steps activities");
			System.out.println("Ignoring " + numOfInvalid + " invalid daily steps activites");
			s.close();
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return dailyStepsList;
	}
	
	public static ArrayList<Run> readRuns(String fileName){
		ArrayList<Run> runList = new ArrayList<Run>();
		
		int numOfValid = 0;
		int numOfInvalid = 0;
		
		try {
			Scanner s = new Scanner(new File(fileName+"run.txt"));
			while(s.hasNextLine()){
				String line = s.nextLine();
				String[] lineParts = line.split("@@");
				if(lineParts.length == 6) {
					try {
						int dayOfYear = Integer.parseInt(lineParts[0]);
						String title = lineParts[1];
						int caloriesBurned = Integer.parseInt(lineParts[3]);
						int minutes = Integer.parseInt(lineParts[4]);
						if(!title.trim().equals("")) {
							Run r = new Run(dayOfYear, title, lineParts[2], caloriesBurned, minutes, Double.parseDouble(lineParts[5]));
							runList.add(r);
							numOfValid += 1;
						} else {
							numOfInvalid += 1;
						}
					
					} catch (NumberFormatException nfe) {
						numOfInvalid += 1;
					}
				} else {
					numOfInvalid += 1;
				}
			}
			System.out.println("Adding " + numOfValid + " run activities");
			System.out.println("Ignoring " + numOfInvalid + " invalid run activities.");
			s.close();
		} catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		return runList;
	}
	
	public static ArrayList<Swim> readSwims(String fileName){
		ArrayList<Swim> swimList = new ArrayList<Swim>();
		
		int numOfValid = 0;
		int numOfInvalid = 0;
		
		try {
			Scanner s = new Scanner(new File(fileName+"swim.txt"));
			while(s.hasNextLine()) {
				String line = s.nextLine();
				String[] lineParts = line.split("@@");
				if(lineParts.length == 8) {
					try {
						int dayOfYear = Integer.parseInt(lineParts[0]);
						String title = lineParts[1];
						int caloriesBurned = Integer.parseInt(lineParts[3]);
						double distance = Double.parseDouble(lineParts[4]);
						int laps = Integer.parseInt(lineParts[5]);
						String stroke = lineParts[6];
						if(!title.trim().equals("")) {
							Swim sw = new Swim(dayOfYear, title, lineParts[2], caloriesBurned, distance, laps, stroke, Integer.parseInt(lineParts[7]));
							swimList.add(sw);
							numOfValid += 1;
						} else {
							numOfInvalid += 1;
						}
					} catch(NumberFormatException nfe) {
						numOfInvalid += 1;
					}
				} else {
				numOfInvalid += 1;
				}
			}
			System.out.println("Adding " + numOfValid + " swim activities.");
			System.out.println("Ignoring " + numOfInvalid + " invalid swim activities");
			s.close();
		} catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return swimList;
	}
	
	public static ArrayList<Bike> readBike(String fileName){
		ArrayList<Bike> bikeList = new ArrayList<Bike>();
		int numOfValid = 0;
		int numOfInvalid = 0;
		
		try {
			Scanner s = new Scanner(new File(fileName+"bike.txt"));
			while(s.hasNextLine()) {
				String line = s.nextLine();
				String[] lineParts = line.split("@@");
				if (lineParts.length == 7) {
					try {
						int dayOfYear = Integer.parseInt(lineParts[0]);
						String title = lineParts[1];
						int caloriesBurned = Integer.parseInt(lineParts[3]);
						int minutes = Integer.parseInt(lineParts[4]);
						String location = lineParts[6];
						if(!title.trim().equals("")) {
							Bike b = new Bike(dayOfYear, title, lineParts[2], caloriesBurned, minutes, Double.parseDouble(lineParts[5]), location);
							bikeList.add(b);
							numOfValid += 1;
						} else {
							numOfInvalid += 1;
						}
					} catch (NumberFormatException nfe) {
						numOfInvalid += 1;
					}
				} else {
					numOfInvalid += 1;
				}
			}
			System.out.println("Adding " + numOfValid + " biking activities.");
			System.out.println("Ignoring " + numOfInvalid + " invalid biking activities.");
			s.close();
		} catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return bikeList;
	}
	
	public static ArrayList<Sport> readSport(String fileName){
		ArrayList<Sport> sportList = new ArrayList<Sport>();
		int numOfValid = 0;
		int numOfInvalid = 0;
		
		try {
			Scanner s = new Scanner(new File(fileName+"sport.txt"));
			while(s.hasNextLine()) {
				String line = s.nextLine();
				String[] lineParts = line.split("@@");
				if(lineParts.length == 6) {
					try{ 
						int dayOfYear = Integer.parseInt(lineParts[0]);
						String title = lineParts[1];
						int minutes = Integer.parseInt(lineParts[3]);
						int distance = Integer.parseInt(lineParts[4]);
						if(!title.trim().equals("")) {
							Sport sp = new Sport(dayOfYear, title, lineParts[2], minutes, distance, Integer.parseInt(lineParts[5]));
							sportList.add(sp);
							numOfInvalid += 1;
						} else {
							numOfInvalid += 1;
						}
					} catch(NumberFormatException nfe) {
						numOfInvalid += 1;
					}
				} else {
					numOfInvalid += 1;
				}
			}
			System.out.println("Adding " + numOfValid + " sport activities.");
			System.out.println("Ignoring " + numOfInvalid + " invalid sport activities");
			s.close();
		} catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return sportList;
	}
	
}
