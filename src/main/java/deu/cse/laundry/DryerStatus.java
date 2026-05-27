package deu.cse.laundry;

import java.util.ArrayList;
import java.util.List;

public class DryerStatus {
    private boolean[] faultStatus = {false, false, false};
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers(int machineIndex) {
        for (Observer observer : observers) {
            observer.update(machineIndex, faultStatus[machineIndex]);
        }
    }

    public void reportFault(int machineIndex) {
        if (!faultStatus[machineIndex]) {
            faultStatus[machineIndex] = true;
            notifyObservers(machineIndex);
        }
    }

    public void completeAS() {
        for (int i = 0; i < faultStatus.length; i++) {
            faultStatus[i] = false;
            notifyObservers(i);
        }
    }

    public boolean isFaulty(int machineIndex) {
        return faultStatus[machineIndex];
    }
}
