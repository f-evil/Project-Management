package com.tryee.xiangmuguanli;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.Window;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.CanvasTransformer;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.tryee.xiangmuguanli.R.color;
import com.tryee.xiangmuguanli.fragment.HetongFragment;




public class MainActivity extends SlidingFragmentActivity {
		
	private SlidingMenu sm;	
	private Fragment mContent;
	private LeftMenuFragment mLeftMenu;
	//private RightMenuFragment mRightMenu;
	private HomeFragment mHomeFragment;
	private CanvasTransformer mTransformer;
	private HetongFragment mHetongFragment;
	private String name=null;
	
	@SuppressLint("ResourceAsColor")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		initAnimation();
		sm = getSlidingMenu();
		setContentView(R.layout.content_frame);
		setBehindContentView(R.layout.slidingmenu_left);
		sm.setSecondaryMenu(R.layout.lianxi);
		if (savedInstanceState == null) {
			mLeftMenu = new LeftMenuFragment();
			//mRightMenu = new RightMenuFragment();
			mHomeFragment = new HomeFragment();
			mHetongFragment = new HetongFragment();
			getSupportFragmentManager().beginTransaction().replace(R.id.slidemenu_left_LL, mLeftMenu, "Left").commit();
			getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, mHetongFragment, "Home").commit();
			//getSupportFragmentManager().beginTransaction().replace(R.id.menu_right_frag, mRightMenu, "Right").commit();
		}
		sm.setSecondaryShadowDrawable(R.drawable.rightshadow); 
		//sm.setShadowDrawable(R.drawable.shadow); 
		sm.setShadowWidthRes(R.dimen.shadow_width); 
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset); 
		sm.setFadeDegree(0.25f); 
		sm.setBehindScrollScale(0.25f);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN); 
		sm.setMode(SlidingMenu.LEFT); 
		sm.setBehindCanvasTransformer(mTransformer); 
		sm.setBackgroundResource(R.drawable.m_bg_1);
		
		sm.setAboveCanvasTransformer(new SlidingMenu.CanvasTransformer() {
			
			@Override
			public void transformCanvas(Canvas canvas, float percentOpen) {
				// TODO Auto-generated method stub
				float scale = (float) (1 - percentOpen * 0.25);
				canvas.scale(scale, scale, 0, canvas.getHeight() / 2);
			}
		});
		
		
		
		Intent intent=getIntent();
		name=intent.getStringExtra("name");
		
		TextView textView=(TextView)findViewById(R.id.textView21);
		if (name==null) {
			textView.setText("创艺工作组");
			//textView.setTextColor(android.R.color.white);
		}else {
			textView.setText(name);
			//textView.setTextColor(android.R.color.white);
		}	
		
		
		
		
	}
	
	
	
	
	
	private void initAnimation() {
		mTransformer = new CanvasTransformer() {
			@Override
			public void transformCanvas(Canvas canvas, float percentOpen) {
				canvas.scale(interp.getInterpolation(percentOpen), interp.getInterpolation(percentOpen), 
						canvas.getWidth() / 2, canvas.getHeight() / 2);
				// canvas.translate(0, canvas.getHeight() * (1 -
				// interp.getInterpolation(percentOpen))); 
				// canvas.scale(percentOpen, 1, 0, 0); 
//				float scale = (float) (percentOpen * 0.25 + 0.75);
//				canvas.scale(scale, scale, canvas.getWidth() / 2,
//						canvas.getHeight() / 2);
			}

		};
		

	}
		
	private static Interpolator interp = new Interpolator() {
			@Override
			public float getInterpolation(float t) {
				t -= 1.0f;
				return t * t * t + 1.0f;
			}
		};
	


	
	public void switchContent(Fragment fragment) {
		mContent = fragment;
		getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
		getSlidingMenu().showContent();
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
	getSupportFragmentManager().putFragment(outState, "Home", mContent);
		
	}
	
	
}
