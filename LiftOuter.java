package Lift;
import java.util.*;

public class LiftOuter{

    static class Person {
        String name;
        int pickupFloor;
        int destinationFloor;

        public Person(String name, int pickupFloor, int destinationFloor) {
            this.name = name;
            this.pickupFloor = pickupFloor;
            this.destinationFloor = destinationFloor;
        }
    }

    static class Lift {
        private int currentFloor;

        public Lift() {
            this.currentFloor = 0;
        }

        public void operateLift(List<Person> people) {
            System.out.println("\nLift is currently at Floor: " + currentFloor);
            people.sort(Comparator.comparingInt(p -> p.pickupFloor));

            for (Person person : people) {
              
                moveToFloor(person.pickupFloor);
                System.out.println(person.name + " entered at Floor " + person.pickupFloor);

                moveToFloor(person.destinationFloor);
                System.out.println(person.name + " exited at Floor " + person.destinationFloor);
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
        System.out.println("=== Lift Simulation with Pickup and Drop ===");

        System.out.print("\nEnter number of people (1-6): ");
        int numPassengers = scanner.nextInt();
        scanner.nextLine();

        if (numPassengers < 1 || numPassengers > 6) {
            System.out.println("Invalid number of people. Please enter a value between 1 and 6.");
            return;
        }

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < numPassengers; i++) {
            System.out.print("\nEnter name of Person " + (i + 1) + ": ");
            String name = scanner.nextLine();

            System.out.print("Enter pickup floor for " + name + ": ");
            int pickup = scanner.nextInt();

            System.out.print("Enter destination floor for " + name + ": ");
            int dest = scanner.nextInt();
            scanner.nextLine();

            people.add(new Person(name, pickup, dest));
        }

        lift.operateLift(people);

        System.out.println("\nSimulation complete.\nLift is now at Floor " + lift.getCurrentFloor());

        scanner.close();
    }
}

