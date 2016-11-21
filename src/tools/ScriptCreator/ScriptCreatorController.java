package tools.ScriptCreator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Allows ScriptCreator.fxml to operate
 * @author Alexander Hennie-Roed
 * @version 1.0.0
 */
public class ScriptCreatorController {

    private PrintWriter writer;

    @FXML
    private TextField chapterField;

    @FXML
    private TextField sceneField;

    @FXML
    private TextField scriptField;

    @FXML
    private TextField characterField;

    @FXML
    private TextField choiceOneName;

    @FXML
    private TextField choiceOneAction;

    @FXML
    private TextField choiceTwoName;

    @FXML
    private TextField choiceTwoAction;

    @FXML
    private TextField choiceThreeName;

    @FXML
    private TextField choiceThreeAction;

    @FXML
    private TextField choiceFourName;

    @FXML
    private TextField choiceFourAction;

    @FXML
    private TextField choiceFiveName;

    @FXML
    private TextField choiceFiveAction;

    @FXML
    private TextArea descriptionTextField;

    @FXML
    private Button saveButton;

    @FXML
    private void saveScript() {
        try {
            if (!checkImportantFields()) {
                System.out.println("Important fields are missing info.\nCannot save file.");
                return;
            }
            File file = createFile();
            if (file == null) {
                System.out.println("Error in creating the file");
                return;
            }
            writer = new PrintWriter(file);
            saveImportantData();
            saveDescriptionText();
            saveChoices();
            writer.close();
            System.out.println("File has been saved successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Could not locate the created file.");
        }
    }

    /**
     * Checks that the info vital for creating the file is present
     * @return a boolean representing approval to continue
     */
    private boolean checkImportantFields() {
        return !(chapterField.getText().equals("") && sceneField.getText().equals("")
                    && scriptField.getText().equals(""));
    }

    /**
     * Creates the file that will be saved
     * @return the file that has been created
     */
    private File createFile() {
        try {
            String fileName = "Script" + chapterField.getText()
                    + "-" + sceneField.getText() + "-" + scriptField.getText() + ".script";
            String workingDirectory = System.getProperty("user.dir");
            String filePath = workingDirectory + File.separator + fileName;
            File file = new File(filePath);
            if (file.createNewFile()) {
                return file;
            } else {
                throw new IOException("Method createNewFile() returned false.");
            }
        } catch (IOException e) {
            System.out.println("Error in creating file.\nTry again later.");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Saves the main header data
     */
    private void saveImportantData() {
        String scriptName = "Script " + chapterField.getText() + "-" + sceneField.getText()
                + "-" + scriptField.getText();
        writer.println(scriptName);
        writer.println();
        writer.println(characterField.getText());
        writer.println();
    }

    /**
     * Saves the choice data
     */
    private void saveChoices() {
        //Choice One Stuff
        String choiOneName = choiceOneName.getText();
        String choiOneAction = choiceOneAction.getText();
        if (!choiOneName.equals("") && !choiOneAction.equals("")) {
            writer.println(choiOneName + ":" + choiOneAction);
        }
        //Choice Two Stuff
        String choiTwoName = choiceTwoName.getText();
        String choiTwoAction = choiceTwoAction.getText();
        if (!choiTwoName.equals("") && !choiTwoAction.equals("")) {
            writer.println(choiTwoName + ":" + choiTwoAction);
        }
        //Choice Three Stuff
        String choiThreeName = choiceThreeName.getText();
        String choiThreeAction = choiceThreeAction.getText();
        if (!choiThreeName.equals("") && !choiThreeAction.equals("")) {
            writer.println(choiThreeName + ":" + choiThreeAction);
        }
        //Choice Four Stuff
        String choiFourName = choiceFourName.getText();
        String choiFourAction = choiceFourAction.getText();
        if (!choiFourName.equals("") && !choiFourAction.equals("")) {
            writer.println(choiFourName + ":" + choiFourAction);
        }
        //Choice Five Stuff
        String choiFiveName = choiceFiveName.getText();
        String choiFiveAction = choiceFiveAction.getText();
        if (!choiFiveName.equals("") && !choiFiveAction.equals("")) {
            writer.println(choiFiveName + ":" + choiFiveAction);
        }
    }

    /**
     * Saves the description text data
     */
    private void saveDescriptionText() {
        writer.println(descriptionTextField.getText());
        writer.println();
    }

}
