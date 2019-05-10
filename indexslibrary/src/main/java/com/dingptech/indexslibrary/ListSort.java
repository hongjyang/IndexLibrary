package com.dingptech.indexslibrary;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
         |              |
         | \            | \
         |   | | | | | |    | | | | |||||\
         |                          |||||||\
         |         ( )              ||||||||
         |                           |||||/
         |                  | | | | | |||/
         |    |             |          |
         |    |             |          |
       / |   | |            |          |\
      |      |/             |          \|
       \ |                  |
         |                  |
           \ | | | | | | | /
             |       |            <-----弱鸡
             |       |
             |       |
*/
public class ListSort {
    private static List<TextBean> list1 = new ArrayList();

    public static List<TextBean> sort(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            TextBean bean = new TextBean(list.get(i));
            list1.add(bean);
        }
        Collections.sort(list1);
        return list1;
    }
}
