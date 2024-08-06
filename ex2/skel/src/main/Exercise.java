package main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exercise {

    public static void solve(BufferedWriter bfw, Scanner sca, Scanner scb) throws IOException {

        Integer a = sca.hasNextInt() ? sca.nextInt() : null;
        Integer b = scb.hasNextInt() ? scb.nextInt() : null;
        while (a != null && b != null) {
            if (a > b) {
                bfw.write(b + " ");
                b = scb.hasNextInt() ? scb.nextInt() : null;
            } else {
                bfw.write(a + " ");
                a = sca.hasNextInt() ? sca.nextInt() : null;
            }
        }

        while (a != null) {
            bfw.write(a + " ");
            a = sca.hasNextInt() ? sca.nextInt() : null;
        }

        while(b != null) {
            bfw.write(b + " ");
            b = scb.hasNextInt() ? scb.nextInt() : null;
        }

        bfw.flush();
    }
}
