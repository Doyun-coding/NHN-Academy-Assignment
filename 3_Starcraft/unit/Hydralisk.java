package unit;

public class Hydralisk extends Unit {

    public Hydralisk() {
        this.attackPower = 3;
        this.defensePower = 7;
    }

    @Override
    public boolean isFly() {
        return false;
    }

    @Override
    public boolean isUnFly() {
        return true;
    }

    @Override
    public int getUnitAttackPower() {
        return this.attackPower;
    }

    @Override
    public int getUnitDefensePower() {
        return this.defensePower;
    }

    @Override
    public void setUnitDefensePower(int cap) {
        this.defensePower -= cap;
    }

    @Override
    public String getUnitName() {
        return "Hydralisk";
    }

    @Override
    public boolean groundAttack() {
        return true;
    }

    @Override
    public boolean airAttack() {
        return true;
    }
}
