import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class weeklyCalendarHandlerSignUp implements ActionListener {
	public weeklyCalendarHandlerSignUp() {
		
	}
	
	public void actionPerformed(ActionEvent eve) {
		
		JFrame frm = new JFrame();

        ArrayList<CalendarEvent> events = new ArrayList<>();
        //Get list of appointments given user id, and then show them on the calendar
        int id = CreatenewUser.getId();
        events = databaseAction.getAllAppointments(id);
        /*
        events.add(new CalendarEvent(LocalDate.of(2016, 11, 11), LocalTime.of(14, 0), LocalTime.of(14, 20), "Test 11/11 14:00-14:20"));
        events.add(new CalendarEvent(LocalDate.of(2016, 11, 14), LocalTime.of(9, 0), LocalTime.of(9, 20), "Test 14/11 9:00-9:20"));
        events.add(new CalendarEvent(LocalDate.of(2016, 11, 15), LocalTime.of(12, 0), LocalTime.of(13, 20), "Test 15/11 12:00-13:20"));
        events.add(new CalendarEvent(LocalDate.of(2016, 11, 16), LocalTime.of(9, 0), LocalTime.of(9, 20), "Test 16/11 9:00-9:20"));
        events.add(new CalendarEvent(LocalDate.of(2016, 11, 17), LocalTime.of(12, 15), LocalTime.of(14, 20), "Test 17/11 12:15-14:20"));
        events.add(new CalendarEvent(LocalDate.of(2016, 11, 18), LocalTime.of(9, 30), LocalTime.of(10, 00), "Test 18/11 9:30-10:00"));
        events.add(new CalendarEvent(LocalDate.of(2016, 11, 18), LocalTime.of(16, 00), LocalTime.of(16, 45), "Test 18/11 16:00-16:45"));
        */
        //events.add(new CalendarEvent(LocalDate.of(2018, 10, 22), LocalTime.of(16, 00), LocalTime.of(16, 45), "Test 18/11 16:00-16:45", Color.CYAN));

        //events.add(new CalendarEvent(LocalDate.of(2018, 10, 22), LocalTime.of(14, 00), LocalTime.of(14, 45), "Test 18/11 16:00-16:45", Color.PINK));
        
        //events.add(new CalendarEvent(LocalDate.of(2018, 10, 23), LocalTime.of(14, 00), LocalTime.of(14, 45), "Test 18/11 16:00-16:45", Color.GREEN));
        
        //events.add(new CalendarEvent(LocalDate.of(2018, 10, 27), LocalTime.of(14, 00), LocalTime.of(14, 45), "Test 18/11 16:00-16:45", Color.GREEN));
        
        WeekCalendar cal = new WeekCalendar(events);

        cal.addCalendarEventClickListener(e -> System.out.println(e.getCalendarEvent()));
        cal.addCalendarEmptyClickListener(e -> {
            System.out.println(e.getDateTime());
            System.out.println(Calendar.roundTime(e.getDateTime().toLocalTime(), 30));
        });

        JButton goToTodayBtn = new JButton("Today");
        goToTodayBtn.addActionListener(e -> cal.goToToday());

        JButton nextWeekBtn = new JButton(">");
        nextWeekBtn.addActionListener(e -> cal.nextWeek());

        JButton prevWeekBtn = new JButton("<");
        prevWeekBtn.addActionListener(e -> cal.prevWeek());

        JButton nextMonthBtn = new JButton(">>");
        nextMonthBtn.addActionListener(e -> cal.nextMonth());

        JButton prevMonthBtn = new JButton("<<");
        prevMonthBtn.addActionListener(e -> cal.prevMonth());

        JPanel weekControls = new JPanel();
        weekControls.add(prevMonthBtn);
        weekControls.add(prevWeekBtn);
        weekControls.add(goToTodayBtn);
        weekControls.add(nextWeekBtn);
        weekControls.add(nextMonthBtn);

        frm.add(weekControls, BorderLayout.NORTH);

        frm.add(cal, BorderLayout.CENTER);
        frm.setSize(1000, 900);
        frm.setVisible(true);
        frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
