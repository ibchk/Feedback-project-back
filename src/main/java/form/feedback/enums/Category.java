package form.feedback.enums;

public enum Category {
    PATIENTS_PORTAL("11", "Patients portal"),
    DOCTORS_PORTAL("18", "Doctors portal"),
    REGISTRATION("6", "Registration"),
    VIRTUAL_VISIT("17", "Virtual visit"),
    OPEN_KM("23", "OpenKM"),
    MICROSOFT_SHAREPOINT("29", "Microsoft SharePoint");

    private String index;
    private String name;

    // getter method
    public String getIndex()
    {
        return this.index;
    }

    public String getName()
    {
        return this.name;
    }

    // enum constructor - cannot be public or protected
    private Category(String index, String name)
    {
        this.index = index;
        this.name = name;

    }

}
