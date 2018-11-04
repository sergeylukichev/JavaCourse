import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
		LocalDate plusDays = localDate.plusMonths(5).minusDays(5);
		System.out.println(plusDays);
		
		LocalDateTime parse = LocalDateTime
		.parse("2018-02-20 10:15:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE", new Locale("ru"));
		final String month = parse.format(formatter);
		
		System.out.println(month);
		
		System.out.println(parse);
		
		Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
		Iterator<String> iterator = availableZoneIds.iterator();
//		while(iterator.hasNext()) {
//			System.out.println(iterator.next());
//		}
		
		LocalDateTime now = LocalDateTime.now();
		ZoneId irkutsk = ZoneId.of("Asia/Irkutsk");
		ZonedDateTime inIrkutsk = ZonedDateTime.of(now,  irkutsk);
		System.out.println(inIrkutsk);
		
		
		LocalDateTime plusDays2 = now.plusDays(10);
		
		long between = ChronoUnit.DAYS.between(now,  plusDays2);
		System.out.println(between);
		
		List<LocalDate> dates = new LinkedList<>();
		Collections.addAll(dates, 
				LocalDate.now(),
				LocalDate.now().plusDays(10),
				LocalDate.now().plusDays(20),
				LocalDate.now().plusWeeks(6));
		
		System.out.println(daysInBetween(dates));
		
		List<String> stringDates = new LinkedList<>();
		Collections.addAll(stringDates, "03 Jun 2015", "08 Jul 2016", "12 Dez 2013");
		
		System.out.println(getFormattedStrings(stringDates));
	}
	
	public static long daysInBetween(List<LocalDate> dates) {
		
		List<LocalDate> collect = dates.stream().sorted().collect(Collectors.toList());
		
		return ChronoUnit.DAYS.between(collect.get(0), collect.get(collect.size()-1));
	}
	
	
	public static List<String> getFormattedStrings(List<String> dates) {		
		return dates
				.stream()
				.map(s -> createLocalDateFromString(s))
				.sorted()
				.map(d -> createStringFromLocalDate(d))
				.collect(Collectors.toList());
	}
	
	//"03 Jun 2015"
	public static LocalDate createLocalDateFromString(String s) {
		return LocalDate.parse(s, DateTimeFormatter.ofPattern("dd MMM yyyy"));
	}
	
	public static String createStringFromLocalDate(LocalDate d) {
		return d.format(DateTimeFormatter.ofPattern("EEE, dd MMM yyyy", new Locale("en")));
	}
}
