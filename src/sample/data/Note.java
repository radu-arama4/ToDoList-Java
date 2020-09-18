package sample.data;

public class Note {
    private String content;
    private String title;
    private String tags;
    private String reminder;
    private boolean done;
    private String list;

    public Note(String content, String title) {
        this.content = content;
        this.title = title;
    }

    public Note(String title, String tags, String reminder, String list, String content) {
        this.content = content;
        this.title = title;
        this.tags = tags;
        this.reminder = reminder;
        this.list = list;
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

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getReminder() {
        return reminder;
    }

    public void setReminder(String reminder) {
        this.reminder = reminder;
    }

    public void markAsDone(){
        this.done = true;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return title;
    }
}
