//I worked on the homework assignment alone, using only course materials.
abstract class Treatment implements HealAbility {
    private int heal;
    Treatment(int heal) {
        this.heal = heal;
    }

    public String toString() {
        return "Treatment with " + this.heal + " heal";
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    public int getHealAmount() {
        return this.heal;
    }
}
