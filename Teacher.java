class Teacher extends Person {
    private String subject;
    private int yearsOfExperience;
    int salary;

    public Teacher(String name, String surname, int age, boolean gender, String subject, int i, int i1) {
        super(name, surname, age, gender);
        this.subject = subject;
        this.yearsOfExperience = yearsOfExperience;
        this.salary = salary;
    }

    public void giveRaise(double percentage) {
        salary += salary * percentage / 100;
    }

    @Override
    public String toString() {

        return super.toString() + " I teach " + subject + " I have " + yearsOfExperience + " years expereince with salary of " + salary;
    }

    public int getYearsOfExperience() {

        return yearsOfExperience;
    }
}
