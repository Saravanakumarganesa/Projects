package Lift;
import java.util.Scanner;

public class LiftSimulator {

    static class Lift {
        private int currentFloor;

        public Lift() {
            this.currentFloor = 0;
        }
     public void moveToFloors(int[] destinations, String[] names) {
            System.out.println("\nLift is currently at Floor: " + currentFloor);
            for (int i = 0; i < destinations.length - 1; i++) {
                for (int j = i + 1; j < destinations.length; j++) {
                    if (destinations[i] < destinations[j]) {
                        int tempDest = destinations[i];
                        destinations[i] = destinations[j];
                        destinations[j] = tempDest;
                        String tempName = names[i];
                        names[i] = names[j];
                        names[j] = tempName;
                    }
                }
            }
            for (int i = 0; i < destinations.length; i++) {
                moveToFloor(destinations[i]);
                System.out.println(names[i] + " exited at Floor " + destinations[i]);
            }
        }

        private void moveToFloor(int destinationFloor) {
            if (destinationFloor == currentFloor) return;

            if (destinationFloor > currentFloor) {
                for (int i = currentFloor + 1; i <= destinationFloor; i++) {
                    System.out.println("Going up... Floor: " + i);
                }
            } else {
                for (int i = currentFloor - 1; i >= destinationFloor; i--) {
                    System.out.println("Going down... Floor: " + i);
                }
            }

            currentFloor = destinationFloor;
        }

        public int getCurrentFloor() {
            return currentFloor;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lift lift = new Lift();
        System.out.println("=== Lift Simulation ===");
        System.out.print("\nEnter number of peoples(1-6): ");
        int numPassengers = scanner.nextInt();
        scanner.nextLine(); 
        if (numPassengers < 1 || numPassengers > 6) {
            System.out.println("Invalid number of peoples. Please enter a value between 1 and 6.");
            return;
        }
        String[] names = new String[numPassengers];
        int[] destinations = new int[numPassengers];

        for (int i = 0; i < numPassengers; i++) {
            System.out.print("\nEnter name of Person " + (i + 1) + ": ");
            names[i] = scanner.nextLine();

            System.out.print("Enter destination floor for " + names[i] + ": ");
            destinations[i] = scanner.nextInt();
            scanner.nextLine();
        }

        lift.moveToFloors(destinations, names);

        System.out.println("\nSimulation complete.\nLift is now at Floor " + lift.getCurrentFloor());

        scanner.close();
    }
}

