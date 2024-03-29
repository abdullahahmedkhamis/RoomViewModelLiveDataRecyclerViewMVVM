package roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.example.roomviewmodellivedatarecyclerviewmvvm.R;

public class AddNoteActivity extends AppCompatActivity {
    public static final String EXTRA_ID =
            "roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.EXTRA_ID";
   public static final String EXTRA_TITLE =
           "roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION =
            "roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.EXTRA_DESCRIPTION";
    public static final String EXTRA_PRIORITY =
            "roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.EXTRA_PRIORITY";

    public static final String PHONE_OR_EMAIL =
            "roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.PHONE_OR_EMAIL";

    private EditText editTextTitle;
    private EditText editTextDescription;
    private NumberPicker numberPickerPriority;
    private EditText phoneoremail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_add_note );

        editTextTitle = (EditText) findViewById( R.id.edit_tetx_title );
        editTextDescription = (EditText) findViewById( R.id.edit_tetx_Description );
        numberPickerPriority = (NumberPicker) findViewById( R.id.number_picker_priority );
        phoneoremail = (EditText) findViewById( R.id.edit_tetx_PhneOrEmail );


        numberPickerPriority.setMinValue( 1 );
        numberPickerPriority.setMaxValue( 1000000 );

        getSupportActionBar().setHomeAsUpIndicator( R.drawable.ic_close );

        Intent intent = getIntent();

        if(intent.hasExtra( EXTRA_ID )){
            setTitle( "Edit Note" );
            editTextTitle.setText( intent.getStringExtra( EXTRA_TITLE ) );
            editTextDescription.setText( intent.getStringExtra( EXTRA_DESCRIPTION ) );
            numberPickerPriority.setValue( intent.getIntExtra( EXTRA_PRIORITY,1 ) );
            phoneoremail.setText( intent.getStringExtra(PHONE_OR_EMAIL) );
        }else {
            setTitle( "Add Note" );
        }
    }

    private void saveNote(){
        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();
        int priority = numberPickerPriority.getValue();
        String pe = phoneoremail.getText().toString();

        if(title.trim().isEmpty() || description.trim().isEmpty() || pe.trim().isEmpty()){
            Toast.makeText( this, "Please insert full data", Toast.LENGTH_SHORT ).show();
            return;
        }
        Intent data = new Intent(  );
        data.putExtra( EXTRA_TITLE,title );
        data.putExtra( EXTRA_DESCRIPTION,description );
        data.putExtra( EXTRA_PRIORITY,priority );
        data.putExtra( PHONE_OR_EMAIL,pe );

        int id = getIntent().getIntExtra(EXTRA_ID,-1);
        if(id != -1){
            data.putExtra( EXTRA_ID,id );
        }

        setResult( RESULT_OK,data );
        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate( R.menu.add_note_menu, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected( item );
        }

    }
}