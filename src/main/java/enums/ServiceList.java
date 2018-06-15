package enums;

public enum ServiceList {
    SUPPORT("SUPPORT"),
    DATES("Dates"),
    COMPLEX_TABLE("Complex table"),
    SIMPLE_TABLE("Simple table"),
    USER_TABLE("User table"),
    TABLE_WITH_PAGES("Table with pages"),
    DIFFERENT_ELEMENTS("Different elements"),
    PERFORMANCE("Performance");

    public String option;

    ServiceList(String option) {
        this.option = option;
}
}
