package fitnessclassbookingsystem;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class AttendanceLog {

    private Member member;
    private String startDate;
    private int sessions;

    public AttendanceLog() {
        this(new Member(), "2000-01-01", 1);
    }

    public AttendanceLog(Member member, String startDate, int sessions) {
        setMember(member);
        setStartDate(startDate);
        setSessions(sessions);
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        if (member == null) {
            throw new IllegalArgumentException("Member is required.");
        }
        this.member = member;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        if (startDate == null || startDate.trim().isEmpty()) {
            throw new IllegalArgumentException("Start date is not identified.");
        }
        String trimmed = startDate.trim();
        try {
            LocalDate.parse(trimmed);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Start date format is wrong. Use yyyy-MM-dd.");
        }
        this.startDate = trimmed;
    }

    public int getSessions() {
        return sessions;
    }

    public void setSessions(int sessions) {
        if (sessions <= 0) {
            throw new IllegalArgumentException("Sessions must be greater than 0.");
        }
        this.sessions = sessions;
    }

    @Override
    public String toString() {
        return "Attendance -> Member: " + member.getName()
                + ", Start Date: " + startDate
                + ", Sessions: " + sessions;
    }
}
