package familytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a node of a {@code FamilyTree}, which contains information about a person as well as their relation to other people.
 */
public class FamilyTreeNode implements Comparable<FamilyTreeNode> {
   
    /**
     * An ID representation of this object so that it need not be passed by reference into other classes.
     */
    public final int ID;
    
    private String name;
    
    private List<Relationship> relationships;

    private static int IDCounter;

    /**
     * Creates a new family tree node.
     * @param name The name of the person represented by the family tree node.
     * @param relationshipArr Any currently existing relationships this node should have with other nodes.
     * @throws NullPointerException if either parameter is null.
     */
    public FamilyTreeNode(String name, Relationship... relationshipArr) {
        Objects.requireNonNull(name);
        this.name = name;
        relationships = new ArrayList<>();
        addRelationships(relationshipArr);
        ID = IDCounter++;
    }

    /**
     * Adds a relationship to this node's list of relationships.
     * @param relationshipArr The relationships to be added.
     * @throws NullPointerException if {@code relationshipArr} is null.
     */
    public void addRelationships(Relationship... relationshipArr) {
        Objects.requireNonNull(relationshipArr);
        for (Relationship relationship : relationshipArr) {
            if (!relationships.contains(relationship)) {
                relationships.add(relationship);
            }
        }
    }

    /**
     * Returns an array of this node's relationships with other nodes.
     * @return an array of this node's relationships with other nodes.
     */
    public Relationship[] getRelationships() {
        return relationships.toArray(new Relationship[0]);
    }

    /**
     * Indicates whether or not this node has any relationship with another node.
     * @param otherID the ID of the other node.
     * @return whether or not this node has any relationship with another node.
     */
    public boolean hasRelationshipWith(int otherID) {
        return relationships
            .stream()
            .anyMatch(relationship -> relationship.targetID == otherID);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof FamilyTreeNode node && ID == node.ID;
    }

    @Override
    public int compareTo(FamilyTreeNode o) {
        return Integer.compare(ID, o.ID);
    }
}
