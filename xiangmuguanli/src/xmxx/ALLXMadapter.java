package xmxx;

import java.util.ArrayList;
import java.util.List;

import path.WordUtil;

import com.tryee.xiangmuguanli.R;

import model.Allxm;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ALLXMadapter extends BaseAdapter{
	private Handler handler;
	private Context context;
	private ArrayList<Allxm> list;
	private ArrayList<Allxm> getList;
	LayoutInflater inflater;
	
	public ALLXMadapter(Context context,ArrayList<Allxm> list){
		this.context = context;

		this.getList = list;
		list = (ArrayList<Allxm>)getList.clone();
		this.notifyDataSetInvalidated();
		
		
		inflater = LayoutInflater.from(context);
	}
	public ALLXMadapter(Context context){
		this.context = context;
		inflater = LayoutInflater.from(context);
	}
//	public ALLXMadapter(View view){
//		this.context = view;
//	}
	




	public int getCount(){
		if (list == null) {
			return 0;
		}
		return list.size();
	}
	
	public Object getItem(int position){
		if (list!=null) {
			return list.get(position);
		}
		return null;
	}
	
	public long getItemId(int position){
		return position;
	}

	public View getView(int postion,View convertView,ViewGroup root){
		ItemView itemView = null;
		if (itemView == null) {
			itemView = new ItemView();
			
			convertView = inflater.inflate(R.layout.allxmlist, null);
			itemView.listName = (TextView)convertView.findViewById(R.id.Name);
			itemView.listCreate = (TextView)convertView.findViewById(R.id.Create);
			//itemView.listId = (TextView)convertView.findViewById(R.id.listId);
			itemView.listCreateTime = (TextView)convertView.findViewById(R.id.CreateTime);
			itemView.stateImage1 = (ImageView)convertView.findViewById(R.id.imagestete1);
			itemView.stateImage2 = (ImageView)convertView.findViewById(R.id.imagestete2);
			itemView.stateImage3 = (ImageView)convertView.findViewById(R.id.imagestete3);
			itemView.stateImage4 = (ImageView)convertView.findViewById(R.id.imagestete4);
			itemView.stateImage5 = (ImageView)convertView.findViewById(R.id.imagestete5);
			itemView.stateImage6 = (ImageView)convertView.findViewById(R.id.imagestete6);
			itemView.stateImage7 = (ImageView)convertView.findViewById(R.id.imagestete7);
			itemView.stateImage8 = (ImageView)convertView.findViewById(R.id.imagestete8);
			convertView.setTag(itemView);
			
		}else{
			itemView = (ItemView)convertView.getTag();
		}
		
		
		
		
		Allxm ax = list.get(postion);
		itemView.stateImage1.setImageResource(XMXXActivity.stateImage[ax.getState1()]);
		itemView.stateImage2.setImageResource(XMXXActivity.stateImage[ax.getState2()]);
		itemView.stateImage3.setImageResource(XMXXActivity.stateImage[ax.getState3()]);
		itemView.stateImage4.setImageResource(XMXXActivity.stateImage[ax.getState4()]);
		itemView.stateImage5.setImageResource(XMXXActivity.stateImage[ax.getState5()]);
		itemView.stateImage6.setImageResource(XMXXActivity.stateImage[ax.getState6()]);
		itemView.stateImage7.setImageResource(XMXXActivity.stateImage[ax.getState7()]);
		itemView.stateImage8.setImageResource(XMXXActivity.stateImage[ax.getState8()]);
		//itemView.listId.setText(ax.getId()+"");
		itemView.listName.setText(ax.getName());
		itemView.listCreate.setText(ax.getCreate());
		itemView.listCreateTime.setText(ax.getCreatetime());
		//convertView.setBackgroundColor(Color.BLACK);
		return convertView;
	}





	public class ItemView{
		public TextView listName;
		public TextView listCreate;
		//public TextView listId;
		public TextView listCreateTime;
		public ImageView stateImage1;
		public ImageView stateImage2;
		public ImageView stateImage3;
		public ImageView stateImage4;
		public ImageView stateImage5;
		public ImageView stateImage6;
		public ImageView stateImage7;
		public ImageView stateImage8;
		
		
		
	}

	public List<Allxm> getGetList() {
		return getList;
	}

	public void searchData(String word){
		if(word == null || word == ""){
			this.list = (ArrayList<Allxm>)this.getList.clone();
		}else {
			dataFilter(word);
		}
		this.notifyDataSetInvalidated();
	}





	public void setGetList(ArrayList<Allxm> getList) {
		
		this.getList = getList;
		list = (ArrayList<Allxm>)getList.clone();
		this.notifyDataSetInvalidated();
		
	}
	
	private void dataFilter(String word){
		list.clear();
		int listsize = getList.size();
		for(int i = 0;i<listsize;i++){
			Allxm allxm = getList.get(i);
			if(allxm.getName().contains(word) || allxm.getCreate().contains(word) || (allxm.getId()+"").contains(word)){
				list.add(allxm);
			}else if(WordUtil.getSpells(allxm.getName()).contains(word.toLowerCase()) || WordUtil.getSpells(allxm.getCreate()).contains(word.toLowerCase())
					|| WordUtil.getSpells((allxm.getId()+"")).contains(word.toLowerCase())) {
				 list.add(allxm);
			}
			
		}
		
		
	}

	
}



//package xmxx;
//
//import java.util.List;
//
//import com.tryee.xiangmuguanli.R;
//
//
//import android.content.Context;
//import android.graphics.Color;
//import android.os.Handler;
//import android.util.AttributeSet;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//public class ALLXMadapter extends BaseAdapter{
//	private Handler handler;
//	private Context context;
//	private List<Allxm> list;
//	LayoutInflater inflater;
//	
//	public ALLXMadapter(Context context,List<Allxm> list){
//		this.context = context;
//		this.list = list;
//		inflater = LayoutInflater.from(context);
//	}
//	
//
//
//
//
//
//	public int getCount(){
//		return list.size();
//	}
//	
//	public Object getItem(int position){
//		return list.get(position);
//	}
//	
//	public long getItemId(int position){
//		return position;
//	}
//
//	public View getView(int postion,View convertView,ViewGroup root){
//		
//		convertView = inflater.inflate(R.layout.allxmlist, null);
//		TextView listId = (TextView)convertView.findViewById(R.id.listId);
//		TextView listName = (TextView)convertView.findViewById(R.id.Name);
//		TextView listCreate = (TextView)convertView.findViewById(R.id.Create);
//		TextView listCreateTime = (TextView)convertView.findViewById(R.id.CreateTime);
//		ImageView stateImage1 = (ImageView)convertView.findViewById(R.id.imagestete1);
//		ImageView stateImage2 = (ImageView)convertView.findViewById(R.id.imagestete2);
//		ImageView stateImage3 = (ImageView)convertView.findViewById(R.id.imagestete3);
//		ImageView stateImage4 = (ImageView)convertView.findViewById(R.id.imagestete4);
//		ImageView stateImage5 = (ImageView)convertView.findViewById(R.id.imagestete5);
//		ImageView stateImage6 = (ImageView)convertView.findViewById(R.id.imagestete6);
//		ImageView stateImage7 = (ImageView)convertView.findViewById(R.id.imagestete7);
//		ImageView stateImage8 = (ImageView)convertView.findViewById(R.id.imagestete8);
//		
//		
//		Allxm ax = list.get(postion);
//		stateImage1.setImageResource(XMXXActivity.stateImage[ax.getState1()]);
//		stateImage2.setImageResource(XMXXActivity.stateImage[ax.getState2()]);
//		stateImage3.setImageResource(XMXXActivity.stateImage[ax.getState3()]);
//		stateImage4.setImageResource(XMXXActivity.stateImage[ax.getState4()]);
//		stateImage5.setImageResource(XMXXActivity.stateImage[ax.getState5()]);
//		stateImage6.setImageResource(XMXXActivity.stateImage[ax.getState6()]);
//		stateImage7.setImageResource(XMXXActivity.stateImage[ax.getState7()]);
//		stateImage8.setImageResource(XMXXActivity.stateImage[ax.getState8()]);
//		listId.setText(ax.getId()+"");
//		listName.setText(ax.getName());
//		listCreate.setText(ax.getCreate());
//		listCreateTime.setText(ax.getCreatetime());
//		//convertView.setBackgroundColor(Color.BLACK);
//		return convertView;
//	}
//	
//	
//	
//}
