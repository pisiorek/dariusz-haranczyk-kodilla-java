package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public final Tasks makeTask(final String taskClass) {
        switch (taskClass) {
            case SHOPPING:
                return new ShoppingTask("Shopping bread", "Pieczywo", 2.0);
            case PAINTING:
                return new PaintingTask("Painting walls", "white", "the walls");
            case DRIVING:
                return new DrivingTask("Driving to work", "work", "bicycle");
            default:
                return null;
        }

    }
}
