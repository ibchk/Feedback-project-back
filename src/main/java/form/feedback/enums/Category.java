package form.feedback.enums;

public enum Category {
    PATIENTS_PORTAL("11"),
    DOCTORS_PORTAL("18"),
    REGISTRATION("6"),
    VIRTUAL_VISIT("17"),
    OPEN_KM("23"),
    MICROSOFT_SHAREPOINT("29");

    private String value;

    // getter method
    public String getValue()
    {
        return this.value;
    }

    // enum constructor - cannot be public or protected
    private Category(String value)
    {
        this.value = value;
    }

}
