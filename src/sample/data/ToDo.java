package sample.data;

import java.util.ArrayList;
import java.util.List;

public class ToDo {
    private List<Note> items;
    private String name;

    public ToDo(String name){
        this.name = name;
        items = new ArrayList<>();
    }

    public ToDo(List<Note> items, String name) {
        this.name = name;
        items = new ArrayList<>();
        this.items = items;
    }

    public void addItem(Note note){
        items.add(note);
    }

    public void removeItem(Note note){
        items.remove(note);
    }
}
