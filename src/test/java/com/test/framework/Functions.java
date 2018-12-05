package com.test.framework;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Functions {
	 public static String getTimeStamp(String dateFormat) {
		    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
		    String date = simpleDateFormat.format(new Date());
		    return date;
		  }
}
