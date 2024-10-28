package Models;
public class Animal {
    protected int id;
    protected String type;

    protected String name;
    protected String birthday;
    protected String commands = ".";

    public Animal(String type, String name, String birthday) {
        this.type = type;
        this.name = name;
        this.birthday = birthday;
    }

    public Animal(String[] args) {
        this.id = Integer.parseInt(args[0]);
        this.type = args[1];
        this.name = args[2];
        this.birthday = args[3];
        this.commands = args[4];
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(int year, int month, int day) {
        this.birthday = String.format("%d-%d-%d", year, month, day);
    }
    public String getCommands() {
        return commands;
    }
    public void setCommands(String command) {
        this.commands = command;
    }
    public void addCommands(String command) {
        this.commands = commands.trim().isEmpty() ? command : String.format("%s, %s", commands, command);
    }
    @Override
    public String toString() {
        return "ID: " + id + "\tType: " + type + "\tName: " + name + "\tBirthday: " + birthday + "\tCommands: "
                + commands;
    }
}
