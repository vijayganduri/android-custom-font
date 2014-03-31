package com.vijayganduri.customfont;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * 
 * 
 * @Author Vijay Ganduri
 */
public class MainActivity extends Activity {

	TextView _textView1;
	TextView _textView2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		_textView1 = (TextView)findViewById(R.id.textView1);
		_textView2 = (TextView)findViewById(R.id.textView2);

		//use _textView1 & _textView2 as usual

	}

}