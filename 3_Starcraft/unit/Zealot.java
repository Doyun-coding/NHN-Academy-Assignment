package unit;

public class Zealot extends Unit {

    public Zealot() {
        this.attackPower = 5;
        this.defensePower = 20;
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
        return "Zealot";
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
