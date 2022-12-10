package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import familytree.Relationship;

public class RelationshipTest {
    
    @Test
    public void ToStringChild() {
        var child = new Relationship(0, 0, 1);
        assertTrue(child.toString().equals("child"));
    }

    @Test
    public void ToStringGreatGrandparent() {
        var greatGrandparent = new Relationship(0, 0, -3);
        assertTrue(greatGrandparent.toString().equals("great grandparent"));
    }

    @Test
    public void ToStringNephew() {
        var nephew = new Relationship(0, 1, 1);
        assertTrue(nephew.toString().equals("nephew"));
    }

    @Test
    public void ToStringSibling() {
        var sibling = new Relationship(0, 0, 0);
        assertTrue(sibling.toString().equals("sibling"));
    }

    @Test
    public void ToStringSecondCousin() {
        var secondCousin = new Relationship(0, 2, 0);
        assertTrue(secondCousin.toString().equals("second cousin"));
    }

    @Test
    public void ToStringGreatUncle() {
        var greatUncle = new Relationship(0, 1, -2);
        assertTrue(greatUncle.toString().equals("great uncle"));
    }

    @Test
    public void ToStringFourthGreatGreatNephew() {
        var fourthGreatGreatNephew = new Relationship(0, 4, 3);
        assertTrue(fourthGreatGreatNephew.toString().equals("fourth great great nephew"));
    }

    @Test
    public void CorrespondingSiblingOfParent() {
        var parent = new Relationship(1, 0, -1);
        var sibling = new Relationship(2, 0, 0);
        assertTrue(parent.getCorrespondingRelationship(sibling).toString().equals("uncle"));
    }

    @Test
    public void CorrespondingSonOfSon() {
        var child = new Relationship(1, 0, 1);
        var child2 = new Relationship(2, 0, 1);
        assertTrue(child.getCorrespondingRelationship(child2).toString().equals("grandchild"));
    }

    @Test
    public void CorrespondingParentOfSibling() {
        var sibling = new Relationship(1, 0, 0);
        var parent = new Relationship(2, 0, -1);
        assertTrue(sibling.getCorrespondingRelationship(parent).toString().equals("parent"));
    }

    @Test
    public void CorrespondingGrandparentOfSecondCousin() {
        var secondCousin = new Relationship(1, 2, 0);
        var grandparent = new Relationship(2, 0, -2);
        assertTrue(secondCousin.getCorrespondingRelationship(grandparent).toString().equals("second great uncle"));
    }

    @Test
    public void CorrespondingUncleOfSibling() {
        var sibling = new Relationship(1, 0, 0);
        var uncle = new Relationship(2, 1, -1);
        assertTrue(sibling.getCorrespondingRelationship(uncle).toString().equals("uncle"));
    }

    @Test
    public void CorrespondingSiblingOfGrandparent() {
        var grandparent = new Relationship(1, 0, -2);
        var sibling = new Relationship(2, 0, 0);
        assertTrue(grandparent.getCorrespondingRelationship(sibling).toString().equals("great uncle"));
    }

    @Test
    public void InverseSibling() {
        var sibling = new Relationship(0, 0, 0);
        assertTrue(sibling.getInverse(1).toString().equals("sibling"));
    }

    @Test
    public void InverseUncle() {
        var uncle = new Relationship(0, 1, -1);
        assertTrue(uncle.getInverse(1).toString().equals("nephew"));
    }
}
