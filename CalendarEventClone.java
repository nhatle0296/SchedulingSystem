import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
//import java.util.Time;
import java.sql.Timestamp;
public class CalendarEventClone {

    private Color DEFAULT_COLOR = Color.PINK;

    private Date date;
    private Timestamp start;
    private Timestamp end;
    private String text;
    private Color color;

    
    //public CalendarEventClone(Date date, Time start, Time end, String text, int selection) {
        //this(date, start, end, text, Color.PINK);
   // }
    public static void main(String[] args) {
    	Calendar cale = new GregorianCalendar();
	    cale.set(Calendar.YEAR, 2018);
	    cale.set(Calendar.MONTH, 12);
	    cale.set(Calendar.DATE, 20);
	    cale.set(Calendar.HOUR_OF_DAY, 12);
	    cale.set(Calendar.MINUTE, 12);
	    Timestamp start = new Timestamp(cale.getTimeInMillis());
	    
	    cale.set(Calendar.YEAR, 2018);
	    cale.set(Calendar.MONTH, 12);
	    cale.set(Calendar.DATE, 20);
	    cale.set(Calendar.HOUR_OF_DAY, 17);
	    cale.set(Calendar.MINUTE, 12);
	    Timestamp end = new Timestamp(cale.getTimeInMillis());
    	CalendarEventClone c = new CalendarEventClone(start, end, "demo appointment", Color.PINK);
    	System.out.println(c);
    }

    public CalendarEventClone(Timestamp start, Timestamp end, String text, Color color) {
        this.start = start;
        this.end = end;
        //this.end = end;
        this.text = text;
        this.color = color;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String toString() {
        return getDate() + " " + getStart() + "-" + getEnd() + ". " + getText();
    }

    public Color getColor() {
        return color;
    }
    
    public String represent() {
    	return getText();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CalendarEventClone that = (CalendarEventClone) o;

        if (!date.equals(that.date)) return false;
        if (!start.equals(that.start)) return false;
        return end.equals(that.end);

    }

    @Override
    public int hashCode() {
        int result = date.hashCode();
        result = 31 * result + start.hashCode();
        result = 31 * result + end.hashCode();
        return result;
    }
}
