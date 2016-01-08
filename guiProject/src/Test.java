import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Test {

	public static void main(String args[]) throws ParseException{
		String str = "03 -JAN-2016";
		SimpleDateFormat format = new SimpleDateFormat("dd-mmm-yyyy");
		long date = Date.parse(str);
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date);
		System.out.println(cal.getTime());
		
	}
}
