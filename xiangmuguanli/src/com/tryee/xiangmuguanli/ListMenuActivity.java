package com.tryee.xiangmuguanli;

import com.tryee.xiangmuguanli.fragment.*;
import com.tryee.xiangmuguanli.listfragment.ListBaseFragment;
import com.tryee.xiangmuguanli.listfragment.ListCeshiFragment;
import com.tryee.xiangmuguanli.listfragment.ListDanganFragment;
import com.tryee.xiangmuguanli.listfragment.ListGenjinFragment;
//import com.tryee.xiangmuguanli.listfragment.ListGenjinFragment;
import com.tryee.xiangmuguanli.listfragment.ListHetongFragment;
import com.tryee.xiangmuguanli.listfragment.ListKaifaFragment;
import com.tryee.xiangmuguanli.listfragment.ListKongbaiFragment;
import com.tryee.xiangmuguanli.listfragment.ListQuerenFragment;
import com.tryee.xiangmuguanli.listfragment.ListShouhouFragment;
import com.tryee.xiangmuguanli.listfragment.ListShoukuanFragment;
import com.tryee.xiangmuguanli.listfragment.ListXuqiuFragment;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class ListMenuActivity extends Fragment implements OnClickListener{
	private Activity mActivity;
	private Activity xActivity;
	private ListActionActivity lAct;
	private View view;
	public static Dialog dialog;
	
	private String newid;
	private String aString;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.list_menu, null);
		lAct=(ListActionActivity)getActivity();
		view.findViewById(R.id.genjin_ry_list).setOnClickListener(this);
		view.findViewById(R.id.dangan_ry_list).setOnClickListener(this);
		view.findViewById(R.id.hetong_ry_list).setOnClickListener(this);
		view.findViewById(R.id.kaifa_ry_list).setOnClickListener(this);
		view.findViewById(R.id.ceshi_ry_list).setOnClickListener(this);
		view.findViewById(R.id.xuqiu_ry_list).setOnClickListener(this);
		view.findViewById(R.id.shoukuan_ry_list).setOnClickListener(this);
		view.findViewById(R.id.wancheng_ry_list).setOnClickListener(this);
		view.findViewById(R.id.shouhou_ry_list).setOnClickListener(this);
		mActivity = this.getActivity();
		xActivity = this.getActivity();
		
		
		Bundle bundle = getArguments();
		aString = bundle.getString("ID");
		//Toast.makeText(getActivity(), aString, Toast.LENGTH_LONG).show();
		
		
		return view;
	}
	
	
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		ListBaseFragment fragment=null;
		switch (v.getId()) {
		case R.id.genjin_ry_list:
			fragment = new ListGenjinFragment();
			
			Bundle bundle = new Bundle();
			bundle.putString("ID", aString);
			fragment.setArguments(bundle);
			break;
		case R.id.dangan_ry_list:
			fragment=new ListDanganFragment();
			Bundle bundle1 = new Bundle();
			bundle1.putString("ID", aString);
			fragment.setArguments(bundle1);
			break;
		case R.id.hetong_ry_list:
			fragment = new ListHetongFragment();
			Bundle bundle2 = new Bundle();
			bundle2.putString("ID", aString);
			fragment.setArguments(bundle2);
			break;
		case R.id.kaifa_ry_list:
			fragment = new ListKaifaFragment();
			Bundle bundle3 = new Bundle();
			bundle3.putString("ID", aString);
			fragment.setArguments(bundle3);
			break;
		case R.id.ceshi_ry_list:
			fragment = new ListCeshiFragment();
			Bundle bundle4 = new Bundle();
			bundle4.putString("ID", aString);
			fragment.setArguments(bundle4);
			break;
		case R.id.xuqiu_ry_list:
			fragment = new ListXuqiuFragment();
			Bundle bundle5 = new Bundle();
			bundle5.putString("ID", aString);
			fragment.setArguments(bundle5);
			break;
		case R.id.shoukuan_ry_list:
			fragment = new ListShoukuanFragment();
			Bundle bundle6 = new Bundle();
			bundle6.putString("ID", aString);
			fragment.setArguments(bundle6);
			break;
		case R.id.wancheng_ry_list:
			fragment = new ListQuerenFragment();
			Bundle bundle7 = new Bundle();
			bundle7.putString("ID", aString);
			fragment.setArguments(bundle7);
			break;
			
		case R.id.shouhou_ry_list:
			fragment = new ListShouhouFragment();
			Bundle bundle8 = new Bundle();
			bundle8.putString("ID", aString);
			fragment.setArguments(bundle8);
			break;
			
			
		default:
			break;
		}
		
		if(fragment == null){
			fragment = new ListKongbaiFragment();
		}
		lAct.switchContent(fragment);
		
		
		fragment = null;
	}



	public String getNewid() {
		return newid;
	}



	public void setNewid(String newid) {
		this.newid = newid;
	}



	

}
