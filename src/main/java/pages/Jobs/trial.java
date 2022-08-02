package pages.Jobs;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.Test;

public class trial {

	@Test

	public void trialTest() {

		drawPattern("PARIMAL");
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd mmm");
//		LocalDateTime now = LocalDateTime.now();
//		String currentDate = dtf.format(now);
//		System.out.println(currentDate);
	}

//	CAT
	public void drawPattern(String s) {
		int i = s.length();
		for (int j = 0; j <= i; j++) {
			for (int k = 0; k < j; k++) {
//				System.out.print(k);
				System.out.print(s.charAt(k));
			}

			System.out.println();
		}
	}

}
