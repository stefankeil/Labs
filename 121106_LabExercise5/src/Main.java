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
			
			JulianDate test = new JulianDate();
			MetricDate test2 = new MetricDate();

			test.day = day;
			test.month = month;
			test.year = year;
			test2.day = day;
			test2.month = month;
			test2.year = year;
			test.printGregorianCalendarDate();
			test.getDaysBetween(test.convertGregoriantoJulian(), test.printGregorianCalendarDate());
			test.isEqual(test.day, test.actualDay(), test.month, test.actualMonth());
			test.getWeekDay(test.convertGregoriantoJulian());
			long julian = test2.convertGregoriantoJulian();
			test2.convertFromJulianToMetric(julian);
			test2.printMetricAge();
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
