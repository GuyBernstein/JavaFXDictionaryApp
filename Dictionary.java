/**
    Guy Bernstein
   i.d: 206558439
 * The Dictionary class represents a dictionary that stores terms and their corresponding meanings.
 * It uses a TreeMap to store the term-meaning pairs, ensuring sorted order of the terms.
 * The class provides methods to perform common dictionary operations:
 * - Adding an entry to the dictionary
 * - Retrieving the meaning of a term
 * - Finding a term in the dictionary
 * - Deleting an entry from the dictionary
 * - Updating the meaning of a term
 * - Printing the sorted entries of the dictionary
 * The methods handle edge cases by returning appropriate values to indicate the success or failure
 * of the operations(for example, cant add a term when there is already existing one that is the same).
 */

import javafx.scene.control.TextArea;

import java.util.*;

class Dictionary {
    private TreeMap<String, String> termMeaningMap;

    public Dictionary() {
        termMeaningMap = new TreeMap<String,String>();
    }

    public boolean addEntry(String term, String meaning) {
        if (termMeaningMap.containsKey(term)) {
            return false; // Entry already exists, cannot add duplicate
        }
        termMeaningMap.put(term, meaning);
        return true;
    }

    public String getMeaning(String term) {
        return termMeaningMap.getOrDefault(term, null);
    }

    public boolean findTerm(String term) {
        return termMeaningMap.containsKey(term);
    }

    public boolean deleteEntry(String term) {
        if (termMeaningMap.containsKey(term)) {
            termMeaningMap.remove(term);
            return true;
        }
        return false; // Entry not found, cannot delete
    }

    public boolean updateEntry(String term, String newMeaning) {
        if (termMeaningMap.containsKey(term)) {
            if (termMeaningMap.containsValue(newMeaning)) {
                return false; // New meaning already exists for another term
            }
            termMeaningMap.put(term, newMeaning);
            return true;
        }
        return false; // Entry not found, cannot update
    }
    public Set<Map.Entry<String, String>> getEntries() {//get the entries from the TreeMap
        return termMeaningMap.entrySet();
    }

    public void printSortedEntriesWithSortedValues(TextArea outputTextArea) {
        for (Map.Entry<String, String> entry : getEntries()) {//for every entry in the dictionary
            //append the text to be presented in the gui
            //we get a sorted print because of the TreeMap's sorted keys.
            outputTextArea.appendText(entry.getKey() + ": " + entry.getValue() + "\n");
        }
    }

}

