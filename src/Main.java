import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");

        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++){
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)]
            ));
        }

        //количество несовершеннолетних
        long count = persons.stream()
                .filter(e -> e.getAge() < 18)
                .count();

        //список фамилий призывников
        List<String> recruitList = persons.stream()
                .filter(e -> e.getSex() == Sex.MAN)
                .filter(e -> e.getAge() >= 18)
                .filter(e -> e.getAge() < 27)
                .map(Person::getFamily)
                .collect(Collectors.toList());

        //отсортированный по фамилии список потенциально работоспособных людей с высшим образованием
        List<Person> workList = persons.stream()
                .filter(e -> e.getEducation() == Education.HIGHER)
                .filter(e -> e.getAge() >= 18)
                .filter(e -> (e.getSex() == Sex.WOMEN && e.getAge() < 60)
                        || (e.getSex() == Sex.MAN && e.getAge() < 65))
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());

    }
}
