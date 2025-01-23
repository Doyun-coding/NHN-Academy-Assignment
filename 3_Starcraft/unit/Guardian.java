package unit;

public class Guardian extends Unit {

    public Guardian() {
        this.attackPower = 3;
        this.defensePower = 6;
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
        return "Guardian";
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
