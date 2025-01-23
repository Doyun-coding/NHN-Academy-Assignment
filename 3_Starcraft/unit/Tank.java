package unit;

public class Tank extends Unit {

    public Tank() {
        this.attackPower = 7;
        this.defensePower = 15;
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
        return "Tank";
    }

    @Override
    public boolean groundAttack() {
        return true;
    }

    @Override
    public boolean airAttack() {
        return false;
    }
}
