package ru.cerrenesi.todolist;

import ru.cerrenesi.todolist.datamodel.TodoItem;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<TodoItem> todoItems;
    public void initialize() {

        TodoItem item1 = new TodoItem("Mail birthday card", "Buy a 30th birthday card for John",
                LocalDate.of(2019, Month.APRIL, 25));
        TodoItem item2 = new TodoItem("Doctor's Appointment", "See Dr.Smith at 123 Main Street. Bring paperwork",
                LocalDate.of(2019, Month.MAY, 23));
        TodoItem item3 = new TodoItem("Finish design proposal for client", "I promised Mike I'd email website mockups",
                LocalDate.of(2019, Month.APRIL, 22));
        TodoItem item4 = new TodoItem("Pickup Doug at the train station", "Doug's arriving on JANUARY 21 on the 5:00 train",
                LocalDate.of(2019, Month.JANUARY, 21));
        TodoItem item5 = new TodoItem("Pick up dry cleaning", "The clothes should be ready by Wednesday",
                LocalDate.of(2019, Month.APRIL, 20));

        todoItems = new ArrayList<TodoItem>();
        todoItems.add(item1);
        todoItems.add(item2);
        todoItems.add(item3);
        todoItems.add(item4);
        todoItems.add(item5);

    }

}
