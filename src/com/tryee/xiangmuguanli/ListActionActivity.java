package com.tryee.xiangmuguanli;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.CanvasTransformer;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.tryee.xiangmuguanli.R.id;
import com.tryee.xiangmuguanli.fragment.HetongFragment;
import com.tryee.xiangmuguanli.fragment.KaifaFragment;

import android.R.integer;
import android.R.menu;
import android.animation.AnimatorSet.Builder;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.animation.Interpolator;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tryee.xiangmuguanli.fragment.*;
//import com.tryee.xiangmuguanli.listfragment.ListGenjinFragment;
import com.tryee.xiangmuguanli.listfragment.ListKongbaiFragment;

public class ListActionActivity extends SlidingFragmentActivity {
	
	private SlidingMenu sm;	
	private Fragment mContent;
	private ListMenuActivity mLeftMenu;
	//private ListGenjinFragment mGenjinFragment;
	private HomeFragmetList mHomeFragment;
	private CanvasTransformer mTransformer;
	private ListKongbaiFragment mKongbaiFragment;
	private HetongFragment mHetongFragment;
	public String id;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		
		

		Intent intent = getIntent();
		
		setId(intent.getStringExtra("id"));
		
		
		
		initAnimation();
		sm = getSlidingMenu();
		setContentView(R.layout.content_frame_two);
		setBehindContentView(R.layout.list_menu);
		sm.setSecondaryMenu(R.layout.lianxi);
		if (savedInstanceState == null) {
			mLeftMenu = new ListMenuActivity();
			//mRightMenu = new RightMenuFragment();
			//mGenjinFragment=new ListGenjinFragment();
			mHomeFragment = new HomeFragmetList();
			mKongbaiFragment = new ListKongbaiFragment();
			getSupportFragmentManager().beginTransaction().replace(R.id.list_menu2, mLeftMenu, "Left").commit();
			getSupportFragmentManager().beginTransaction().replace(R.id.content_fragment_two, mKongbaiFragment, "Home").commit();
			//getSupportFragmentManager().beginTransaction().replace(R.id.menu_right_frag, mRightMenu, "Right").commit();
		}
		sm.setSecondaryShadowDrawable(R.drawable.rightshadow); 
		//sm.setShadowDrawable(R.drawable.shadow); 
		sm.setShadowWidthRes(R.dimen.shadow_width); 
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset_2); 
		sm.setFadeDegree(0.25f); 
		sm.setBehindScrollScale(0.25f);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN); 
		sm.setMode(SlidingMenu.LEFT); 
		sm.setBehindCanvasTransformer(mTransformer); 
		sm.setBackgroundResource(R.drawable.bg1);
		
		
		Bundle bundle = new Bundle();
		bundle.putString("ID", intent.getStringExtra("id"));
		mLeftMenu.setArguments(bundle);
		
		
		
		
        

        
        
        
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
		getSupportFragmentManager().beginTransaction().replace(R.id.content_fragment_two, fragment).commit();
		getSlidingMenu().showContent();
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		getSupportFragmentManager().putFragment(outState, "Home", mContent);
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	
	


}
