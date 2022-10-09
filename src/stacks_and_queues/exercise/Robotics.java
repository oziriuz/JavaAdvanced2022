package stacks_and_queues.exercise;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Robotics {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);

        String[] inputRobots = scanner.nextLine().split(";");
        Map<String, Integer> robotsInLine = new LinkedHashMap<>();
        for (String inputRobot : inputRobots) {
            int robotBusyTimer = 0;
            robotsInLine.put(inputRobot, robotBusyTimer);
        }

        String startTimeInput = scanner.nextLine();
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        Date startTime = timeFormat.parse(startTimeInput);

        Deque<String> detailsQueue = new ArrayDeque<>();
        String detail = scanner.nextLine();
        while (!detail.equals("End")) {
            detailsQueue.offer(detail);
            detail = scanner.nextLine();
        }

        while (!detailsQueue.isEmpty()) {
            //time goes every second
            startTime.setTime(startTime.getTime() + 1000);
            //reduce timer of every busy robot, if any ...
            reduceBusyTimers(robotsInLine);
            // get a detail from the queue
            String currentDetail = detailsQueue.poll();
            //get the first available robots in the line, if any...
            String freeRobot = getFirstFreeRobot(robotsInLine);
            if (freeRobot != null) {
                //put the free robot to work
                work(freeRobot, robotsInLine);
                System.out.println(freeRobot.split("-")[0] + " - " + currentDetail + " [" + timeFormat.format(startTime) + "]");
            } else {
                // if no free rotate details in queue
                detailsQueue.offer(currentDetail);
            }
        }
    }

    private static void work(String freeRobot, Map<String, Integer> robotsLine) {
        for (Map.Entry<String, Integer> robot : robotsLine.entrySet()) {
            int processTime = Integer.parseInt(robot.getKey().split("-")[1]);
            String robotName = robot.getKey();
            if (robotName.equals(freeRobot)) {
                //busy timer goes equal to process time
                robotsLine.put(robotName, processTime);
            }
        }
    }

    private static void reduceBusyTimers(Map<String, Integer> robotsLine) {
        for (Map.Entry<String, Integer> robot : robotsLine.entrySet()) {
            int busyTimer = robot.getValue();
            String robotName = robot.getKey();
            if (busyTimer > 0) {
                robotsLine.put(robotName, busyTimer - 1);
            }
        }
    }

    private static String getFirstFreeRobot(Map<String, Integer> robotsLine) {
        //if busy timer is 0;
        //return robot as free
        for (Map.Entry<String, Integer> robot : robotsLine.entrySet()) {
            int busyTimer = robot.getValue();
            String robotName = robot.getKey();
            if (busyTimer == 0) {
                return robotName;
            }
        }
        return null;
    }
}