package org.marsstudio.learn.design;

public interface IMenu {


    IMenu appendCelling(Matter matter); // 吊顶

    IMenu appendCoat(Matter matter); // 涂料

    IMenu appendFloor(Matter matter); // 地板

    IMenu appendTile(Matter matter); // 地砖

    String getDetail(); // 明细
}
