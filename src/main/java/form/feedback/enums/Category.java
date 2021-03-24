package form.feedback.enums;

public enum Category {
    PATIENTS_PORTAL("11", "Patients portal"),
    DOCTORS_PORTAL("18", "Doctors portal"),
    REGISTRATION("6", "Registration"),
    VIRTUAL_VISIT("17", "Virtual visit"),
    OPEN_KM("23", "OpenKM"),
    MICROSOFT_SHAREPOINT("29", "Microsoft SharePoint");

    /**
     * Indexes are used in front as values for categories.
     */
    private final String index;

    /**
     * Name is that the client see.
     */
    private final String name;

    // enum constructor
    private Category(String index, String name) {
        this.index = index;
        this.name = name;
    }

    // getter for index
    public String getIndex() {
        return this.index;
    }

    // getter for name
    public String getName() {
        return this.name;
    }

}
