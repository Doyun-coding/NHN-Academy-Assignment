package unit;

import attack.AttackMode;
import move.Move;

public abstract class Unit implements AttackMode, Move {
    protected int attackPower;
    protected int defensePower;

    public abstract boolean isFly();
    public abstract boolean isUnFly();

    public abstract int getUnitAttackPower();
    public abstract int getUnitDefensePower();
    public abstract void setUnitDefensePower(int cap);
    public abstract String getUnitName();

    public abstract boolean groundAttack();
    public abstract boolean airAttack();
}
