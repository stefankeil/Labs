//Fee
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class JulianDate {

	int day;
	int month;
	int year;
	int hours;
	int minutes;
	int seconds;
	long julianDate;
	long julianTime;
	int dayNow;
	int monthNow;
	int yearNow;
	String[] week = { "Sonntag", "Montag", "Dienstag", "Mittwoch",
			"Donnerstag", "Freitag", "Samstag" };

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

	public boolean isEqual(int day1, int day2, int month1, int month2) {
		if (month1 == month2) {
			if (day1 == day2) {
				System.out.println("Happy Birthday!");
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public Date gregorianDate(int day, int month, int year) {
		return gregorianDate(day, month, year);
	}

	public long getDaysBetween(long date1, long date2) {
		long between = (date2 - date1);
		if (between % 100 == 0) {
			System.out.println("Sie sind " + between
					+ " Tage alt. Und das ist durch 100 teilbar!");
		} else {
			System.out.println("Sie sind " + between + " Tage alt.");
		}
		return between;
	}

	public long getTomorrow(long date) {
		long tomorrow = date + 1;
		return tomorrow;
	}

	public long getYesterday(long date) {
		long yesterday = date - 1;
		return yesterday;
	}

	public long convertGregoriantoJulian() {
		double y = getYear() + (getMonth() - 2.85) / 12;
		double a = (int) (367 * y) - 1.75 * (int) (y) + getDay();
		double b = (int) (a) - 0.75 * (int) (y / 100);
		long jd = (int) (b) + 1721115;
		return jd;
	}

	public long printGregorianCalendarDate() {
		JulianDate now = new JulianDate();
		GregorianCalendar nowDate = new GregorianCalendar();
		now.year = nowDate.get(Calendar.YEAR);
		now.month = nowDate.get(Calendar.MONTH)+1;
		now.day = nowDate.get(Calendar.DAY_OF_MONTH);
		long date = now.convertGregoriantoJulian();
		return date;
	}

	public int actualDay() {
		JulianDate now = new JulianDate();
		GregorianCalendar nowDate = new GregorianCalendar();
		now.day = nowDate.get(Calendar.DAY_OF_MONTH);
		return now.day;
	}

	public int actualMonth() {
		JulianDate now = new JulianDate();
		GregorianCalendar nowDate = new GregorianCalendar();
		now.month = nowDate.get(Calendar.MONTH)+1;
		return now.month;
	}

	public String getWeekDay(long jd) {
		int dayCount = (int) ((jd + 1) % 7);
		String weekDay = week[dayCount];
		if (dayCount == 0) {
			System.out.println("Ihr Geburtstag war an einem " + weekDay
					+ ", Sie sind ein Sonntagskind!");
		} else {
			System.out.println("Ihr Geburtstag war an einem " + weekDay + "!");
		}
		return weekDay;
	}
}
