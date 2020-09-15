package sample.data;

import java.lang.reflect.Array;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public static final String DB_NAME = "todo.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:D:\\Java_Projects\\ToDoProject\\" + DB_NAME;
    public final String CREATE = "";

    public static final String TABLE_NOTES = "NOTES";
    public static final String COLUMN_NOTES_ID = "_id";
    public static final String COLUMN_NOTES_TITLE = "title";
    public static final String COLUMN_NOTES_CONTENT = "content";
    public static final String COLUMN_NOTES_TAGS = "tags";
    public static final String COLUMN_NOTES_REMINDER = "reminder";
    public static final String COLUMN_NOTES_LIST = "list";

    public static final String INSERT_TABLE_NOTE = "CREATE TABLE " + TABLE_NOTES +
                                " (" + COLUMN_NOTES_ID + " integer, " + COLUMN_NOTES_TITLE +
                                " string, " + COLUMN_NOTES_TAGS + " integer, " + COLUMN_NOTES_REMINDER +
                                " string, " + COLUMN_NOTES_LIST + " string)";

    public static final String INSERT_INTO_NOTE =
                    "INSERT INTO " + TABLE_NOTES + "(" + COLUMN_NOTES_TITLE +
                    ", " + COLUMN_NOTES_CONTENT + ") " + "VALUES(";

    public static final String INSERT_INTO_NOTE_COMPLEX =
            "INSERT INTO " + TABLE_NOTES + "(" + COLUMN_NOTES_TITLE +
                    ", " + COLUMN_NOTES_CONTENT + ", "+ COLUMN_NOTES_REMINDER +
                    ", "+COLUMN_NOTES_LIST+", "+COLUMN_NOTES_TAGS+") " + "VALUES(";

    public static final String PRINT_NOTES =
            "SELECT * FROM " + TABLE_NOTES;

    public static final String QUERY_NOTES_BY_TAG =
            "SELECT * FROM " + TABLE_NOTES + " WHERE " + COLUMN_NOTES_TAGS + " LIKE '%";

    public static final String QUERY_NOTES_BY_WORD =
            "SELECT * FROM " + TABLE_NOTES + " WHERE " + COLUMN_NOTES_TITLE + " LIKE '%word%' OR " + COLUMN_NOTES_CONTENT + " LIKE '%word%'";

    public static final String DELETE_NOTE =
            "DELETE FROM " + TABLE_NOTES + " WHERE " + COLUMN_NOTES_TITLE + " LIKE 'name'";

    public static final String CHECK_REMINDER =
            "SELECT * FROM " + TABLE_NOTES + " WHERE " + COLUMN_NOTES_REMINDER + " IS NOT NULL";

    public static final String ADD_TO_LIST =
            "UPDATE " + TABLE_NOTES + " SET " + COLUMN_NOTES_LIST + " = 'LIST' WHERE title LIKE 'NAME'";

    public static final String QUERY_TO_DO =
            "SELECT * FROM " + TABLE_NOTES + " WHERE " + COLUMN_NOTES_LIST + " IS NOT NULL";

    private Connection conn;

    private boolean check(){
        try {
            Class.forName("org.sqlite.JDBC"); //Register JDBC Driver

            System.out.println("Creating a connection...");
            conn = DriverManager.getConnection(CONNECTION_STRING); //Open a connection

            ResultSet resultSet = conn.getMetaData().getCatalogs();

            while (resultSet.next()) {
                String databaseName = resultSet.getString(1);
                if(databaseName.equals(DB_NAME)){
                    return true;
                }
            }
            resultSet.close();
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean init(){
        if(!check()){
            try{
                String SQL = "CREATE DATABASE todo";
                //conn.createStatement().executeUpdate(SQL);
                conn.createStatement().executeUpdate(INSERT_TABLE_NOTE);
                //conn.createStatement().executeUpdate(INSERT_TABLE_TAGS);
                System.out.println("Hey");
                return true;
            }catch (SQLException e){
                System.out.println("Error - " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    private static DataSource instance = new DataSource();

    private DataSource(){
        //singleton
    }

    public static DataSource getInstance(){
        return instance;
    }

    public boolean insertNote(Note note){
        String query = null;
        if(note.getTags()==null){
            query = INSERT_INTO_NOTE + "'" + note.getTitle() + "'"+", '" + note.getContent() + "' )";
        }else{
            query = INSERT_INTO_NOTE_COMPLEX + "'" + note.getTitle() + "', '" + note.getContent() +
                    "', '" + note.getReminder() + "', '" + note.getList() + "', '"+ note.getTags() +"')";
        }
        System.out.println(query);
        try{
            conn.createStatement().executeUpdate(query);
            return true;
        }catch (SQLException e){
            System.out.println("Error - " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Note> getAllNotes(){
        String query = PRINT_NOTES;
        try {
            Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery(query);
            ArrayList<Note> notes = new ArrayList<>();
            while (results.next()){
                Note note = new Note(results.getString(2), results.getString(3), results.getString(4),
                        results.getString(5), results.getString(6));
                notes.add(note);
            }
            return notes;
        }catch (SQLException e){
            System.out.println("Error - " + e.getMessage());
            return null;
        }
    }

    public ArrayList<Note> getNotesByTag(String tag){
        String query = QUERY_NOTES_BY_TAG + tag + "%'";
        //System.out.println(query);
        try {
            Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery(query);
            ArrayList<Note> notes = new ArrayList<>();
            while (results.next()){
                Note note = new Note(results.getString(2), results.getString(3), results.getString(4),
                        results.getString(5), results.getString(6));
                notes.add(note);
            }
            return notes;
        }catch (SQLException e){
            System.out.println("Error - " + e.getMessage());
            return null;
        }
    }

    public ArrayList<Note> getNotesByWord(String word){
        String query = QUERY_NOTES_BY_WORD.replace("word", word);
        System.out.println(query);
        try {
            Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery(query);
            ArrayList<Note> notes = new ArrayList<>();
            while (results.next()){
                Note note = new Note(results.getString(2), results.getString(3), results.getString(4),
                        results.getString(5), results.getString(6));
                System.out.println(note.toString());
                notes.add(note);
            }
            return notes;
        }catch (SQLException e){
            System.out.println("Error - " + e.getMessage());
            return null;
        }
    }

    public ArrayList<Note> getNotesWithReminder(){
        String query = CHECK_REMINDER;
        try {
            Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery(query);
            ArrayList<Note> notes = new ArrayList<>();
            while (results.next()){
                Note note = new Note(results.getString(2), results.getString(3), results.getString(4),
                        results.getString(5), results.getString(6));
                System.out.println(note.toString());
                notes.add(note);
            }
            return notes;
        }catch (SQLException e){
            System.out.println("Error - " + e.getMessage());
            return null;
        }
    }

    public boolean addNoteToList(String name, String list){
        String query = ADD_TO_LIST
                .replace("NAME", name)
                .replace("LIST", list);
        System.out.println(query);
        try{
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
            return true;
        }catch (SQLException e){
            System.out.println("Error - " + e.getMessage());
            return false;
        }
    }

    public boolean deleteNote(String name){
        String query = DELETE_NOTE.replace("name", name);
        try{
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
            return true;
        }catch (SQLException e){
            System.out.println("Error - " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Note> loadToDoList(){
        try{
            Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery(QUERY_TO_DO);
            ArrayList<Note> notes = new ArrayList<>();
            while (results.next()){
                Note note = new Note(results.getString(2), results.getString(3), results.getString(4),
                        results.getString(5), results.getString(6));
                System.out.println(note.toString());
                notes.add(note);
            }
            return notes;
        }catch (SQLException e){
            System.out.println("Error - " + e.getMessage());
            return null;
        }
    }

}
