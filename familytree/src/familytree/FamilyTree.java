package familytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Represents a collection of {@code FamilyTreeNodes} and their relationships to one another. Provides methods to display and communicate between nodes.
 */
public class FamilyTree {

    private List<FamilyTreeNode> nodes;

    /**
     * Creates a new family tree.
     */
    public FamilyTree() {
        nodes = new ArrayList<>();
    }

    /**
     * Adds a node to this tree.
     * @param node The node to be added to the tree.
     */
    public void addNode(FamilyTreeNode node) {
        nodes.add(node);
        nodes.sort(null);
    }

    /**
     * Returns a node based on the provided ID, or an empty optional if not present. 
     * @param nodeID The ID of the node to return.
     * @return An optional containg the node if it is in the tree, or empty if not present.
     * @throws IndexOutOfBoundsException if the index is out of range {@code index < 0 || index >= nodeCount()}
     */
    public Optional<FamilyTreeNode> getNode(int nodeID) {
        return Optional.of(nodes.get(nodeID));
    }

    /**
     * Returns the number of nodes in the tree.
     * @return The number of nodes in the tree.
     */
    public int nodeCount() {
        return nodes.size();
    }

    /**
     * Implements a relationship into the tree, updating the relationships of every member related to the node with the provided ID. 
     * @param nodeID the ID of the node gaining the relationship.
     * @param relationship The new relationship between the provided node and the relationship's target.
     * @throws NoSuchElementException if the nodeID is not present in the family tree.
     */
    public void implementRelationship(int nodeID, Relationship relationship) {
        var node = getNode(nodeID).get();
        node.addRelationships(relationship);
        for (var relation : node.getRelationships()) {
            getNode(relation.targetID)
            .get()
            .addRelationships(
                relationship.getCorrespondingRelationship(relation)
            );
        }
    }

    public void listRelationships() {
        for (var node : nodes) {
            for (var relationship : node.getRelationships()) {
                
            }
        }
    }
}