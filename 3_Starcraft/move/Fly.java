package move;

import unit.Unit;

public class Fly implements Move {

    @Override
    public boolean isFly() {
        return true;
    }

    @Override
    public boolean isUnFly() {
        return false;
    }

}
