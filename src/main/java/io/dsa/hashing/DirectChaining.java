package io.dsa.hashing;

import java.util.LinkedList;

import static io.dsa.Colors.*;
import static io.dsa.hashing.HashUtils.modASCIIHashFun;

public class DirectChaining {
    LinkedList<String>[] hashTable;
    int maxChainSize = 5;

    DirectChaining(int size) {
        hashTable = new LinkedList[size];
    }

    public static void main(String[] args) {
        DirectChaining directChaining = new DirectChaining(13);
        directChaining.insertHashTable("The");
        directChaining.insertHashTable("quick");
        directChaining.insertHashTable("brown");
        directChaining.insertHashTable("fox");
        directChaining.insertHashTable("over");
        directChaining.displayHashTable();

        colorPrintln("===========================================\n",
                YELLOW);
        directChaining.search("fox");
        directChaining.search("ajshdfja");

        colorPrintln("===========================================\n",
                YELLOW);
        directChaining.deleteKeyHashTable("fox");
        directChaining.deleteKeyHashTable("ajshdfja");
        directChaining.displayHashTable();
    }


    public void insertHashTable(String word) {
        int index = modASCIIHashFun(word, hashTable.length);

        if (hashTable[index] == null) {
            hashTable[index] = new LinkedList<>();
        }
        hashTable[index].add(word);
    }

    public void displayHashTable() {
        if (hashTable == null) {
            colorPrintln("HashTable does not exists!!", RED);
        } else {
            colorPrintln("================ HashTable ================\n",
                    YELLOW);

            for (int i = 0; i < hashTable.length; i++) {
                colorPrintln("Index: " + i + ", " +
                        "key: " + hashTable[i], GREEN);
            }

            colorPrintln("===========================================\n",
                    YELLOW);
        }
    }

    public boolean search(String word) {
        int index = modASCIIHashFun(word, hashTable.length);

        if (hashTable[index] != null && hashTable[index].contains(word)) {
            colorPrintln(word + " found in HashTable at location: " + index, GREEN);
            return true;
        } else {
            colorPrintln(word + " not found in HashTable", RED);
            return false;
        }
    }

    public void deleteKeyHashTable(String word) {
        int index = modASCIIHashFun(word, hashTable.length);

        boolean result = search(word);
        if (result) {
            hashTable[index].remove(word);
            colorPrintln(word + " has been deleted!!", CYAN);
        } else {
            colorPrintln(word + " does not exist!!", RED);
        }
    }
}
