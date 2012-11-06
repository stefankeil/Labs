import java.util.Date;

public class JulianDate {

	int day = 6;
	int month = 11;
	int year = 2012;
	int hours;
	int minutes;
	int seconds;
	long julianDate;
	long julianTime;

	public int getDay() {
		return day;
	}


	public void setDay(int day) {
		this.day = day;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public int getHours() {
		return hours;
	}


	public void setHours(int hours) {
		this.hours = hours;
	}


	public int getMinutes() {
		return minutes;
	}


	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}


	public int getSeconds() {
		return seconds;
	}


	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}


	public long getJulianDate() {
		return julianDate;
	}


	public void setJulianDate(long julianDate) {
		this.julianDate = julianDate;
	}


	public long getJulianTime() {
		return julianTime;
	}


	public void setJulianTime(long julianTime) {
		this.julianTime = julianTime;
	}
	
	public boolean isEqual(int date1, int date2){
		if (date1 == date2){
			return true;
		}else {
			return false;
		}
	}
	
	public Date gregorianDate (int day, int month, int year) {
		return gregorianDate(day, month, year);
	}
	
	public long getDaysBetween (long date1, long date2){
		long between = date2 - date1;
		return between;
	}
	
	public long getTomorrow (long date){
		long tomorrow = date + 1;
		return tomorrow;
	}
	
	public long getYesterday (long date){
		long yesterday = date - 1;
		return yesterday;
	}
	
	public long convertGregoriantoJulian(){
		double y = getYear() + (getMonth() - 2.85) / 12;
		double a = (int)(367 * y) - 1.75 * (int)(y) + getDay();
		double b = (int)(a) - 0.75 * (int)(y/100);
		long jd = (int)(b) + 1721115;
		System.out.println(jd);
		return jd;
	}
}
