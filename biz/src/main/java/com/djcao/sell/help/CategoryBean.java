package com.djcao.sell.help;

import java.util.Comparator;
import java.util.List;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/11/8
 */
public class CategoryBean {
    private Obi[] obiList;
    private final static String SPLIT_STRING =",";

    /**
     *
     * @param categoryId 需要获取所有父类的title的categoryId
     * @param obiList category列表
     * @return categoryId和所有title的字符串的pair
     */
    public Pair<Integer, String> getAllTitles(int categoryId,List<Obi> obiList) {
        initCategoryList(obiList);
        String pNodeTitles = getPNodeTitles(categoryId, "");
        return new Pair<>(categoryId, pNodeTitles);
    }

    //初始化所有列表
    private void initCategoryList(List<Obi> param) {
        Obi obi = param.stream().max((Comparator.comparingInt(Obi::getCategoryId))).get();
        obiList = new Obi[obi.getCategoryId()+1];
        param.forEach(obi1 -> {
            obiList[obi1.getCategoryId()] = obi1;
        });
    }

    //递归获取所有的字符串
    private String getPNodeTitles(int categoryId, String titles) {
        Obi obi = obiList[categoryId];
        if (obi.getCategoryId() != 0) {
            if (StringUtils.isNotBlank(titles)){
                titles+=SPLIT_STRING;
            }
            titles += obi.getTitle();
            return getPNodeTitles(obi.getParentId(), titles);
        } else {
            if (StringUtils.isNotBlank(titles)){
                titles+=SPLIT_STRING;
            }
            return titles + obi.getTitle();
        }
    }

    public static void main(String[] args) {
        CategoryBean categoryBean = new CategoryBean();
        List<Obi> list = Lists.newArrayList();
        list.add(new Obi().setCategoryId(100).setTitle("100").setParentId(99));
        list.add(new Obi().setCategoryId(99).setTitle("99").setParentId(98));
        list.add(new Obi().setCategoryId(98).setTitle("98").setParentId(97));
        list.add(new Obi().setCategoryId(97).setTitle("97").setParentId(96));
        list.add(new Obi().setCategoryId(96).setTitle("96").setParentId(0));
        list.add(new Obi().setCategoryId(0).setTitle("0").setParentId(0));
        Pair<Integer, String> allTitles = categoryBean.getAllTitles(97,list);
        System.out.println(allTitles.getFirst());
        System.out.println(allTitles.getSecond());

    }
}
