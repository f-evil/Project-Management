package com.tryee.xiangmuguanli;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class LianxiActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.id.lianxi);
	}

}
