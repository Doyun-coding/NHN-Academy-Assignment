package unit;

public class Scout extends Unit {

    public Scout() {
        this.attackPower = 5;
        this.defensePower = 10;
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
        return "Scout";
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
