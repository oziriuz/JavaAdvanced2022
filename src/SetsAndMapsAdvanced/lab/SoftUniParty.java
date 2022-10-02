package SetsAndMapsAdvanced.lab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> vip = new TreeSet<>();
        Set<String> regular = new TreeSet<>();

        String guestID = scanner.nextLine();
        while (!guestID.equals("PARTY")) {
            if (Character.isDigit(guestID.charAt(0))) {
                vip.add(guestID);
            } else {
                regular.add(guestID);
            }
            guestID = scanner.nextLine();
        }

        guestID = scanner.nextLine();
        while (!guestID.equals("END")) {
            if (Character.isDigit(guestID.charAt(0))) {
                vip.remove(guestID);
            } else {
                regular.remove(guestID);
            }
            guestID = scanner.nextLine();
        }
        System.out.println(vip.size() + regular.size());
        for (String guest : vip) {
            System.out.println(guest);
        }
        for (String guest : regular) {
            System.out.println(guest);
        }
    }
}
