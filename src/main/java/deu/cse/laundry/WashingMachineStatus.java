package deu.cse.laundry;

import java.util.ArrayList;
import java.util.List;

public class WashingMachineStatus {
    // 각 세탁기의 고장 상태를 나타내는 배열
    private boolean[] faultStatus = {false, false, false}; 

    // 옵저버 목록을 저장하는 리스트
    private List<Observer> observers = new ArrayList<>();

    // 옵저버를 추가하는 메서드
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // 옵저버를 제거하는 메서드
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // 고장 상태 변경을 옵저버들에게 알리는 메서드
    private void notifyObservers(int machineIndex) {
        for (Observer observer : observers) {
            observer.update(machineIndex, faultStatus[machineIndex]);
        }
    }

    // 고장 상태를 보고하는 메서드
    public void reportFault(int machineIndex) {
        if (!faultStatus[machineIndex]) { // 고장 상태가 아닌 경우에만
            faultStatus[machineIndex] = true; // 고장 상태로 설정
            notifyObservers(machineIndex); // 옵저버들에게 알림
        }
    }

    // A/S 완료를 처리하는 메서드
    public void completeAS() {
        for (int i = 0; i < faultStatus.length; i++) {
            faultStatus[i] = false; // 모든 세탁기의 고장 상태를 초기화
            notifyObservers(i); // 각 세탁기의 상태 변경을 옵저버들에게 알림
        }
    }

    // 세탁기의 고장 상태를 반환하는 메서드
    public boolean isFaulty(int machineIndex) {
        return faultStatus[machineIndex];
    }
}
