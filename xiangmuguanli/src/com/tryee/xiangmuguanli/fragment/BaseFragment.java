package com.tryee.xiangmuguanli.fragment;


import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.tryee.xiangmuguanli.ExitApp;
import com.tryee.xiangmuguanli.MainActivity;
import com.tryee.xiangmuguanli.R;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public abstract class BaseFragment extends Fragment implements OnClickListener{
	
	protected Context ct;
	
	protected SlidingMenu sm;
	public View rootView;
	protected Activity MenuChangeHome;
	
	private ImageButton leftMenuBtn;
	
	private ImageButton rightMenuBtn;
	
	@Override
	public void onActivityCreated( Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		sm = ((MainActivity) getActivity()).getSlidingMenu();
		initData(savedInstanceState);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ct = getActivity();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
		rootView = initView(inflater);
		leftMenuBtn = (ImageButton) rootView.findViewById(R.id.ib_menu_left);
		//rightMenuBtn = (ImageButton) rootView.findViewById(R.id.ib_menu_right);
		leftMenuBtn.setOnClickListener(this);
		//rightMenuBtn.setOnClickListener(this);
		
		//rightMenuBtn=(ImageButton)rootView.findViewById(R.id.finish);
		//rightMenuBtn.setOnClickListener(this);
		
		
		setListener();
		
		
		

		
		return rootView;
	}

	public View getRootView() {
		return rootView;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.ib_menu_left: 
			sm.toggle();
			break;
		//case R.id.ib_menu_right: 
			//sm.showSecondaryMenu();
			//break;
		//case R.id.finish:
			//getActivity().finish();
			//break;
		default:
			break;
		}
	}
	
	protected abstract View initView(LayoutInflater inflater);

	
	protected abstract void initData(Bundle savedInstanceState);

	
	protected abstract void setListener();

}
