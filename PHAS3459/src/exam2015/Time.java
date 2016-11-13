package exam2015;

public class Time {
	public int Hour;
	public int Minute;
	public double Second;
	
	Time(int hh, int mm, double seconds){
		Hour = hh;
		Minute = mm;
		Second = seconds;
	}
	
	int getHour(){
		return Hour;
	}
	
	int getMinute(){
		return Minute;
	}
	
	public String toString(){
		return "time (hh/mm/ss.sss): "+Hour+"/"+Minute+"/"+Second;
	}
	
	double getSecond(){
		return Second;
	}
}
