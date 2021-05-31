package meli.ejerc;

public class Timer
{
	private long initTime;
	private long endTime;
	public void start()
	{
		initTime = System.currentTimeMillis();
	}
	
	public void stop()
	{
		endTime = System.currentTimeMillis();
	}
	
	public String elapsedTime()
	{
		long diff = endTime-initTime;
		return Long.toString(diff/1000)+" segundos";
	}
	
}
