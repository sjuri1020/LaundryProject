/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package deu.cse.laundry;
/**
 *
 * @author pc22-1008
 */
public class Main {

    public static void main(String[] args) {
        // WashingMachine 인스턴스를 얻습니다.
        WM washingMachine1 = WM.getInstance();
        WM washingMachine2 = WM.getInstance();

        // 두 인스턴스가 동일한지 확인하여 싱글톤 패턴이 올바르게 작동하는지 검증합니다.
        System.out.println(washingMachine1 == washingMachine2); // true가 출력되어야 합니다.
    }
}


