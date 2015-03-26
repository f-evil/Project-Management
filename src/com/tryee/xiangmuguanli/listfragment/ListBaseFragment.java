package com.tryee.xiangmuguanli.listfragment;

import java.util.LinkedList;
import java.util.List;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.tryee.xiangmuguanli.ListActionActivity;
import com.tryee.xiangmuguanli.MainActivity;
import com.tryee.xiangmuguanli.R;
import com.tryee.xiangmuguanli.fragment.KaifaFragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public abstract class ListBaseFragment extends Fragment{

	protected Context ct;
	
	protected SlidingMenu sm;
	public View rootView;
	
	private ImageButton leftMenuBtn;
	
	private ImageButton rightMenuBtn;
	
	 private List<Activity> activityList=new LinkedList<Activity>();
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		sm = ((ListActionActivity) getActivity()).getSlidingMenu();
		initData(savedInstanceState);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ct = getActivity();
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
		rootView = initView(inflater);
		
		leftMenuBtn=(ImageButton)rootView.findViewById(R.id.ib_menu_left_two);
		leftMenuBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//((Activity) ct).finish();
				getActivity().finish();
				//System.exit(0);
				
			}
		});
		
		
		return rootView;
	}
	
	public View getRootView() {
		return rootView;
	}
	
	
	
	
	
	
	protected abstract View initView(LayoutInflater inflater);

	
	protected abstract void initData(Bundle savedInstanceState);

	
	protected abstract void setListener();
	
}
