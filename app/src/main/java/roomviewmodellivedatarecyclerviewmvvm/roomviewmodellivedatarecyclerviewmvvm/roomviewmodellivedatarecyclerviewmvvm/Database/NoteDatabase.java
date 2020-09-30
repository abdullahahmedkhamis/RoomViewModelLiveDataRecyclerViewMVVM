package roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.Data.InterfaceNote;
import roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.Data.Note;

@Database( entities = {Note.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    private static NoteDatabase instance;

    public abstract InterfaceNote noteDao();

    public static synchronized NoteDatabase getInstance(Context context){
if(instance == null){
    instance = Room.databaseBuilder(context.getApplicationContext(),
            NoteDatabase.class,"note_database")
            .addCallback( roomCallback )
            .fallbackToDestructiveMigration()
            .build();
}
return instance;
    }

private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
    @Override
    public void onCreate(@NonNull SupportSQLiteDatabase db) {
        super.onCreate( db );
        new PopulatateDbAsyncTask( instance ).execute(  );
    }
};
    private static class PopulatateDbAsyncTask extends AsyncTask<Void,Void,Void>{
       private InterfaceNote noteDao;

       private PopulatateDbAsyncTask(NoteDatabase noteDatabase){
           noteDao = noteDatabase.noteDao();
       }
        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.insert( new Note( "Titel 1","Descrption 1",1) );
            noteDao.insert( new Note( "Titel 2","Descrption 2",2) );
            noteDao.insert( new Note( "Titel 3","Descrption 3",3) );

            return null;
        }
    }
}
