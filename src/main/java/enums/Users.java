package enums;

public enum Users {
    PITER_CHAILOVSKII("PITER CHAILOVSKII", "epam", "1234"),
    KSENIIA_STEPANOVA("name", "login", "55555");

    public String name;
    public String login;
    public String password;

    Users(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }
}
