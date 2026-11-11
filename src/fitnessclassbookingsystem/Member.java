package fitnessclassbookingsystem;

public class Member extends User {

    private int MEMBER_ID;
    private String membershipType;

    public Member() {
        this(1, "Unknown", "0500000000", "unknown@mail.com", 1, "Standard");
    }

    public Member(int userID, String name, String phone, String email,
            int memberId, String membershipType) {
        super(userID, name, phone, email);
        setMEMBER_ID(memberId);
        setMembershipType(membershipType);
    }

    public int getMEMBER_ID() {
        return MEMBER_ID;
    }

    public void setMEMBER_ID(int memberId) {
        if (memberId <= 0) {
            throw new IllegalArgumentException("Member ID must be greater than 0.");
        }
        this.MEMBER_ID = memberId;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        if (membershipType == null || membershipType.trim().isEmpty()) {
            throw new IllegalArgumentException("Membership type cannot be empty.");
        }
        String trimmed = membershipType.trim();
        if (!trimmed.equalsIgnoreCase("premium")
                && !trimmed.equalsIgnoreCase("standard")
                && !trimmed.equalsIgnoreCase("student")) {
            throw new IllegalArgumentException(
                    "Invalid membership type. Allowed: premium, standard, student.");
        }
        this.membershipType = trimmed;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Member ID: " + MEMBER_ID
                + ", Membership Type: " + membershipType;
    }
}
