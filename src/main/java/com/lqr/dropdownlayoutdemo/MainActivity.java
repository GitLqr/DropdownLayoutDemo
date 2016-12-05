package com.lqr.dropdownlayoutdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.lqr.dropdownlayoutdemo.views.DropdownLayout;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private DropdownLayout mDl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDl = (DropdownLayout) findViewById(R.id.dl);
        mDl.setCols(2);

        //创建内容区
        TextView tv = new TextView(this);
        tv.setText("我是内容，可以是View，也可以是ViewGroup");

        //创建下拉列表数据
        final List<Map<String, String>> listData = new ArrayList<>();
        for (int i = 0; i < mDl.getCols(); i++) {
            Map<String, String> map = new LinkedHashMap<>();
            for (int j = 0; j < 6; j++) {
                map.put("name " + j, "value " + j);
            }
            listData.add(map);
        }


        mDl.init(tv, listData);
        mDl.setOnDropdownListListener(new DropdownLayout.OnDropdownListListener() {
            @Override
            public void OnDropdownListSelected(int indexOfButton, int indexOfList, String textOfList, String valueOfList) {
                //当第一列的第二个被选中时
                if (indexOfButton == 0 && indexOfList == 1) {
                    Map<String, String> map = listData.get(1);
                    map.clear();
                    map.put("csdn1", "lqr1");
                    map.put("csdn2", "lqr2");
                    //当第一列的其它项被选中时
                } else if (indexOfButton == 0) {
                    Map<String, String> map = listData.get(1);
                    map.clear();
                    for (int j = 0; j < 6; j++) {
                        map.put("name " + j, "value " + j);
                    }
                }
                //刷新下拉列表数据
                mDl.notifyDataSetChanged();
            }

            @Override
            public void onDropdownListOpen() {

            }

            @Override
            public void onDropdownListClosed() {

            }

        });
    }
}
