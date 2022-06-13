package org.marsstudio.learn.design;

import org.marsstudio.learn.design.ceiling.LevelTwoCeiling;
import org.marsstudio.learn.design.coat.DuluxCoat;
import org.marsstudio.learn.design.coat.LiBangCoat;
import org.marsstudio.learn.design.floor.ShengXiangFloor;
import org.marsstudio.learn.design.tile.DongPengTile;
import org.marsstudio.learn.design.tile.MarcoPoloTile;

public class Builder {

    public IMenu levelOne(Double area) {
        return new DecorationPackageMenu(area, "豪华欧式")
                .appendCelling(new LevelTwoCeiling())
                .appendCoat(new DuluxCoat())
                .appendFloor(new ShengXiangFloor());
    }

    public IMenu levelTwo(Double area) {
        return new DecorationPackageMenu(area, "轻奢田园")
                .appendCelling(new LevelTwoCeiling())
                .appendCoat(new LiBangCoat())
                .appendFloor(new MarcoPoloTile());
    }

    public IMenu levelThree(Double area) {
        return new DecorationPackageMenu(area, "现代简约")
                .appendCelling(new LevelTwoCeiling())
                .appendCoat(new LiBangCoat())
                .appendFloor(new DongPengTile());
    }
}
