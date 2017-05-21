package tools.ScriptCreator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private TextField choiceOneNextScript;

    @FXML
    private TextField choiceTwoName;

    @FXML
    private TextField choiceTwoAction;

    @FXML
    private TextField choiceTwoNextScript;

    @FXML
    private TextField choiceThreeName;

    @FXML
    private TextField choiceThreeAction;

    @FXML
    private TextField choiceThreeNextScript;

    @FXML
    private TextField choiceFourName;

    @FXML
    private TextField choiceFourAction;

    @FXML
    private TextField choiceFourNextScript;

    @FXML
    private TextField choiceFiveName;

    @FXML
    private TextField choiceFiveAction;

    @FXML
    private TextField choiceFiveNextScript;

    @FXML
    private TextArea descriptionTextField;

    @FXML
    private Button saveButton;

    @FXML
    private Label message;

    @FXML
    public void initialize() {
        message.setText("");
    }

    @FXML
    private void saveScript() {
        try {
            message.setVisible(false);
            if (!checkImportantFields()) {
                message.setText("Important fields are missing info. Cannot save file.");
                message.setVisible(true);
                return;
            }
            File file = createFile();
            if (file == null) {
                message.setText("Error in creating the file");
                message.setVisible(true);
                return;
            }
            writer = new PrintWriter(file);
            saveImportantData();
            saveDescriptionText();
            saveChoices();
            writer.close();
            message.setText("File has been saved successfully.");
            message.setVisible(true);
        } catch (FileNotFoundException e) {
            message.setText("Could not locate the created file.");
            message.setVisible(true);
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
        String choiOneNextScript = choiceOneNextScript.getText();
        if (!choiOneName.equals("") && !choiOneAction.equals("")) {
            writer.println(choiOneName + ":" + choiOneAction +
                "|" + choiOneNextScript);
        }
        //Choice Two Stuff
        String choiTwoName = choiceTwoName.getText();
        String choiTwoAction = choiceTwoAction.getText();
        String choiTwoNextScript = choiceTwoNextScript.getText();
        if (!choiTwoName.equals("") && !choiTwoAction.equals("")) {
            writer.println(choiTwoName + ":" + choiTwoAction +
                "|" + choiTwoNextScript);
        }
        //Choice Three Stuff
        String choiThreeName = choiceThreeName.getText();
        String choiThreeAction = choiceThreeAction.getText();
        String choiThreeNextScript = choiceThreeNextScript.getText();
        if (!choiThreeName.equals("") && !choiThreeAction.equals("")) {
            writer.println(choiThreeName + ":" + choiThreeAction +
                "|" + choiThreeNextScript);
        }
        //Choice Four Stuff
        String choiFourName = choiceFourName.getText();
        String choiFourAction = choiceFourAction.getText();
        String choiFourNextScript = choiceFourNextScript.getText();
        if (!choiFourName.equals("") && !choiFourAction.equals("")) {
            writer.println(choiFourName + ":" + choiFourAction +
                "|" + choiFourNextScript);
        }
        //Choice Five Stuff
        String choiFiveName = choiceFiveName.getText();
        String choiFiveAction = choiceFiveAction.getText();
        String choiFiveNextScript = choiceFiveNextScript.getText();
        if (!choiFiveName.equals("") && !choiFiveAction.equals("")) {
            writer.println(choiFiveName + ":" + choiFiveAction +
                "|" + choiFiveNextScript);
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
