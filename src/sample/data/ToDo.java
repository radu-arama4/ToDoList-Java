package sample.data;

import java.util.ArrayList;
import java.util.List;

public class ToDo {
    private List<Note> items;

    public ToDo(){
        items = new ArrayList<>();
    }

    public ToDo(List<Note> items) {
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
