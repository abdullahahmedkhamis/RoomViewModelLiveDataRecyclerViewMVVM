package roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.BroadcastReceiver;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Catcher extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "انتهى الوقت", Toast.LENGTH_SHORT).show();

    }
}
