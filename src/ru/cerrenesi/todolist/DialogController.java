package ru.cerrenesi.todolist;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import ru.cerrenesi.todolist.datamodel.TodoData;
import ru.cerrenesi.todolist.datamodel.TodoItem;

import java.time.LocalDate;

public class DialogController {

    @FXML
    private TextField shortDescriptionField;
    @FXML
    private TextArea detailsArea;
    @FXML
    private DatePicker deadLinePicker;

    public TodoItem processResult() {
        String shortDescription = shortDescriptionField.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadLineValue = deadLinePicker.getValue();
        var newItem = new TodoItem(shortDescription, details,deadLineValue);
        TodoData.getInstance().addTodoItem(newItem);
        return newItem;
    }


}
