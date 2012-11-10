

public abstract class JulianDate {

	int day;
	int month;
	int year;
	int between;
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

	protected long convertGregoriantoJulian() {
		double y = getYear() + (getMonth() - 2.85) / 12;
		double a = (int) (367 * y) - 1.75 * (int) (y) + getDay();
		double b = (int) (a) - 0.75 * (int) (y / 100);
		long jd = (int) (b) + 1721115;
		return jd;
	}
	public long getDaysBetween(long date1, long date2) {
		
		return between;
	}
}
