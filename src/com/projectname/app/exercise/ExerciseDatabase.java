import java.io.*;
import java.util.*;

public class WorkoutDatabase {
    private Hashtable<String, Exercise> workoutTable = new Hashtable<>();
    private static final String FILE_NAME = "exercises.csv";

    // Load workouts from the file into memory
    public void loadExercises() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Exercise exercise = Exercise.fromCSV(line);
                exerciseTable.put(exercise.getName().toLowerCase(), exercise);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No existing database found. A new one will be created.");
        } catch (IOException e) {
            System.out.println("Error reading exercise file: " + e.getMessage());
        }
    }

    // Save workouts from memory to the file
    public void saveExercises() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Exercise exercise : exerciseTable.values()) {
                writer.write(exercise.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving exercise: " + e.getMessage());
        }
    }

    // Add a new workout
    public void addWorkout(Exercise exercise) {
        exerciseTable.put(exercise.getName().toLowerCase(), exercise);
    }

    // Search by name
    public Exercise getExerciseByName(String name) {
        return exerciseTable.get(name.toLowerCase());
    }

    // Search by other attributes
    public List<Exercise> searchExercises(String type, int minDuration, int maxDuration) {
        List<Exercise> results = new ArrayList<>();
        for (Exercise exercise : exerciseTable.values()) {
            if ((type == null || exercise.getType().equalsIgnoreCase(type)) &&
                    exercise.getDuration() >= minDuration &&
                    exercise.getDuration() <= maxDuration) {
                results.add(exercise);
            }
        }
        return results;
    }
}
