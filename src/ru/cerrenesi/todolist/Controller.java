package ru.cerrenesi.todolist;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import ru.cerrenesi.todolist.datamodel.TodoData;
import ru.cerrenesi.todolist.datamodel.TodoItem;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<TodoItem> todoItems;

    @FXML
    private ListView<TodoItem> todoListView;
    @FXML
    private TextArea itemDetailsTextArea;
    @FXML
    private Label deadLineLabel;

    public void initialize() {
        ChangeListener<TodoItem> listener = (ObservableValue<? extends TodoItem> observable, TodoItem oldValue, TodoItem newValue) -> {
            if (newValue != null) {
                TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                itemDetailsTextArea.setText(item.getDetails());
                DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                deadLineLabel.setText(df.format(item.getDeadline()));
            }
        };

        todoListView.getSelectionModel().selectedItemProperty().addListener(listener);

        todoListView.getItems().setAll(TodoData.getInstance().getTodoItems());
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        todoListView.getSelectionModel().selectFirst();
    }

//    @FXML
//    public void handleClickListView() {
//        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
//        StringBuilder sb = new StringBuilder(item.getDetails());
//        itemDetailsTextArea.setText(item.getDetails());
//        deadLineLabel.setText(item.getDeadline().toString());
//    }


}
