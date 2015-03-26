package com.tryee.xiangmuguanli;

import com.tryee.xiangmuguanli.fragment.*;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class LeftMenuFragment extends Fragment implements OnClickListener{
	private Activity mActivity;
	private Activity xActivity;
	private MainActivity mAct;
	private View view;
	public static Dialog dialog;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			ViewGroup container,  Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.slidingmenu_left, null);
		mAct = (MainActivity) getActivity();
		view.findViewById(R.id.xiangmu_ry).setOnClickListener(this);
		view.findViewById(R.id.shoucang_ry).setOnClickListener(this);
		view.findViewById(R.id.xiazai_ry).setOnClickListener(this);
		view.findViewById(R.id.lishi_ry).setOnClickListener(this);/*Activity为KaifaActivity*/
		view.findViewById(R.id.wodexiangmu_ry).setOnClickListener(this);
		view.findViewById(R.id.touxiang_ry_2).setOnClickListener(this);
		view.findViewById(R.id.lixian_ry).setOnClickListener(this);
		mActivity = this.getActivity();
		xActivity = this.getActivity();
		
		
		
		
		
		return view;
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		BaseFragment fragment = null;
		switch (v.getId()) {
		
		case R.id.touxiang_ry_2:
			Intent xiugaiIntent = new Intent(xActivity,GerenActivity.class);
			//xActivity.finish();
			startActivity(xiugaiIntent);
			//fragment = new LishiFragment();
			break;
		
		case R.id.wodexiangmu_ry:
			fragment = new WodexiangmuFragment();
			break;
			
			
			
		case R.id.lishi_ry:
//			Intent intent = new Intent(mActivity,KaifaFragment.class);
//			startActivity(intent);
			fragment = new HomeFragment();
			break;
			
			
			
		case R.id.xiangmu_ry:
			fragment = new KaifaFragment();
			break;
		case R.id.shoucang_ry:
			fragment = new ShoucangFragment();
			break;
		case R.id.xiazai_ry:
			fragment = new XiazaiFragment();
			break;
		
		case R.id.lixian_ry:
			
			dialog = ProgressDialog.show(getActivity(), null, "下载中...");
			 
			Toast.makeText(getActivity(), "下载中", Toast.LENGTH_SHORT).show();
			 
			Thread thread=new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Thread.sleep(5000);
						
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					dialog.dismiss();
					
				}
			});
			thread.start();
			 break;
			
		
		default:
			break;
		}
		if(fragment == null){
			fragment = new HetongFragment();
		}
		mAct.switchContent(fragment);
		
		
		fragment = null;
	}
	
	

}
