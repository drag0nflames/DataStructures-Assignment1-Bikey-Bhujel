package artifactvault;

import java.util.Arrays;


public class ArtifactVault {
    private Artifact[] artifacts;
    private int size;

    public ArtifactVault(int capacity) {
        artifacts = new Artifact[capacity];
        size = 0;
    }

    // Artifact class
    static class Artifact implements Comparable<Artifact> {
        String name;
        int age;

        public Artifact(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Artifact{name='" + name + "', age=" + age + "}";
        }

        @Override
        public int compareTo(Artifact other) {
            return Integer.compare(this.age, other.age);
        }
    }

    // Add an artifact to the first empty slot
    public void addArtifact(Artifact artifact) {
        if (size < artifacts.length) {
            artifacts[size++] = artifact;
            Arrays.sort(artifacts, 0, size); // keep the array sorted by age
        } else {
            System.out.println("Vault is full. Cannot add more artifacts.");
        }
    }

    // Remove an artifact by its name
    public void removeArtifactByName(String name) {
        for (int i = 0; i < size; i++) {
            if (artifacts[i] != null && artifacts[i].name.equals(name)) {
                System.out.println("Removing: " + artifacts[i]);
                // Shift elements left to fill the removed spot
                for (int j = i; j < size - 1; j++) {
                    artifacts[j] = artifacts[j + 1];
                }
                artifacts[size - 1] = null;
                size--;
                return;
            }
        }
        System.out.println("Artifact not found.");
    }

    // Find an artifact using linear search
    public Artifact linearSearch(String name) {
        for (int i = 0; i < size; i++) {
            if (artifacts[i] != null && artifacts[i].name.equals(name)) {
                return artifacts[i];
            }
        }
        return null; // Artifact not found
    }

    // Find an artifact using binary search (array is assumed to be sorted by age)
    public Artifact binarySearch(int age) {
        int left = 0;
        int right = size - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (artifacts[middle] == null) continue;

            if (artifacts[middle].age == age) {
                return artifacts[middle];
            } else if (artifacts[middle].age < age) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return null; // Artifact not found
    }

    public void displayArtifacts() {
        for (int i = 0; i < size; i++) {
            System.out.println(artifacts[i]);
        }
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        ArtifactVault vault = new ArtifactVault(5);

        Artifact a1 = new Artifact("Vase", 1200);
        Artifact a2 = new Artifact("Sculpture", 1500);
        Artifact a3 = new Artifact("Coin", 900);
        Artifact a4 = new Artifact("Mask", 1800);
        Artifact a5 = new Artifact("Sword", 1100);

        vault.addArtifact(a1);
        vault.addArtifact(a2);
        vault.addArtifact(a3);
        vault.addArtifact(a4);
        vault.addArtifact(a5);

        System.out.println("Artifacts in vault:");
        vault.displayArtifacts();

        System.out.println("\nFinding artifact 'Coin':");
        System.out.println(vault.linearSearch("Coin"));

        System.out.println("\nFinding artifact with age 1500 using binary search:");
        System.out.println(vault.binarySearch(1500));

        System.out.println("\nRemoving artifact 'Sculpture':");
        vault.removeArtifactByName("Sculpture");

        System.out.println("\nArtifacts in vault after removal:");
        vault.displayArtifacts();
    }
}
