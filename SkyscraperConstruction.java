import java.util.*;

public class SkyscraperConstruction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter the total no of floors in the building");
        int N = scanner.nextInt();

        PriorityQueue<Integer> sizes = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            System.out.println("enter the floor size given on day : " + (i + 1));
            int size = scanner.nextInt();
            sizes.add(size);

            // Attempt to assemble floors
            assembleFloors(sizes, i + 1);
        }

        scanner.close();
    }

    public static void assembleFloors(PriorityQueue<Integer> sizes, int day) {
        PriorityQueue<Integer> temp = new PriorityQueue<>(Collections.reverseOrder());

        while (!sizes.isEmpty()) {
            int topSize = sizes.poll();
            boolean canAssemble = true;

            for (int size : temp) {
                if (topSize <= size) {
                    canAssemble = false;
                    break;
                }
            }

            if (canAssemble) {
                temp.add(topSize);
            } else {
                sizes.add(topSize);
                break;
            }
        }

        // Print the assembled floor sizes or an empty line if no floor can be assembled
        System.out.print("Day: " + day + "\n");
        for (int size : temp) {
            System.out.print(size + " ");
        }
        System.out.println();
    }
}