import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class CalcDateDiffenence {
	public String calcDateDifUnderJava8(String start, String end) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		Date startDate = formatter.parse(start);
		Date endDate = formatter.parse(end);
		int seconds = 1000 * 24 * 60 * 60;
		int dayTerm = (int) ((endDate.getTime() - startDate.getTime()) / seconds);

		Calendar c = Calendar.getInstance();
		c.setTime(startDate);

		int monthTerm = 0;

		while (c.getTime().compareTo(endDate) < 0) {
			int days = c.getActualMaximum(Calendar.DAY_OF_MONTH);

			if (dayTerm < days) {
				break;
			}

			c.add(Calendar.MONTH, 1);
			dayTerm -= days;
			monthTerm++;
		}

		int yearTerm = monthTerm / 12;
		monthTerm %= 12;

		return String.format("%d년 %d개월 %d일", yearTerm, monthTerm, dayTerm);
	}

	public String calcDateDifByPeriod(String start, String end) {
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;

		LocalDate fromDate = LocalDate.parse(start, formatter);
		LocalDate toDate = LocalDate.parse(end, formatter);

		Period period = Period.between(fromDate, toDate);
//		Period period = fromDate.until(toDate);

		int years = period.getYears();
		int months = period.getMonths();
		int days = period.getDays();

		return String.format("%d년 %d개월 %d일", years, months, days);
	}

	public String calcDateDifByLocalDate(String start, String end) {
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;

		LocalDate fromDate = LocalDate.parse(start, formatter);
		LocalDate toDate = LocalDate.parse(end, formatter);

		int monthTerm = (int) ChronoUnit.MONTHS.between(fromDate, toDate);
		LocalDate addMonthTermDate = fromDate.plusMonths(monthTerm);

		if (addMonthTermDate.equals(toDate)) {
			return getDateDifStr(monthTerm, 0);
		}

		if (addMonthTermDate.plusMonths(1).equals(toDate)) {
			return getDateDifStr(monthTerm + 1, 0);
		}

		int days = (int) ChronoUnit.DAYS.between(addMonthTermDate, toDate);

		return getDateDifStr(monthTerm, days);
	}

	private String getDateDifStr(int monthTerm, int days) {
		int years = monthTerm / 12;
		int months = monthTerm % 12;

		return String.format("%d년 %d개월 %d일", years, months, days);
	}
}
