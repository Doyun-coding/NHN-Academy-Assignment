package unit;

public class Mutalisk extends Unit {

    public Mutalisk() {
        this.attackPower = 2;
        this.defensePower = 8;
    }

    @Override
    public boolean isFly() {
        return true;
    }

    @Override
    public boolean isUnFly() {
        return false;
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
        return "Mutalisk";
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
