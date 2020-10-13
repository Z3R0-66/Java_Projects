package com.jars.notepad;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AR
 */
class CounterTest extends Thread
{
	private static int id;
	private static Object key=new Object();
	private static int counter;
	public CounterTest(int i)
	{
		id=i;
	}
	public void run()
	{
		incrementCounter();
	}
	public static void incrementCounter()
	{
		System.out.println("Thread "+id+" started -> counter= "+counter);
		synchronized(new Object())
		{
			for(int i=0;i<1000000;i++)
			{
				counter++;
			}
		}
		System.out.println("Thread "+ id + " finished -> counter = "+counter);
	}
	public static void main(String args[])
	{
		final int n=2;
		counter=0;
		CounterTest[] thread=new CounterTest[n];
		for(int i=0;i<n;i++)
		{
			thread[i]=new CounterTest(i+1);
			thread[i].start();
		}
	}
}