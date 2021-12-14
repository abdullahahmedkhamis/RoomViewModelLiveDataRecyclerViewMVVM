package roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.roomviewmodellivedatarecyclerviewmvvm.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.Adapter.NoteAdapter;
import roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.Data.Note;
import roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.Model.NoteViewModel;

public class MainActivity extends AppCompatActivity {

    // https://www.youtube.com/watch?v=ARpn-1FPNE4&list=PLrnPJCHvNZuDihTpkRs6SpZhqgBqPU118

    public static final int ADD_NOTE_REQUEST = 1;
    public static final int EDIT_NOTE_REQUEST = 2;
    private NoteViewModel noteViewModel;
    VideoView videoView;
    TextView mTextField;

    DatePicker d;   // a
    TimePicker t;  //  a
    Button start;  //  a

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );


      //  d = (DatePicker) findViewById(R.id.datePicker);
      //  t = (TimePicker) findViewById(R.id.timePicker);
        start = (Button) findViewById(R.id.btn_set_alarm_startagine);
       /* start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                c.set(d.getYear(), d.getMonth(), d.getDayOfMonth(),
                        t.getCurrentHour(), t.getCurrentMinute());
                long time = c.getTimeInMillis();
                SharedPreferences sh = getSharedPreferences("save", 0);
                SharedPreferences.Editor e = sh.edit();
                e.putLong("mills", time);
                e.putBoolean("state",true);
                e.commit();
                Intent intent = new Intent(MainActivity.this, Catcher.class);
                PendingIntent p = PendingIntent.getBroadcast(getApplicationContext(), 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager v3 = (AlarmManager) getSystemService(ALARM_SERVICE);
                v3.set(AlarmManager.RTC_WAKEUP, time, p);
                finish();
            }
        }); */




      //  videoView = (VideoView) findViewById( R.id.videoView );
      //  mTextField = (TextView) findViewById( R.id.textview111 );




       /* Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,0);  // HOUR_OF_DAY,0
        calendar.set(Calendar.MINUTE,1);      // MINUTE,0
        calendar.set(Calendar.SECOND, 0);
        Intent intent = new Intent( getApplicationContext(),Notification_reciever.class );

        PendingIntent pendingIntent = PendingIntent.getBroadcast( getApplicationContext(),100,intent,PendingIntent.FLAG_UPDATE_CURRENT );

        Intent alertIntent = new Intent(getApplicationContext(), AlertReceiver.class);
        AlarmManager alarmManager = (AlarmManager)getSystemService( ALARM_SERVICE );
        alarmManager.setRepeating( AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),AlarmManager.INTERVAL_HOUR,pendingIntent );


        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), PendingIntent.getBroadcast(getApplicationContext(), 0, alertIntent,
                PendingIntent.FLAG_UPDATE_CURRENT ));  */






      //  Toast.makeText(MainActivity.this, "your text here ", Toast.LENGTH_SHORT).show();
      //  videoView.setVideoURI( Uri.parse( "android.resource://" + getPackageName() + "/" + R.raw.a ) );





      /*  new CountDownTimer(3000, 1000) {
            public void onTick(long millisUntilFinished) {
                mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
               // Toast.makeText(MainActivity.this, "your text here ", Toast.LENGTH_SHORT).show();

                videoView.setVideoURI( Uri.parse( "android.resource://" + getPackageName() + "/" + R.raw.a ) );
            }
            public void onFinish() {
                mTextField.setText("done!");
            }
        }.start();  */


      /*  ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "your text here ", Toast.LENGTH_SHORT).show();
                        videoView.setVideoURI( Uri.parse( "android.resource://" + getPackageName() + "/" + R.raw.a ) );
                    }
                });
            }
        } ,5 , 5 , TimeUnit.SECONDS);  */



        FloatingActionButton buttonAddNote = findViewById( R.id.button_add_note );
        buttonAddNote.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, AddNoteActivity.class);
                startActivityForResult( intent,ADD_NOTE_REQUEST );
            }
        } );

        RecyclerView recyclerView =findViewById( R.id.recycler_view );
        recyclerView.setLayoutManager( new LinearLayoutManager( this ) );
        recyclerView.setHasFixedSize( true );

        final NoteAdapter adapter = new NoteAdapter();
        recyclerView.setAdapter( adapter );




        noteViewModel = ViewModelProviders.of( this ).get( NoteViewModel.class );
        noteViewModel.getAllNotes().observe( this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                adapter.submitList( notes );

                // update RecyclerView
               // Toast.makeText( MainActivity.this, "onChanged", Toast.LENGTH_SHORT ).show();
            }
        } );

        new ItemTouchHelper( new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT |
                ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                noteViewModel.delete( adapter.getNoteAt( viewHolder.getAdapterPosition() ) );
                Toast.makeText( MainActivity.this, "Note deleted", Toast.LENGTH_SHORT ).show();
            }
        } ).attachToRecyclerView( recyclerView );
   adapter.setOnClickItemClickListener( new NoteAdapter.OnItemClickListener() {
       @Override
       public void onItemClick(Note note) {
           Intent intent = new Intent( MainActivity.this, AddNoteActivity.class );
           intent.putExtra(  AddNoteActivity.EXTRA_ID, note.getId() );
           intent.putExtra( AddNoteActivity.EXTRA_TITLE, note.getTitle() );
           intent.putExtra( AddNoteActivity.EXTRA_DESCRIPTION,note.getDescription() );
           intent.putExtra( AddNoteActivity.EXTRA_PRIORITY, note.getPriority() );
            startActivityForResult( intent, EDIT_NOTE_REQUEST );

       }
   } );
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult( requestCode, resultCode, data );

        if(requestCode == ADD_NOTE_REQUEST && resultCode == RESULT_OK) {
            String title = data.getStringExtra( AddNoteActivity.EXTRA_TITLE );
            String description = data.getStringExtra( AddNoteActivity.EXTRA_DESCRIPTION );
            int priority = data.getIntExtra( AddNoteActivity.EXTRA_PRIORITY,1 );
            int phoneoremail = data.getIntExtra( AddNoteActivity.PHONE_OR_EMAIL,1 );

            Note note = new Note( title,description,priority,phoneoremail );
            noteViewModel.insert(note);

            Toast.makeText( this, "Note saved", Toast.LENGTH_SHORT ).show();
        }else if (requestCode == EDIT_NOTE_REQUEST && resultCode == RESULT_OK) {
            int id = data.getIntExtra( AddNoteActivity.EXTRA_ID, -1 );

            if(id == -1){
                Toast.makeText( this, "Note can't be updated", Toast.LENGTH_SHORT ).show();
                return;
            }
            String title = data.getStringExtra( AddNoteActivity.EXTRA_TITLE );
            String description = data.getStringExtra( AddNoteActivity.EXTRA_DESCRIPTION );
            int priority = data.getIntExtra( AddNoteActivity.EXTRA_PRIORITY,1 );

            Note note = new Note( title,description,priority );
            note.setId( id );
            noteViewModel.update( note );

            Toast.makeText( this, "Note updated", Toast.LENGTH_SHORT ).show();

        }else {
            Toast.makeText( this, "Note not saved", Toast.LENGTH_SHORT ).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate( R.menu.main_menu,menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case  R.id.delete_all_notes:
                noteViewModel.deleteAllNotes();  // Note note   هى هى
                Toast.makeText( this, "All notes deleted", Toast.LENGTH_SHORT ).show();
                return true;
            default:
                return super.onOptionsItemSelected( item );
                
        }



    }

}