package app.it15.testone;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends Activity {
private EditText e1,e2,e3;
private Button save;
@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_488);
		save = (Button) findViewById(R.id.btnSave_488);
		save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(v == save){
					save();
					Intent intent = new Intent(getApplicationContext(),MainActivity.class);
					startActivity(intent);
				}
			}
		});
			}
	
			private boolean save() {
				e1 = (EditText) findViewById(R.id.e1_488);
				e2 = (EditText) findViewById(R.id.e2_488);
				
				final AlertDialog .Builder adb = new AlertDialog.Builder(this);
				AlertDialog ad = adb.create();
				if(e1.getText().length() == 0){
					ad.setMessage("Please input name");
					e1.requestFocus();
					return false;
				}
				if(e2.getText().length() == 0){
					ad.setMessage("Please input Score");
					e2.requestFocus();
					return false;
				}
				ControlDB488 dbclass = new ControlDB488(this);
				long savedata = dbclass.InsertData(e1.getText().toString(), e2.getText().toString(),null);
				if(savedata <= 0){
					ad.setMessage("Error !!!");
					ad.show();
					return false;
				}
				Toast.makeText(getApplicationContext(),"Add Data Successfully", Toast.LENGTH_SHORT).show();
				return true;
			}	
}
