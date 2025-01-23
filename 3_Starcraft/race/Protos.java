package race;

import unit.*;

import java.util.ArrayList;

public class Protos implements Race {

    private ArrayList<Unit> units = new ArrayList<>();

    public Protos() {
        this.createUnit();
    }

    @Override
    public String getRaceName() {
        return "Protos";
    }

    @Override
    public void createUnit() {
        for(int i = 0; i < 5; i++) {
            int n = (int) (Math.random() * 5);
            if(n == 0) {
                this.units.add(new Zealot());
            }
            else if(n == 1) {
                this.units.add(new Dragoon());
            }
            else if(n == 2) {
                this.units.add(new HighTempler());
            }
            else if(n == 3) {
                this.units.add(new Scout());
            }
            else if(n == 4) {
                this.units.add(new Corsair());
            }
        }
    }

    @Override
    public ArrayList<Unit> getUnits() {
        return this.units;
    }

}
