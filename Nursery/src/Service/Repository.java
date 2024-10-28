package Service;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import Models.Animal;

public class Repository {
    private String storageName = "storage.repos";
    private Counter counter;
    private HashMap<Integer, Animal> list;

    public Repository(Counter counter) {
        this.counter = counter;
        this.list = readAll();
    }

    public int size() {
        return list.size();
    }

    public HashMap <Integer, Animal> getAll() {
        return list.isEmpty() ? null : list;
    }

    public Animal getById(int id) {
        return list.getOrDefault(id, null);
    }

    public String getCommandsById(int id) {
        return list.getOrDefault(id, null).getCommands().trim();
    }

    public int append(Animal animal) throws IOException {
        try (FileWriter fw = new FileWriter(storageName, true)) {
            int id = counter.add();
            animal.setId(id);
            list.put(id, animal);
            fw.append(buildLine(animal));
        }
        return animal.getId();
    }

    public void update(Animal animal) throws IOException {
        list.put(animal.getId(), animal);
        save();
    }

    public void deleteById(int id) throws IOException {
        list.remove(id);
        save();
    }

    public HashMap<Integer, Animal> readAll() {
        File file = new File(storageName);
        HashMap<Integer, Animal> listAnimals = new HashMap<>();
        Animal animal;

        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (!line.trim().isEmpty()) {
                        animal = new Animal(line.split("[|]"));
                        listAnimals.put(animal.getId(), animal);
                    }
                }
            } catch (IOException e) {
                System.out.println("Ошибка чтения данных из файла!");
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e);
            }
        }
        return listAnimals;
    }

    public void save() throws IOException {
        try (FileWriter fw = new FileWriter(storageName)) {
            for (Integer id : list.keySet()) {
                fw.append(buildLine(list.get(id)));
            }
        }
    }

    private String buildLine(Animal animal) {
        return String.format("%d|%s|%s|%s|%s|\n",
            animal.getId(),
            animal.getType(),
            animal.getName(),
            animal.getBirthday(),
            animal.getCommands().isEmpty() ? " " : animal.getCommands()
        );
    }
}
