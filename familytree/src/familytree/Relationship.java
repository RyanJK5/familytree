package familytree;

/**
 * Represents a familial relationship between a {@code FamilyTreeNode} and a target.
 */
public class Relationship {
    
    /**
     * The target ID of this relationship.
     */
    public final int targetID;
    
    /**
     * The number of siblings away the target is on the tree. For example, if 
     * ({@code directness = 1, generationsDown = 1}), the target would be the node's niece.
     */
    public final int directness;

    /**
     * The number of generations down the target is on the tree. Negative values indicate a higher level of the tree.
     */
    public final int generationsDown;

    /**
     * Creates a new relationship to be passed into a {@code FamilyTreeNode}.
     * 
     * @param targetID The target ID of this relationship.
     * @param type The type of relationship the {@code FamilyTreeNode} that this object is being passed into has to the target.
     * @param generationsDown The number of generations down the target is on the tree. Negative values indicate a higher level of the tree.
     * @throws NullPointerException if {@code type} is null.
     */
    public Relationship(int targetID, int directness, int generationsDown) {
        this.targetID = targetID;
        this.directness = directness;
        this.generationsDown = generationsDown;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Relationship other && 
            targetID == other.targetID && 
            directness == other.directness && 
            generationsDown == other.generationsDown;
    }

    @Override
    public String toString() {
        final String[] numberArr = { "second ", "third ", "fourth ", "fifth "};
        String result = "";

        if (directness > 1) {
            result += numberArr[directness - 2];
        }
        for (int i = 2; i < Math.abs(generationsDown); i++) {
            result += "great ";
        }
        if (Math.abs(generationsDown) > 1) {
            if (directness == 0) {
                result += "grand";
            }
            else {
                result += "great ";
            }
        }

        if (directness == 0) {
            if (generationsDown > 0) {
                result += "child";
            }
            else if (generationsDown == 0) {
                result += "sibling";
            }
            else {
                result += "parent";
            }
        }
        else {
            if (generationsDown > 0) {
                result += "nephew";
            }
            else if (generationsDown == 0) {
                result += "cousin";
            }
            else {
                result += "uncle";
            }
        }
        return result;
    }

    /**
     * Returns the relationship the node holding this object would have to the target of the provided relationship if the target of this
     * object held the provided relationship. For example, if this object held the values ({@code directness = 0, generationsDown = -1}),
     * and the provided relationship held the values ({@code directness = 1, generationsDown = 0}), this method would return a
     * relationship with the values ({@code directness = 1, generationsDown = -1})
     * 
     * @param relationship the relationship being added to the target of this relationship.
     * @return the relationship the node holding this object would have to the target of the provided relationship if the target of this object held
     * the provided relationship.
     */
    public Relationship getCorrespondingRelationship(Relationship relationship) {
        return new Relationship(relationship.targetID, directness + relationship.directness + 
            (relationship.directness == 0 && relationship.generationsDown == 0 ? 1 : 0), generationsDown + relationship.generationsDown);
    }

    /**
     * Returns a relationship that is the exact inverse of this relationship with the provided holder ID. For example, if this object represented 
     * an uncle, this method would return a nephew.
     *
     * @param holderID the ID being used to create the new relationship.
     * @return a relationship inverse to this relationship.
     */
    public Relationship getInverse(int holderID) {
        return new Relationship(holderID, -directness, -generationsDown);
    }
}
