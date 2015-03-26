package com.tryee.xiangmuguanli;


import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;


public class TouxiangActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_touxiang);
		
		ImageButton touxiang_back=(ImageButton)findViewById(R.id.touxiang_back);
		touxiang_back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent touxiangIntent=new Intent(TouxiangActivity.this,GerenActivity.class);
				startActivity(touxiangIntent);
			}
		});
		
		
		
		
		
		
		
		
		
		
	}
	

	

}
