package deu.cse.laundry;

public interface Observer {
    void update(int machineIndex, boolean status);
}