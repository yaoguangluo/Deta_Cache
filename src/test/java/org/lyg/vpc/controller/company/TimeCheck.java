package org.lyg.vpc.controller.company;
import java.util.Date;
public class TimeCheck{
	public long before;
	public long now;
	public void begin(){
		System.out.println("start: " + (new Date()));
		before = System.currentTimeMillis();
	}
	
	public void end()
	{
		now = System.currentTimeMillis();
	}
	
	public void duration(){
		long du=now-before;
		System.out.println("∫ƒ ±: " + du + " ∫¡√Î");
	}
}