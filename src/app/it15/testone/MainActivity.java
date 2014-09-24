package app.it15.testone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
private Button Calc, Show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Show = (Button) findViewById(R.id.btnShow_488);
        Calc = (Button) findViewById(R.id.btnCalc_488);
        Calc.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent m = new Intent(getApplicationContext(),AddActivity.class);
				startActivity(m);
				
			}
		});
        Show.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent n = new Intent(getApplicationContext(),ShowDataActivity_488.class);
				startActivity(n);
				
			}
		});
    }
}
