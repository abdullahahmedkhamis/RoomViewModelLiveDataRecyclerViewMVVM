package roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.Data;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.Database.NoteDatabase;

public class NoteRepository {
    private InterfaceNote noteDao;
    private LiveData<List<Note>> allNotes;

    public NoteRepository(Application application){
        NoteDatabase database = NoteDatabase.getInstance(application  );
        noteDao = database.noteDao();
        allNotes = noteDao.getAllNotes();
    }

    public void insert(Note note){
        new InsertNoteAsyncTask( noteDao ).execute( note );

    }

    public void update(Note note){
        new UpdateNoteAsyncTask( noteDao ).execute( note );

    }
    public void delete(Note note){
        new DeleteNoteAsyncTask( noteDao ).execute( note );


    }
    public void deleteAllNotes(){
        new DeleteAllNotesAsyncTask( noteDao ).execute( );


    }
    public LiveData<List<Note>> getAllNotes(){
        return allNotes;
    }

    private static class InsertNoteAsyncTask extends AsyncTask<Note,Void,Void>{
       private InterfaceNote noteDao;

       private InsertNoteAsyncTask(InterfaceNote noteDao){
           this.noteDao = noteDao;
       }

        @Override
        protected Void doInBackground(Note... notes) {
           noteDao.insert( notes[0] );
            return null;
        }
    }
    private static class UpdateNoteAsyncTask extends AsyncTask<Note,Void,Void>{
        private InterfaceNote noteDao;

        private UpdateNoteAsyncTask(InterfaceNote noteDao){
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.update( notes[0] );
            return null;
        }
    }
    private static class DeleteNoteAsyncTask extends AsyncTask<Note,Void,Void>{
        private InterfaceNote noteDao;

        private DeleteNoteAsyncTask(InterfaceNote noteDao){
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.delete( notes[0] );
            return null;
        }
    }
    private static class DeleteAllNotesAsyncTask extends AsyncTask<Note,Void,Void>{
        private InterfaceNote noteDao;

        private DeleteAllNotesAsyncTask(InterfaceNote noteDao){
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.deleteAllNotes( );
            return null;
        }
    }
}
