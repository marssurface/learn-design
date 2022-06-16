package org.marsstudio.learn.design.test;

import org.junit.Test;
import org.marsstudio.learn.design.XiaoEr;
import org.marsstudio.learn.design.cook.impl.GuangDongCook;
import org.marsstudio.learn.design.cook.impl.JiangSuCook;
import org.marsstudio.learn.design.cook.impl.ShangDongCook;
import org.marsstudio.learn.design.cook.impl.SiChuanCook;
import org.marsstudio.learn.design.cuisine.ICuisine;
import org.marsstudio.learn.design.cuisine.impl.GuangDongCuisine;
import org.marsstudio.learn.design.cuisine.impl.JiangSuCuisine;
import org.marsstudio.learn.design.cuisine.impl.ShanDongCuisine;
import org.marsstudio.learn.design.cuisine.impl.SiChuanCuisine;

public class ApiTest {

    @Test
    public void test() {
        ICuisine guangDongCuisine = new GuangDongCuisine(new GuangDongCook());
        JiangSuCuisine jiangSuCuisine = new JiangSuCuisine(new JiangSuCook());
        ShanDongCuisine shanDongCuisine = new ShanDongCuisine(new ShangDongCook());
        SiChuanCuisine siChuanCuisine = new SiChuanCuisine(new SiChuanCook());

        XiaoEr xiaoEr = new XiaoEr();

        xiaoEr.order(guangDongCuisine);
        xiaoEr.order(jiangSuCuisine);
        xiaoEr.order(shanDongCuisine);
        xiaoEr.order(siChuanCuisine);

        xiaoEr.placeOrder();
    }
}
