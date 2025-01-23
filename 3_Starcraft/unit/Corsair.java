package unit;

public class Corsair extends Unit {

    public Corsair() {
        this.attackPower = 4;
        this.defensePower = 12;
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
        return "Corsair";
    }

    @Override
    public boolean groundAttack() {
        return false;
    }

    @Override
    public boolean airAttack() {
        return true;
    }
}
