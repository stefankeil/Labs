import java.util.Calendar;
import java.util.GregorianCalendar;

public class Birthday extends JulianDate {

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

	public long convertGregoriantoJulian() {
		return super.convertGregoriantoJulian();
	}

	public long printGregorianCalendarDate() {
		Birthday now = new Birthday();
		GregorianCalendar nowDate = new GregorianCalendar();
		now.year = nowDate.get(Calendar.YEAR);
		now.month = nowDate.get(Calendar.MONTH) + 1;
		now.day = nowDate.get(Calendar.DAY_OF_MONTH);
		long date = now.convertGregoriantoJulian();
		return date;
	}

	public int actualDay() {
		Birthday now = new Birthday();
		GregorianCalendar nowDate = new GregorianCalendar();
		now.day = nowDate.get(Calendar.DAY_OF_MONTH);
		return now.day;
	}

	public int actualMonth() {
		Birthday now = new Birthday();
		GregorianCalendar nowDate = new GregorianCalendar();
		now.month = nowDate.get(Calendar.MONTH) + 1;
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
