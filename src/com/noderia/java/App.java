package com.noderia.java;

import javax.swing.*;
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
            String message = "Fra record.data: "+arnein.fornavn()+" "+ arnein.etternavn()+" er "+arnein.alder()+ " år gammel.";
            System.out.println(message);
            JOptionPane.showMessageDialog(null, message);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try(var ut = new FileWriter("record.txt",false) ) {
            String tekst = "Fra record.txt: "+arne.fornavn() + " " + arne.etternavn() + " er " + arne.alder() + " år gammel\n";
            ut.write(tekst);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.lines(Paths.get("record.txt")).forEach(System.out::println);
            Files.lines(Paths.get("record.txt")).forEach(a -> JOptionPane.showMessageDialog(null,a));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
