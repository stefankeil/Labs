import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Geben Sie den Tag an dem Sie geboren sind ein: ");
			int day = Integer.parseInt(in.readLine());
			System.out.println("Geben Sie den Monat an dem Sie geboren sind ein: ");
			int month = Integer.parseInt(in.readLine());
			System.out.println("Geben Sie das Jahr an dem Sie geboren sind ein: ");
			int year = Integer.parseInt(in.readLine());
			
			Birthday birthday = new Birthday();
			MetricDate metric = new MetricDate();

			birthday.day = day;
			birthday.month = month;
			birthday.year = year;
//			test2.day = day;
//			test2.month = month;
//			test2.year = year;
			birthday.printGregorianCalendarDate();
			birthday.getDaysBetween(birthday.convertGregoriantoJulian(), birthday.printGregorianCalendarDate());
			birthday.isEqual(birthday.day, birthday.actualDay(), birthday.month, birthday.actualMonth());
			birthday.getWeekDay(birthday.convertGregoriantoJulian());
			//long julian = test2.convertGregoriantoJulian();
			//test2.convertFromJulianToMetric(julian);
			metric.getMetricAge(birthday.convertGregoriantoJulian(), birthday.printGregorianCalendarDate());
			metric.printMetricAge();
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
