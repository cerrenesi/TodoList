package ru.cerrenesi.todolist.datamodel;

import javafx.collections.FXCollections;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

public class TodoData {
    private static TodoData instance = new TodoData();
    private static String filename = "TodoListItems.txt";

    private List<TodoItem> todoItems;
    private DateTimeFormatter formatter;

    public static TodoData getInstance() {
        return instance;
    }

    private TodoData() {
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public List<TodoItem> getTodoItems() {
        return todoItems;
    }

    public void setTodoItems(List<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }

    public void loadTodoItems() throws IOException {
        todoItems = FXCollections.observableArrayList();
        var path = Paths.get(filename);
        BufferedReader br = Files.newBufferedReader(path);
        String input;
        try {
            while ((input = br.readLine()) != null) {
                var itemPieces = input.split("\t");
                var shortDescription = itemPieces[0];
                var details = itemPieces[1];
                var dateString = itemPieces[2];
                var date = LocalDate.parse(dateString, formatter);

                var todoItem = new TodoItem(shortDescription, details, date);
                todoItems.add(todoItem);
            }

        }finally {
            if(br != null) {
                br.close();
            }
        }
    }

    public void  storeTodoItems() throws IOException {

        var path = Paths.get(filename);
        BufferedWriter bw = Files.newBufferedWriter(path);

        try {
            Iterator<TodoItem> iter = todoItems.iterator();
            while (iter.hasNext()) {
                var item = iter.next();
                bw.write(String.format("%s\t%s\t%s",
                        item.getShortDescription(),
                        item.getDetails(),
                        item.getDeadline().format(formatter)));
                bw.newLine();
            }
        } finally {
            if(bw != null) {
                bw.close();
            }
        }


    }
}
