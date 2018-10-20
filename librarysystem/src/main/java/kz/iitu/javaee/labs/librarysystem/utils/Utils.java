package kz.iitu.javaee.labs.librarysystem.utils;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;

import javax.xml.bind.DatatypeConverter;

public class Utils {
	
	@SuppressWarnings("restriction")
	public static String getMD5Hash(String input) {
		
		try {
		    MessageDigest md = MessageDigest.getInstance("MD5");
		    md.update(input.getBytes());
		    byte[] digest = md.digest();
		    String hashed = DatatypeConverter.printHexBinary(digest).toLowerCase();
		    return hashed;
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	    
	}
	
	public static boolean parseStringToInteger(String number) {
		  try {
		    Integer.parseInt(number);
		    return true;
		  } catch (NumberFormatException e) {
		    return false;
		  }
		}
	
	public static String formatTimestamp(Timestamp timestamp) {
		return new SimpleDateFormat("HH:mm dd.MM.yyyy").format(timestamp);
	}
	
	public static String formatTimestamp2(Timestamp timestamp) {
		return new SimpleDateFormat("dd MMMM yyyy HH:mm", new Locale("ru")).format(timestamp);
	}
	
	public static Timestamp dateTimestampFromString(String str) {
		DateFormat fmt = new SimpleDateFormat("dd MMMM yyyy", new Locale("ru"));
		try {
			return new Timestamp(fmt.parse(str).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static String changeDateFormat(String str) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy HH:mm");
		Date d = sdf.parse(str);
		sdf.applyPattern("dd MMMM yyyy HH:mm");
		return sdf.format(d);
	}
	
	public static Timestamp dateTimeTimestampFromString(String str) {
		DateFormat fmt = new SimpleDateFormat("dd MMMM yyyy HH:mm", new Locale("ru"));
		try {
			return new Timestamp(fmt.parse(str).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static final String SESSION_USER = "sessionUser";
	public static final String SESSION_LAST_LOGIN = "sessionLastLogin";
	
	public static String addZeros(String str, int digits) {
		while (str.length() < digits) str = "0" + str;
		return str;
	}
	
	public static String getLeftDateString(Timestamp till, Timestamp current) {
		int totalSeconds = (int)((till.getTime() - current.getTime()) / 1000);
		System.out.println(totalSeconds);
		int days = totalSeconds / (3600 * 24);
		totalSeconds -= days * 3600 * 24;
		int hours = totalSeconds / 3600;
		totalSeconds -= hours * 3600;
		int minutes = totalSeconds / 60;
		totalSeconds -= minutes * 60;
		int seconds = totalSeconds;
		String daysStr = days + " days";

		return daysStr + " " + addZeros(hours + "", 2) + ":" + addZeros(minutes + "", 2) + ":" + addZeros(seconds + "", 2);
		
	}
	
	public static String formatCurrency(long value) {
		DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
		DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();

		symbols.setGroupingSeparator(' ');
		formatter.setDecimalFormatSymbols(symbols);
		return formatter.format(value);
	}
	public static String formatCurrencyTenge(long value) {
		DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
		DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();

		symbols.setGroupingSeparator(' ');
		formatter.setDecimalFormatSymbols(symbols);
		return formatter.format(value)+" ₸";
	}
	
	public static String stripString(String str, int maxLength) {
		if (str != null && str.length() > maxLength) {
			String shortStr = "";
			String[] words = str.split(" ");
			int i = 0;
			while (shortStr.length() < maxLength && i < words.length) {
				if (i > 0) shortStr += " ";
				shortStr += words[i];
				i++;
			}
			return shortStr + "...";
		} else {
			return str;
		}
	}
	
	public static String getFilePath(int fileId) {
		String path = "C:/Users/User/workspace_/tendermanager/files/" ; 
		
		if (!new File(path).isDirectory()) path = "D:/Work/tm/";
		if (!new File(path).isDirectory()) path = "/tmp/tm_files/";
		
		return path + fileId + ".file";
		
	}
	
	public static final int TIMER_WARN_DAYS = 5;
	public static final int TIMER_DANGER_DAYS = 1;
	


}






