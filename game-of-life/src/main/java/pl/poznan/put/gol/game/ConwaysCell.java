package pl.poznan.put.gol.game;

public class ConwaysCell implements Cell {

    protected int i;
    protected int j;

    public ConwaysCell(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public Cells neighbors() {
        Cells cell = new Cells();
        return cell.getNeighbors();
    }

    @Override
    public String toString() {
        return "c(" + i + ":" + j + ")";
    }

}
