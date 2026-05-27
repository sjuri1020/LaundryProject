package deu.cse.laundry;
import java.util.LinkedList;
public class Storage {
    // Hash table
    private LinkedList<Slot>[] hashTable;
    public LinkedList<Slot> list;
    // Hash 객체를 생성할 때 table 사이즈 지정
    public Storage(int size) {
        this.hashTable = new LinkedList[size]; // LinkedList 배열로 초기화
        for (int i = 0; i < size; i++) {
            this.hashTable[i] = new LinkedList<>();
        }
    }
    
    public class Slot {
        String key; // 키 추가
        String value;
        
        Slot(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    // 해시 함수
    public int hashFunction(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (31 * hash + key.charAt(i)) % this.hashTable.length;
        }
        return hash;
    }
	
    // 입력 받은 key를 해시 함수로 인덱스화 하고, 해당 인덱스에 value 저장
    public boolean saveData(String key, String value) {
        int address = hashFunction(key); // 해시 함수 값 계산
        list = hashTable[address]; // 해당 인덱스의 연결 리스트 가져오기
        for (Slot slot : list) {
            if (slot.key.equals(key)) { // 이미 해당 키가 존재하는 경우
                slot.value = value; // 값을 업데이트하고 반환
                return true;
            }
        }
        // 해당 키가 없는 경우 새로운 슬롯 추가
        list.add(new Slot(key, value));
        return true;
    }

    // key에 해당하는 값을 반환
    public String getData(String key) {
        int address = hashFunction(key); // 해시 함수 값 계산
        list = hashTable[address]; // 해당 인덱스의 연결 리스트 가져오기
        for (Slot slot : list) {
            if (slot.key.equals(key)) { // 해당 키를 찾으면 값을 반환
                return slot.value;
            }
        }
        return null; // 해당 키가 없으면 null 반환
    }
}