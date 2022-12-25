package io.dsa.hashing;

import java.util.ArrayList;

import static io.dsa.Colors.*;
import static io.dsa.hashing.HashUtils.modASCIIHashFun;

public class QuadraticProbing {
    String[] hashTable;
    int usedCellNumber;

    QuadraticProbing(int size) {
        hashTable = new String[size];
        usedCellNumber = 0;
    }

    public static void main(String[] args) {
        QuadraticProbing quadraticProbing = new QuadraticProbing(13);
        quadraticProbing.insertInHashTable("The");
        quadraticProbing.insertInHashTable("quick");
        quadraticProbing.insertInHashTable("brown");
        quadraticProbing.insertInHashTable("fox");
        quadraticProbing.insertInHashTable("over");

        quadraticProbing.displayHashTable();
        quadraticProbing.search("fox");
        quadraticProbing.search("tiger");

        quadraticProbing.delete("fox");
        quadraticProbing.search("tiger");
        quadraticProbing.displayHashTable();
    }
    public double getLoadFactor() {
        return usedCellNumber * 1.0 / hashTable.length;
    }

    public void rehashKeys(String word) {
        usedCellNumber = 0;
        ArrayList<String> data = new ArrayList<>();
        for (String s : hashTable) {
            if (s != null) {
                data.add(s);
            }
        }
        data.add(word);
        hashTable = new String[hashTable.length * 2];
        for (String s : data) {
            insertInHashTable(s);
        }
    }

    public void insertInHashTable(String word) {
        double loadFactor = getLoadFactor();
        if (loadFactor >= 0.75) {
            rehashKeys(word);
        } else {
            int index = modASCIIHashFun(word, hashTable.length);
            int counter = 0;

            for (int i = index; i < index + hashTable.length; i++) {
                int newIndex = (index + (counter * counter)) % hashTable.length;

                if (hashTable[newIndex] == null) {
                    hashTable[newIndex] = word;
                    colorPrintln(word + " inserted successfully, At index: " + newIndex, GREEN);
                    break;
                } else {
                    colorPrintln(newIndex + " already occupied, " + "Trying next empty cell", BLUE);
                }
                counter++;
            }
        }
        usedCellNumber++;
    }

    public void displayHashTable() {
        if (hashTable == null) {
            colorPrintln("HashTable does not exists!!", RED);
        } else {
            colorPrintln("================ HashTable ================\n", YELLOW);

            for (int i = 0; i < hashTable.length; i++) {
                colorPrintln("Index: " + i + ", " + "key: " + hashTable[i], GREEN);
            }

            colorPrintln("===========================================\n", YELLOW);
        }
    }

    public boolean search(String word) {
        int index = modASCIIHashFun(word, hashTable.length);
        for (int i = index; i < index + hashTable.length; i++) {
            int newIndex = i % hashTable.length;

            if (hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
                colorPrintln(word + " found in HashTable at location: " + newIndex, GREEN);
                return true;
            }
        }
        colorPrintln(word + " not found in HashTable", RED);
        return false;
    }

    public void delete(String word) {
        int index = modASCIIHashFun(word, hashTable.length);
        for (int i = index; i < index + hashTable.length; i++) {
            int newIndex = i % hashTable.length;

            if (hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
                hashTable[newIndex] = null;
                colorPrintln(word + " Deleted from hashTable " + newIndex, BLUE);
                return;
            }
        }
        colorPrintln(word + " not found in HashTable", RED);
    }
}
