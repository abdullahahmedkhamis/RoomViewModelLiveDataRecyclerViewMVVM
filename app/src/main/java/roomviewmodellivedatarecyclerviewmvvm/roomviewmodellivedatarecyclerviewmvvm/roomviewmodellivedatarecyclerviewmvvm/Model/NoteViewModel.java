package roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.Model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.Data.Note;
import roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.Data.NoteRepository;

public class NoteViewModel extends AndroidViewModel {

    private NoteRepository repository;
    private LiveData<List<Note>> allNotes;

    public NoteViewModel(@NonNull Application application) {
        super( application );
        repository = new NoteRepository( application );
        allNotes = repository.getAllNotes();
    }

    public void jnsert(Note note) {
        repository.insert( note );
    }

    public void update(Note note) {
        repository.update( note );
    }

    public void delete(Note note) {
        repository.delete( note );

    }

    public void deleteAllNotes() {   // Note note هى هى
        repository.deleteAllNotes( );

    }



    public LiveData<List<Note>> getAllNotes(){
        return allNotes;
    }

    public void insert(Note note) {
        repository.insert( note );
    }


}