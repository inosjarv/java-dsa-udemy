package io.dsa.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

record Activity(String name, int startTime, int finishTime) {
}

public class ActivitySelection {
    public static void main(String[] args) {
        List<Activity> activityList = new ArrayList<>();
        activityList.add(new Activity("A1", 0, 6));
        activityList.add(new Activity("A2", 3, 4));
        activityList.add(new Activity("A3", 1, 2));
        activityList.add(new Activity("A4", 5, 8));
        activityList.add(new Activity("A5", 5, 7));
        activityList.add(new Activity("A6", 8, 9));

        activitySelection(activityList);
    }

    static void activitySelection(List<Activity> activityList) {
        Comparator<Activity> finishTimeComparator = Comparator.comparingInt(Activity::finishTime);

        activityList.sort(finishTimeComparator);

        Activity previousActivity = activityList.get(0);

        System.out.println("Recommending Schedule \n\n" + previousActivity);

        for (int i = 1; i < activityList.size(); i++) {
            Activity currentActivity = activityList.get(i);
            if (currentActivity.startTime() >= previousActivity.finishTime()) {
                System.out.println(currentActivity);
                previousActivity = currentActivity;
            }
        }
    }
}
