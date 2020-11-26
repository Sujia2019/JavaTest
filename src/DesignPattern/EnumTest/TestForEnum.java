package DesignPattern.EnumTest;

public class TestForEnum {
    private Day day;

    public enum Day {
        Monday("monday"), TuesDay("tuesday");

        Day(String day) {
        }
    }

    public String getDay() {
        return this.day.name();
    }

    public void setDay() {

    }

    public static void main(String[] args) {
        TestForEnum test = new TestForEnum();

        System.out.println(test.getDay());
    }
}
