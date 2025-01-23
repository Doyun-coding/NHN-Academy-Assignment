package race;

import unit.*;

import java.util.ArrayList;

public class Zerg implements Race {

    private ArrayList<Unit> units = new ArrayList<>();

    public Zerg() {
        this.createUnit();
    }

    @Override
    public String getRaceName() {
        return "Zerg";
    }

    @Override
    public void createUnit() {
        for(int i = 0; i < 5; i++) {
            int n = (int) (Math.random() * 5);
            if(n == 0) {
                this.units.add(new Zergling());
            }
            else if(n == 1) {
                this.units.add(new Hydralisk());
            }
            else if(n == 2) {
                this.units.add(new Ultralisk());
            }
            else if(n == 3) {
                this.units.add(new Mutalisk());
            }
            else if(n == 4) {
                this.units.add(new Guardian());
            }
        }
    }

    @Override
    public ArrayList<Unit> getUnits() {
        return this.units;
    }

}
