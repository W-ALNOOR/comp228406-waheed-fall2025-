package exercise1;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class StudentInfoController {

    @FXML private TextField nameField, addressField, cityField, provinceField, postalField, phoneField, emailField;
    @FXML private RadioButton csButton, busButton;
    @FXML private ComboBox<String> courseCombo;
    @FXML private ListView<String> courseList;
    @FXML private CheckBox studentCouncilBox, volunteerBox;
    @FXML private TextArea displayArea;

    @FXML
    public void initialize() {
        csButton.setOnAction(e -> courseCombo.getItems().setAll("Java", "Python", "C#", "AI"));
        busButton.setOnAction(e -> courseCombo.getItems().setAll("Marketing", "Finance", "HR", "Accounting"));

        courseCombo.setOnAction(e -> {
            String selected = courseCombo.getValue();
            if (selected != null && !courseList.getItems().contains(selected)) {
                courseList.getItems().add(selected);
            }
        });
    }

    @FXML
    private void displayInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Full Name: ").append(nameField.getText()).append("\n")
                .append("Address: ").append(addressField.getText()).append(", ")
                .append(cityField.getText()).append(", ")
                .append(provinceField.getText()).append(", ")
                .append(postalField.getText()).append("\n")
                .append("Phone: ").append(phoneField.getText()).append("\n")
                .append("Email: ").append(emailField.getText()).append("\n");

        if (csButton.isSelected()) sb.append("Program: Computer Science\n");
        else if (busButton.isSelected()) sb.append("Program: Business\n");

        sb.append("Courses: ").append(courseList.getItems()).append("\n");

        sb.append("Activities: ");
        if (studentCouncilBox.isSelected()) sb.append("Student Council ");
        if (volunteerBox.isSelected()) sb.append("Volunteer Work ");

        displayArea.setText(sb.toString());
    }
}