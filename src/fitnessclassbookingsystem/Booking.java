
package fitnessclassbookingsystem;

public class Booking implements Chargeable {

    public static final String STATUS_ACTIVE = "Active";
    public static final String STATUS_CANCELLED = "Cancelled";

    private static int count = 0;

    private int BOOKING_ID;
    private int sessions;
    private String status;
    private Member member;
    private FitnessClass fitnessClass;

    public Booking() {
        this.BOOKING_ID = generateId();
        this.sessions = 1;
        this.status = STATUS_ACTIVE;
        this.member = null;
        this.fitnessClass = null;
    }

    public Booking(Member member, FitnessClass fitnessClass, int sessions) {
        this.BOOKING_ID = generateId();
        setMember(member);
        setFitnessClass(fitnessClass);
        setSessions(sessions);
        this.status = STATUS_ACTIVE;
    }

    public Booking(Member member, FitnessClass fitnessClass, int sessions, String status) {
        this(member, fitnessClass, sessions);
        setStatus(status);
    }

    public int generateId() {
        count++;
        return count;
    }

    public int getBookingId() {
        return BOOKING_ID;
    }

    public int getSessions() {
        return sessions;
    }

    public void setSessions(int sessions) {
        if (sessions <= 0) {
            throw new IllegalArgumentException("Number of sessions must be greater than zero.");
        }
        if (fitnessClass != null && sessions > fitnessClass.getMaxSessions()) {
            throw new IllegalArgumentException("Sessions cannot exceed the maximum of "
                    + fitnessClass.getMaxSessions() + " for this class.");
        }
        this.sessions = sessions;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status == null) {
            throw new IllegalArgumentException("Status cannot be empty.");
        }
        if (status.equalsIgnoreCase(STATUS_ACTIVE)) {
            this.status = STATUS_ACTIVE;
        } else if (status.equalsIgnoreCase(STATUS_CANCELLED)) {
            this.status = STATUS_CANCELLED;
        } else {
            throw new IllegalArgumentException("Status must be Active or Cancelled.");
        }
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        if (member == null) {
            throw new IllegalArgumentException("A booking must have a member.");
        }
        this.member = member;
    }

    public FitnessClass getFitnessClass() {
        return fitnessClass;
    }

    public void setFitnessClass(FitnessClass fitnessClass) {
        if (fitnessClass == null) {
            throw new IllegalArgumentException("A booking must have a fitness class.");
        }
        this.fitnessClass = fitnessClass;
    }

    public static int getCount() {
        return count;
    }

    public boolean isActive() {
        return STATUS_ACTIVE.equals(status);
    }

    @Override
    public double calculatePrice(int sessions) {
        if (sessions <= 0) {
            throw new IllegalArgumentException("Number of sessions must be greater than zero.");
        }
        if (fitnessClass == null) {
            throw new IllegalStateException("No fitness class is linked to this booking.");
        }
        return fitnessClass.calculatePrice(sessions);
    }

    public String getReceipt() {
        return "===== Booking Receipt =====\n"
                + "Booking ID : " + BOOKING_ID + "\n"
                + "Member     : " + member.getName() + "\n"
                + "Class      : " + fitnessClass.getClassName() + "\n"
                + "Sessions   : " + sessions + "\n"
                + "Status     : " + status + "\n"
                + String.format("Total Price : %.2f SAR", calculatePrice(sessions)) + "\n"
                + "===========================";
    }

    @Override
    public String toString() {
        return "Booking ID: " + BOOKING_ID
                + ", Member: " + (member == null ? "N/A" : member.getName())
                + ", Class: " + (fitnessClass == null ? "N/A" : fitnessClass.getClassName())
                + ", Sessions: " + sessions
                + ", Status: " + status
                + (fitnessClass == null ? "" : String.format(", Price: %.2f", calculatePrice(sessions)));
    }
}