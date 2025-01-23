package unit;

public class HighTempler extends Unit {

    public HighTempler() {
        this.attackPower = 10;
        this.defensePower = 2;
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
        return "HighTempler";
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
