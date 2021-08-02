package com.noderia.java;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {

    public static void main(String[] args) {

        Person arne = new Person("Arne", "Pettersen", 29);

        try (var os = new ObjectOutputStream(new FileOutputStream("record.data")) ) {
            os.writeObject(arne);
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (var is = new ObjectInputStream(new FileInputStream("record.data")) ) {
           Person arnein = (Person) is.readObject();
            System.out.println(arnein.fornavn()+" "+ arnein.etternavn()+" er "+arnein.alder()+ " år gammel.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try(var ut = new FileWriter("record.txt",false) ) {
            String tekst = (arne.fornavn() + " " + arne.etternavn() + " er " + arne.alder() + " år gammel\n");
            ut.write(tekst);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.lines(Paths.get("record.txt")).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
