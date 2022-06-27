package IO5;

import java.io.*;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {

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

            ByteArrayInputStream reader = new ByteArrayInputStream(data);
            try {
                  for (int i=0; i < data.length; i++){

                      if(i==0) {
                        int size = reader.read();
                          Animal [] array = new Animal[size];
                      } else {
                          ObjectInputStream.readObject();
                      }


                  }
            } catch (IllegalArgumentException e){
                throw e;
            }
        }
    }
}
