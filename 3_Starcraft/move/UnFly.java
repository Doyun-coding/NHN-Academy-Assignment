package move;

import unit.Unit;

public class UnFly implements Move {

    @Override
    public boolean isFly() {
        return false;
    }

    @Override
    public boolean isUnFly() {
        return true;
    }

}
