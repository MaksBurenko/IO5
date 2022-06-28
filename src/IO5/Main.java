package IO5;

import java.io.*;
import java.util.Objects;

public class Main {


    class Animal implements Serializable {
        private final String name;

        public Animal(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Animal) {
                return Objects.equals(name, ((Animal) obj).name);
            }
            return false;
        }
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {

        int size;
        Object o;

        try {
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
            if ((size = ois.read()) != -1) {
                Animal[] array = new Animal[size];
                while ((o = ois.read()) != null) {
                    for (int i = 0; i < array.length; i++) {
                        array[i] = (Animal) o;
                    }
                }
                return array;
            }
            ois.close();
        } catch (IllegalArgumentException | IOException | ClassCastException e) {
            System.out.println(e.getMessage());
        }
        return System.out.println(e.getMessage());
    }
}

