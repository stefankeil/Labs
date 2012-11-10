

public class MetricDate extends JulianDate {
	int metricDate;
	long myJulianDate;
	int metricYear;
	int metricMonth;
	int metricDay;
	int muduloRest;
	long metricAge;

	public long convertGregoriantoJulian() {
		return super.convertGregoriantoJulian();
	}

	public void convertFromJulianToMetric(long myJulianDate) {
		// convert a julian date to a metric date
		metricYear = (int) (myJulianDate / 1000);
		int moduloRest = (int) (myJulianDate % 1000);
		if (moduloRest != 0) {
			metricMonth = (int) (moduloRest / 100);
			metricDay = (int) (moduloRest % 100);
		}
	}

	public long convertFromMetricToJulian(int metricYear,int metricMonth,int metricDay) {
		// convert a metric date to a julian date
		long myJulianDate = metricDay + metricMonth*100 + metricYear*1000;
		return myJulianDate;
	}
	
	public long getMetricAge (long date1, long date2){
			long between = (date2 - date1);
			metricAge = between/1000;
			return metricAge;
	} 

	public void printMetricAge() {
		System.out.println("Sie sind "+metricAge+" Jahre im metrischen System alt.");
						
	}
}
