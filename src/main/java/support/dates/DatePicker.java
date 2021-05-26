package support.dates;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class DatePicker {

    private DatePicker() {
        throw new IllegalStateException("Get some types of the date and time");
    }

    private static DateFormat df = null;
    private static String typeOfFormat = "dd/MM/yyyy HH:mm:ss";

    public static String getTypeOfFormat() {
		return typeOfFormat;
	}

	public static void setTypeOfFormat(String typeOfFormat) {
		DatePicker.typeOfFormat = typeOfFormat;
	}

	/**
     * get current time
     */
    public static String getCurrentTime() {
        df = new SimpleDateFormat(typeOfFormat);
        return df.format(Calendar.getInstance().getTime()).split(" ")[1];
    }

    /**
     * get current date
     */
    public static String getCurrentDate() {
        df = new SimpleDateFormat(typeOfFormat);
        return df.format(Calendar.getInstance().getTime()).split(" ")[0];
    }

    /**
     * get date Up or Down, you can pass parameter int day as negative or positive
     *
     * @param day set day to get date to up or down, can be positive or negative
     */
    public static String getDateUpOrDown(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, day);
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        return dateFormat.format(calendar.getTime());
    }
}
