package android.temperature;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class ConvertActivity extends Activity
{
	private EditText text;
	private TextView result;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		text = (EditText) findViewById(R.id.editText1);
		result = (TextView) findViewById(R.id.textView1);
		
		Resources res = getResources();
		Drawable shape = res. getDrawable(R.drawable.shape);

		TextView tv = (TextView)findViewById(R.id.textView1);
		tv.setBackgroundDrawable(shape);
	}

	// This method is called at button click because we assigned the name to the
	// "On Click property" of the button
	public void myClickHandler(View view)
	{
		switch (view.getId())
		{
		case R.id.button1:
			RadioButton celsiusButton = (RadioButton) findViewById(R.id.radio0);
			RadioButton fahrenheitButton = (RadioButton) findViewById(R.id.radio1);
			if (text.getText().length() == 0)
			{
				Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_LONG).show();
				return;
			}

			float inputValue = Float.parseFloat(text.getText().toString());
			if (celsiusButton.isChecked())
			{
				text.setText(String.valueOf(convertFahrenheitToCelsius(inputValue)));
				celsiusButton.setChecked(false);
				fahrenheitButton.setChecked(true);
				result.setText(inputValue + " degrees celsius");
			}
			else
			{
				text.setText(String.valueOf(convertCelsiusToFahrenheit(inputValue)));
				fahrenheitButton.setChecked(false);
				celsiusButton.setChecked(true);
				result.setText(inputValue + " degrees fahrenheit");
			}
			break;
		}
	}

	// Converts to celsius
	private float convertFahrenheitToCelsius(float fahrenheit)
	{
		return ((fahrenheit - 32) * 5 / 9);
	}

	// Converts to fahrenheit
	private float convertCelsiusToFahrenheit(float celsius)
	{
		return ((celsius * 9) / 5) + 32;
	}
}