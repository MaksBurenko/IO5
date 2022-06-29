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
        Animal[] array = new Animal[0];

        try {
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));

            size = ois.readInt();
            array = new Animal[size];

                for (int i = 0; i < array.length; i++) {
                    o = ois.readObject();
                    array[i] = (Animal) o;
                }
                ois.close();


        } catch (IllegalArgumentException | IOException | ClassCastException | ClassNotFoundException e) {
            throw new IllegalArgumentException ("IllegalArgumentException");
        }
        return array;
    }
}
