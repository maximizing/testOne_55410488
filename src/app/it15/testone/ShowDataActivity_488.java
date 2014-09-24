package app.it15.testone;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ShowDataActivity_488 extends Activity {
private ListView listView;
@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_488);
		listView = (ListView) findViewById(R.id.listView1_488);
		ControlDB488 control488db = new ControlDB488(this);
		ArrayList<HashMap<String, String>> MyArrayList = control488db.SelectAllData();
		SimpleAdapter adapter;
		adapter = new SimpleAdapter(ShowDataActivity_488.this, MyArrayList, R.layout.show_item_488, new String[]{"userID","Name","Score","Grade"},new int[]{R.id.ColuserID_488,R.id.ColName_488,R.id.ColScore_488,R.id.ColGrade_488});
		listView.setAdapter(adapter);
	}
}
