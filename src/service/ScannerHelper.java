package service;

import java.util.Scanner;

//Unified scanner to avoid creating new scanners and make the system more robust

public class ScannerHelper {
    private static final Scanner scanner = new Scanner(System.in);

    public static Scanner getScanner() {
        return scanner;
    }
}
