
package com.mycompany.chargeable;


public class PilatesClass extends FitnessClass {
    private boolean reformerUsed;
    private double equipmentFee;

    // Empty Constructor مع القيم الافتراضية
    public PilatesClass() {
        super();
        setReformerUsed(true);
        setEquipmentFee(20.0);
    }

    // Full Constructor مع استخدام الـ Setters
    public PilatesClass(int CLASS_ID, String className, String instructorName, double pricePerSession, int capacity, int enrolledCount, boolean reformerUsed, double equipmentFee) {
        super(CLASS_ID, className, instructorName, pricePerSession, capacity, enrolledCount);
        setReformerUsed(reformerUsed);
        setEquipmentFee(equipmentFee);
    }

    // Setters مع التحقق
    public void setReformerUsed(boolean reformerUsed) {
        this.reformerUsed = reformerUsed;
    }

    public void setEquipmentFee(double equipmentFee) {
        if (equipmentFee < 0) {
            throw new IllegalArgumentException("EquipmentFee cannot be negative.");
        }
        this.equipmentFee = equipmentFee;
    }

    public boolean isReformerUsed() { return reformerUsed; }
    public double getEquipmentFee() { return equipmentFee; }

    // الدوال الموجودة في الـ UML لـ PilatesClass[span_9](start_span)[span_9](end_span)
    @Override
    public double calcPrice(int sessions) {
        if (sessions <= 0) {
            throw new IllegalArgumentException("Sessions must be greater than zero.");
        }
        double total = (getPricePerSession() * sessions) + (reformerUsed ? equipmentFee : 0);
        return total + (total * VAT);
    }

    @Override
    public int getMaxSessions() {
        return 12;
    }

    @Override
    public String describeFeatures() {
        return "PilatesClass [reformerUsed=" + reformerUsed + ", equipmentFee=" + equipmentFee + "]";
    }

    @Override
    public String toString() {
        return super.toString() + ", " + describeFeatures();
    }
}