


public class MetricDate extends JulianDate {
	int metricDate;
	long myJulianDate;
	
//	public Date gregorianDate(int day, int month, int year) {
//		return super.gregorianDate(day,month,year);
//	}
	
	public long convertGregoriantoJulian() {
		return super.convertGregoriantoJulian();
	}
	
	public double convertFromJulianToMetric(long myJulianDate){
	//convert a julian date to a metric date
		int MetricMulti = (int)(myJulianDate/365);
		metricDate += MetricMulti*635;
		return (double)metricDate;
	}
	
	public long convertFromMetricToJulian(int metricDate){
		//convert a metric date to a julian date
		long myJulianDate = metricDate/1000;
		myJulianDate = myJulianDate*365;
		return myJulianDate;
	}
	
	public void printMetricAge(){
		System.out.println("Die Umrechnung vom JulianDate in unserer metrisches System ist "+ metricDate);
	}
}
