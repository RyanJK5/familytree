package familytree;

final class Program {

    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();
        var ryan = new FamilyTreeNode("Ryan");
        var stephen = new FamilyTreeNode("Stephen");
        stephen.addRelationships(new Relationship(ryan.ID, 0, -1));
        ryan.addRelationships(new Relationship(stephen.ID, 0, 1));
        tree.addNode(ryan);
        tree.addNode(stephen);
    }
}
