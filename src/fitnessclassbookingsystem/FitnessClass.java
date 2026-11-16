package com.mycompany.chargeable;

public abstract class FitnessClass implements Chargeable {
    private int CLASS_ID;
    private String className;
    private String instructorName;
    private double pricePerSession;
    private int capacity;
    private int enrolledCount;
    private AttendanceLog[] attendanceLogs;
    private int count;

   
    public FitnessClass() {
        setCLASS_ID(1);
        setClassName("General Class");
        setInstructorName("TBD");
        setPricePerSession(50.0);
        setCapacity(10);
        setEnrolledCount(0);
        this.attendanceLogs = new AttendanceLog[10];
        setCount(0);
    }

    
    public FitnessClass(int CLASS_ID, String className, String instructorName, double pricePerSession, int capacity, int enrolledCount) {
        setCLASS_ID(CLASS_ID);
        setClassName(className);
        setInstructorName(instructorName);
        setPricePerSession(pricePerSession);
        setCapacity(capacity);
        setEnrolledCount(enrolledCount);
        this.attendanceLogs = new AttendanceLog[capacity];
        setCount(0);
    }

   
    public void setCLASS_ID(int CLASS_ID) {
        if (CLASS_ID <= 0) {
            throw new IllegalArgumentException("CLASS_ID must be positive.");
        }
        this.CLASS_ID = CLASS_ID;
    }

    public void setClassName(String className) {
        if (className == null || className.trim().isEmpty()) {
            throw new IllegalArgumentException("ClassName cannot be empty.");
        }
        this.className = className;
    }

    public void setInstructorName(String instructorName) {
        if (instructorName == null || instructorName.trim().isEmpty()) {
            throw new IllegalArgumentException("InstructorName cannot be empty.");
        }
        this.instructorName = instructorName;
    }

    public void setPricePerSession(double pricePerSession) {
        if (pricePerSession < 0) {
            throw new IllegalArgumentException("PricePerSession cannot be negative.");
        }
        this.pricePerSession = pricePerSession;
    }

    public void setCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero.");
        }
        this.capacity = capacity;
    }

    public void setEnrolledCount(int enrolledCount) {
        if (enrolledCount < 0) {
            throw new IllegalArgumentException("EnrolledCount cannot be negative.");
        }
        this.enrolledCount = enrolledCount;
    }

    public void setAttendanceLogs(AttendanceLog[] attendanceLogs) {
        if (attendanceLogs == null) {
            throw new IllegalArgumentException("AttendanceLogs cannot be null.");
        }
        this.attendanceLogs = attendanceLogs;
    }

    public void setCount(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Count cannot be negative.");
        }
        this.count = count;
    }

    // Getters العادية
    public int getCLASS_ID() { return CLASS_ID; }
    public String getClassName() { return className; }
    public String getInstructorName() { return instructorName; }
    public double getPricePerSession() { return pricePerSession; }
    public int getCapacity() { return capacity; }
    public int getEnrolledCount() { return enrolledCount; }
    public AttendanceLog[] getAttendanceLogs() { return attendanceLogs; }
    public int getCount() { return count; }

 
    public boolean isFull() {
        return enrolledCount >= capacity;
    }

    public abstract int getMaxSessions();

    public abstract String describeFeatures();

    @Override
    public String toString() {
        return "FitnessClass [ID=" + CLASS_ID + ", Name=" + className + "]";
    }
}