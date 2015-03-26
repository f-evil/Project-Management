package listadapt;

import java.util.ArrayList;

import com.tryee.xiangmuguanli.R;

import listadapt.KaifaAdapt.ItemView;
import model.CS;
import model.KF;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CeshiAdapt extends BaseAdapter {
	
	private ArrayList<CS> getList;
	LayoutInflater inflater;
	
	public CeshiAdapt(Context context,ArrayList<CS> list){
		this.getList=list;
		this.notifyDataSetInvalidated();
		inflater=LayoutInflater.from(context);
	}
	
	public CeshiAdapt(Context context){
		inflater=LayoutInflater.from(context);
	}
	
	
	

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if (getList==null) {
			return 0;
		}
		return getList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		if (getList!=null) {
			return getList.get(position);
		}
		
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ItemView itemView=null;
		if(itemView==null){
			itemView=new ItemView();
			
			convertView=inflater.inflate(R.layout.list_ceshi_type, null);
			itemView.listUser=(TextView)convertView.findViewById(R.id.user);
			itemView.listDaTe=(TextView)convertView.findViewById(R.id.date);
			itemView.list_4=(TextView)convertView.findViewById(R.id.list_4);
			convertView.setTag(itemView);
		}else {
			itemView=(ItemView)convertView.getTag();
		}
		
		CS cs=getList.get(position);
		itemView.listUser.setText(cs.getCjrname());
		itemView.listDaTe.setText(cs.getCsfbsj());
		itemView.list_4.setText(cs.getCsjj());
		
		
		
		
		return convertView;
	}

	
	public class ItemView{
		public TextView listUser;
		public TextView listDaTe;
		public TextView list_4;
	}
	
	public void setGetList(ArrayList<CS> getList) {
		
		this.getList = getList;
		//list = (ArrayList<GJ>)getList.clone();
		this.notifyDataSetInvalidated();
		
	}
}
