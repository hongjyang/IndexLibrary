package com.dingptech.indexslibrary;


public class TextBean implements Comparable<TextBean> {
    private String name;
    private String pinyin;


    public TextBean(String name) {
        this.name = name;
        setPinyin(PinyinUtil.getPinyin(name));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    @Override
    public int compareTo(TextBean o) {
        return getPinyin().compareTo(o.getPinyin());
    }
}
