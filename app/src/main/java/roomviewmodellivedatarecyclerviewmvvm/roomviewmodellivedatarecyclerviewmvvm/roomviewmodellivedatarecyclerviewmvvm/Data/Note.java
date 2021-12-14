package roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.Data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;

    private String description;

    private int priority;

    private int phoneoremail;
    
    public Note(String s, String s1, int i) {
    }


    public Note(String title, String description, int priority, int phoneoremail) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.phoneoremail = phoneoremail;

    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public int getPhoneoremail() {
        return phoneoremail;
    }

    public void setPhoneoremail(int phoneoremail) {
        this.phoneoremail = phoneoremail;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }




}
