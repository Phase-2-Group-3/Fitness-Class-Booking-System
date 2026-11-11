package fitnessclassbookingsystem;

public abstract class User {

    private int userID;
    private String name;
    private String phone;
    private String email;

    public User() {
        this(1, "Unknown", "0500000000", "unknown@mail.com");
    }

    public User(int userID, String name, String phone, String email) {
        setUserID(userID);
        setName(name);
        setPhone(phone);
        setEmail(email);
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        if (userID <= 0) {
            throw new IllegalArgumentException("User ID must be greater than 0.");
        }
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        String trimmed = name.trim();
        if (trimmed.length() < 2) {
            throw new IllegalArgumentException("Name is too short (minimum 2 characters).");
        }
        if (trimmed.length() > 50) {
            throw new IllegalArgumentException("Name is too long (maximum 50 characters).");
        }
        if (!trimmed.matches("[\\p{L} ]+")) {
            throw new IllegalArgumentException("Name must contain letters only.");
        }
        this.name = trimmed;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be empty.");
        }
        String trimmed = phone.trim();
        if (!trimmed.matches("\\d+")) {
            throw new IllegalArgumentException("Phone number must contain digits only.");
        }
        if (!trimmed.startsWith("05")) {
            throw new IllegalArgumentException("Phone number must start with 05.");
        }
        if (trimmed.length() != 10) {
            throw new IllegalArgumentException("Phone number must be 10 digits.");
        }
        this.phone = trimmed;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty.");
        }
        String trimmed = email.trim();
        if (!trimmed.contains("@") || !trimmed.contains(".")) {
            throw new IllegalArgumentException("Email is invalid (must contain @ and .).");
        }
        this.email = trimmed;
    }

    @Override
    public String toString() {
        return "User ID: " + userID
                + ", Name: " + name
                + ", Phone: " + phone
                + ", Email: " + email;
    }
}
