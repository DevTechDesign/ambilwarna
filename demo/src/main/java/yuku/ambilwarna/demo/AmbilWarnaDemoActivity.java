package yuku.ambilwarna.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import yuku.ambilwarna.AmbilWarnaDialog;

public class AmbilWarnaDemoActivity extends Activity {
	TextView text1;
	int color = 0xffffff00;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		final View button1 = findViewById(R.id.button1);
		text1 = (TextView) findViewById(R.id.text1);
		displayColor();

		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				openDialog(false);
			}
		});

	}

	void openDialog(boolean supportsAlpha) {
		AmbilWarnaDialog dialog = new AmbilWarnaDialog(AmbilWarnaDemoActivity.this, color, supportsAlpha, new AmbilWarnaDialog.OnAmbilWarnaListener() {
			@Override
			public void onOk(AmbilWarnaDialog dialog, int color) {
				AmbilWarnaDemoActivity.this.color = color;
				displayColor();
				dialog.getDialog().dismiss();
			}

			@Override
			public void onCancel(AmbilWarnaDialog dialog) {
				dialog.getDialog().dismiss();
			}
		});
		dialog.show();
	}

	void displayColor() {
		text1.setText(String.format("Current color: 0x%08x", color));
	}
}