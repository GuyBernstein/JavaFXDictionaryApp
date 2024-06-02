/**
 * Made by Guy bernstein
 * i.d - 206558439
 * The Controller class demonstrates the usage of the Dictionary class.
 * It creates an instance of the Dictionary class and performs various operations:
 * - Adding entries to the dictionary
 * - Retrieving the meaning of a term
 * - Updating the meaning of a term
 * - Deleting an entry from the dictionary
 * - Finding a term in the dictionary
 * - Printing the content of the dictionary by a sorted order by its unique terms
 * The class utilizes the return values of the Dictionary class methods
 * to handle edge cases and provide appropriate feedback(print in the gui for the edge cases).
 */

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DictionaryController {
    @FXML
    private TextField termTextField;
    @FXML
    private TextField meaningTextField;
    @FXML
    private TextArea outputTextArea;

    private Dictionary dictionary;

    public DictionaryController() {
        dictionary = new Dictionary();
    }

    @FXML
    private void handleAddEntry() {
        String term = termTextField.getText();
        String meaning = meaningTextField.getText();
        boolean result = dictionary.addEntry(term, meaning);//adding to the dictionary
        if (result) {//succssefully added
            outputTextArea.appendText("Entry added: " + term + ": " + meaning + "\n");
        } else {//cant add two entries  with the same term
            outputTextArea.appendText("Failed to add entry. Entry already exists.\n");
        }
        clearTextFields();
    }

    @FXML
    private void handleUpdateEntry() {
        String term = termTextField.getText();
        String newMeaning = meaningTextField.getText();
        boolean result = dictionary.updateEntry(term, newMeaning);//updating the entry
        if (result) {//update and print
            outputTextArea.appendText("Entry updated: " + term + ": " + newMeaning + "\n");
        } else {//already existing term
            outputTextArea.appendText("Failed to update entry. Entry not found or new meaning already exists.\n");
        }
        clearTextFields();
    }

    @FXML
    private void handleDeleteEntry() {
        String term = termTextField.getText();
        boolean result = dictionary.deleteEntry(term);//deleteing
        if (result) {//delete successfully
            outputTextArea.appendText("Entry deleted: " + term + "\n");
        } else {//cant delete
            outputTextArea.appendText("Failed to delete entry. Entry not found.\n");
        }
        clearTextFields();
    }

    @FXML
    private void handleFindTerm() {
        String term = termTextField.getText();
        boolean result = dictionary.findTerm(term);
        if (result) {//searching in the dictionary
            String meaning = dictionary.getMeaning(term);
            outputTextArea.appendText("Term found: " + term + ": " + meaning + "\n");
        } else {//term does not exists here
            outputTextArea.appendText("Term not found: " + term + "\n");
        }
        clearTextFields();
    }

    private void clearTextFields() {//clear the text fields
        termTextField.clear();
        meaningTextField.clear();
    }

    @FXML
    private void handlePrintEntries() {//print all the content in a sorted order
        outputTextArea.clear();//passes a cleared textArea
        dictionary.printSortedEntriesWithSortedValues(outputTextArea);//call the logic in the dictionary class
    }

}