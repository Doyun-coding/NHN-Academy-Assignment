package race;

import unit.*;

import java.util.ArrayList;

public class Terran implements Race {
    private ArrayList<Unit> units = new ArrayList<>();

    public Terran() {
        this.createUnit();
    }

    @Override
    public String getRaceName() {
        return "Terran";
    }

    @Override
    public void createUnit() {
        for(int i = 0; i < 5; i++) {
            int n = (int) (Math.random() * 5);
            if(n == 0) {
                this.units.add(new Marin());
            }
            else if(n == 1) {
                this.units.add(new Tank());
            }
            else if(n == 2) {
                this.units.add(new Goliath());
            }
            else if(n == 3) {
                this.units.add(new Wraith());
            }
            else if(n == 4) {
                this.units.add(new Valkyrie());
            }
        }
    }

    @Override
    public ArrayList<Unit> getUnits() {
        return this.units;
    }

}
