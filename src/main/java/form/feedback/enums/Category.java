package form.feedback.enums;

import java.util.List;

public enum Category {
    PATIENTS_PORTAL("11", "Patients portal"),
    DOCTORS_PORTAL("18", "Doctors portal"),
    REGISTRATION("6", "Registration"),
    VIRTUAL_VISIT("17", "Virtual visit"),
    OPEN_KM("23", "OpenKM"),
    MICROSOFT_SHAREPOINT("29", "Microsoft SharePoint");

    private final String index;
    private final String name;

    // enum constructor
    private Category(String index, String name)
    {
        this.index = index;
        this.name = name;
    }

    // getter for index
    public String getIndex()
    {
        return this.index;
    }

    // getter for name
    public String getName()
    {
        return this.name;
    }

}
