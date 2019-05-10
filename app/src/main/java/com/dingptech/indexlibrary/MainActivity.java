package com.dingptech.indexlibrary;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.dingptech.indexslibrary.BaseViewHolder;
import com.dingptech.indexslibrary.IndexRecycleAdapter;
import com.dingptech.indexslibrary.IndexTouchListener;
import com.dingptech.indexslibrary.LetterIndexView;
import com.dingptech.indexslibrary.ListSort;
import com.dingptech.indexslibrary.TextBean;
import com.dingptech.indexslibrary.TopLayoutManager;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private LetterIndexView letterIndexView;
    private List<String> list = new ArrayList();
    private List<TextBean> list1 = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rv);
        letterIndexView = findViewById(R.id.liv);
        lisadd();
        list1= ListSort.sort(list);
        Log.e("hjy",new Gson().toJson( ListSort.list()) );
        PersonAdapter adapter = new PersonAdapter(this, list1, R.layout.person_recycler_item);
        rv.setAdapter(adapter);
        TopLayoutManager manager = new TopLayoutManager(this, TopLayoutManager.VERTICAL, false);
        rv.setLayoutManager(manager);
        letterIndexView.setOnLetterTouchListener(new IndexTouchListener() {
            @Override
            public void onTouch(String letter, boolean isTouch) {
                for (int i = 0; i < list1.size(); i++) {
                    if (letter.equals(list1.get(i).getPinyin().charAt(0) + "")) {
                        rv.smoothScrollToPosition(i);
                        break;
                    }
                }
            }
        });
    }

    private class PersonAdapter extends IndexRecycleAdapter<TextBean> {
        public PersonAdapter(Context context, List<TextBean> mData, int layoutId) {
            super(context, mData, layoutId);
        }

        @Override
        protected void convert(BaseViewHolder holder, TextBean person, int position) {
            String currentWord = person.getPinyin().charAt(0) + "";
            Log.e("hjy", currentWord );
            if (position > 0) {
                String lastWord = list1.get(position - 1).getPinyin().charAt(0) + "";
                //拿当前的首字母和上一个首字母比较,与首字母相同，需要隐藏当前item的索引
                holder.setVisibility(R.id.indexTv, currentWord.equals(lastWord) ? View.GONE : View.VISIBLE);
            } else {
                holder.setVisibility(R.id.indexTv, View.VISIBLE);
            }
            holder.setText(R.id.indexTv, currentWord);
            holder.setText(R.id.userNameTv, person.getName());
        }
    }

    private void lisadd() {
        list.add("宋江");
        list.add("卢俊义");
        list.add("吴用");
        list.add("公孙胜");
        list.add("关胜");
        list.add("林冲");
        list.add("秦明");
        list.add("呼延灼");
        list.add("花荣");
        list.add("柴进");
        list.add("李应");
        list.add("朱仝");
        list.add("鲁智深");
        list.add("张横");
        list.add("武松");
        list.add("董平");
        list.add("张清");
        list.add("杨志");
        list.add("徐宁");
        list.add("索超");
        list.add("李俊");
        list.add("戴宗");
        list.add("刘唐");
        list.add("李逵");
        list.add("史进");
        list.add("穆弘");
        list.add("雷横");
        list.add("阮小二");
        list.add("阮小五");
        list.add("张顺");
        list.add("阮小七");
        list.add("杨雄");
        list.add("石秀");
        list.add("解珍");
        list.add("施恩");
        list.add("解宝");
        list.add("燕青");
        list.add("朱武");
        list.add("黄信");
        list.add("孙立");
        list.add("宣赞");
        list.add("郝思文");
        list.add("韩滔");
        list.add("彭玘");
        list.add("单廷珪");
        list.add("魏定国");
        list.add("萧让");
        list.add("裴宣");
        list.add("欧鹏");
        list.add("邓飞");
        list.add("燕顺");
        list.add("杨林");
        list.add("凌振");
        list.add("蒋敬");
        list.add("吕方");
        list.add("郭盛");
        list.add("安道全");
        list.add("皇甫端");
        list.add("王英");
        list.add("扈三娘");
        list.add("鲍旭");
        list.add("樊瑞");
        list.add("孔明");
        list.add("孔亮");
        list.add("项充");
        list.add("李衮");
        list.add("金大坚");
        list.add("马麟");
        list.add("童威");
        list.add("童猛");
        list.add("孟康");
        list.add("侯健");
        list.add("陈达");
        list.add("杨春");
        list.add("郑天寿");
        list.add("陶宗旺");
        list.add("宋清");
        list.add("乐和");
        list.add("龚旺");
        list.add("丁得孙");
        list.add("穆春");
        list.add("曹正");
        list.add("宋万");
        list.add("杜迁");
        list.add("薛永");
    }
}
