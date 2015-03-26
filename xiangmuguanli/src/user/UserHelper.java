package user;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class UserHelper extends SQLiteOpenHelper{

	private static final String DATABASE_NAME = "user.db"; 
	private static final int DATABASE_VERSION = 1;
	
	public UserHelper(Context context ) {
		super(context, DATABASE_NAME,null, DATABASE_VERSION);
		// TODO 自动生成的构造函数存根
	}

	
	


	@Override
	public void onCreate(SQLiteDatabase db) {
		//项目列表
		db.execSQL("CREATE TABLE IF NOT EXISTS userAllxm (_id integer primary key autoincrement, " +
				"newid integer, name varchar(60), newcreate varchar(60),createtime varchar(60), state1 integer, state2 integer ," +
				" state3 integer , state4 integer , state5 integer , state6 integer , state7 integer , state8 integer)");
		
		//跟进管理
		db.execSQL("CREATE TABLE IF NOT EXISTS gj (_id integer primary key autoincrement, " +
				"content text,gjsj text,cjrname text,cjrid integer,xmid integer,xmmc text," +
				"gjjdzt integer,ifshare integer, jlsj text)");
		
		
		//阶段文案
		db.execSQL("CREATE TABLE IF NOT EXISTS jd (_id integer primary key autoincrement, " +
				"jdjj text,path text,htmlpath text,cjrname text, cjrid integer, xmid integer,xmmc text, wasj text, gjjdzt integer, jlsj text)");
		
		//合同管理
		db.execSQL("CREATE TABLE IF NOT EXISTS ht (_id integer primary key autoincrement, " +
				"htjj text,path text,htmlpath text,cjrname text, cjrid integer, xmid integer,xmmc text, htfbsj text,kssj text, jssj text,qdsj text,jfname text,gjjdzt text,ifshare integer ,jlsj text)");
		
		//开发管理
		db.execSQL("CREATE TABLE IF NOT EXISTS kf (_id integer primary key autoincrement, " +
				"kfjj text,path text, htmlpath text, cjrname text,cjrid integer,xmid integer,xmmc text,kffbsj text,gjjdzt integer,ifshare integer , jlsj text)");
		
		//测试管理
		db.execSQL("CREATE TABLE IF NOT EXISTS cs (_id integer primary key autoincrement, " +
				"csjj text,path text,htmlpath text,cjrname text, cjrid integer, xmid integer , xmmc text, csfbsj text , gjjdzt integer, ifshare integer, jlsj text)");
		
		
		//需求变更管理
		db.execSQL("CREATE TABLE IF NOT EXISTS xq (_id integer primary key autoincrement, " +
				"xqbgjj text , path text , htmlpath text , cjrname text , cjrid integer , xmid integer , xmmc text, sqbgfbsj text, gjjdzt integer , ifshare integer, jlsj text)");
		
		
		//收款结案管理
		db.execSQL("CREATE TABLE IF NOT EXISTS sk (_id integer primary key autoincrement, " +
				"skjajj text, path text, htmlpath text, cjrname text, cjrid integer, xmid integer, xmmc text, skjafbsj text, gjjdzt text, ifshare integer, jlsj text)");
		
		
		//项目完成管理
		db.execSQL("CREATE TABLE IF NOT EXISTS wc (_id integer primary key autoincrement, " +
				"wcxmjj text, path text, htmlpath text, cjrname text, cjrid integer, xmid integer, xmmc integer, wcxmfbsj text, gjjdzt integer, urlpath text, ifshare integer, jlsj text)");
		
		
		//售后管理
		db.execSQL("CREATE TABLE IF NOT EXISTS sh (_id integer primary key autoincrement, " +
				"shjj text, path text, htmlpath text, cjrname text, cjrid integer, xmid integer, xmmc text, shfbsj text, shlxr text, lxrhm text, fwwz text, jlsj text, deletezt integer, ifshare integer)");
		
		
//		db.execSQL("CREATE TABLE IF NOT EXISTS kf (_id integer primary key autoincrement, " +
//				")");
		
		
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO 自动生成的方法存根
		db.execSQL("DROP TABLE IF EXISTS userAllxm");
		db.execSQL("DROP TABLE IF EXISTS gj");
		onCreate(db);
	}}
