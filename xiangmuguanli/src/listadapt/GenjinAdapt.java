package listadapt;



import java.util.ArrayList;
import java.util.List;

import com.tryee.xiangmuguanli.R;



import model.Allxm;
import model.GJ;


import android.R.integer;
//import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class GenjinAdapt extends BaseAdapter {
	private Handler handle;
	private Context context;

	private ArrayList<GJ> getList;
	LayoutInflater inflater;
	
	public GenjinAdapt(Context context,ArrayList<GJ> list){
		this.context=context;
		this.getList=list;
		//list=(ArrayList<GJ>)getList.clone();
		this.notifyDataSetInvalidated();
		inflater=LayoutInflater.from(context);
	}
	
	public GenjinAdapt(Context context){
		this.context=context;
		inflater=LayoutInflater.from(context);
	}
	
	public int getCount(){
		if (getList==null) {
			return 0;
		}
		return getList.size();
	}
	
	public Object getItem(int position) {
		if (getList!=null) {
			return getList.get(position);
		}
		return null;
	}
	
	

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ItemView itemView=null;
		if (itemView==null) {
			itemView=new ItemView();
			
			convertView=inflater.inflate(R.layout.list_genjin_type, null);
			itemView.listUser=(TextView)convertView.findViewById(R.id.user);
			itemView.listDaTe=(TextView)convertView.findViewById(R.id.date);
			itemView.list_4=(TextView)convertView.findViewById(R.id.list_4);
			convertView.setTag(itemView);
			
		}else {
			itemView=(ItemView)convertView.getTag();
		}
		
		
		GJ gj = getList.get(position);
		itemView.listUser.setText(gj.getCjrname());
		itemView.listDaTe.setText(gj.getGjsj());
		itemView.list_4.setText(gj.getContent());
		
		

		return convertView;
	}
	
	public class ItemView{
		public TextView listUser;
		public TextView listDaTe;
		public TextView list_4;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	
	public void setGetList(ArrayList<GJ> getList) {
		
		this.getList = getList;
		//list = (ArrayList<GJ>)getList.clone();
		this.notifyDataSetInvalidated();
		
	}
	
}
