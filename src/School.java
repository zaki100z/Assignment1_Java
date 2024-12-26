import java.util.ArrayList;
import java.util.List;

class School {
    private List<Person> members;

    public School() {

        this.members = new ArrayList<>();
    }

    public void addMember(Person person) {
        members.add(person);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("School Members:\n");
        for (Person member : members) {
            sb.append(member.toString()).append("\n");
        }
        return sb.toString();
    }
}