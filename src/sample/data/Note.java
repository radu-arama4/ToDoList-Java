package sample.data;

import java.util.ArrayList;
import java.util.List;

public class Note {
    private String content;
    private String title;
    private List<String> tags;
    private String reminder;

    public Note(String content, String title) {
        this.content = content;
        this.title = title;
    }

    public Note(String content, String title, List<String> tags, String reminder) {
        this.content = content;
        this.title = title;
        tags = new ArrayList<>();
        this.tags = tags;
        this.reminder = reminder;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getReminder() {
        return reminder;
    }

    public void setReminder(String reminder) {
        this.reminder = reminder;
    }
}
