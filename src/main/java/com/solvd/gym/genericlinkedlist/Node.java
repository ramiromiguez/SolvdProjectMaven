package com.solvd.gym.genericlinkedlist;

public class Node<D> {

    D data; // Data in the current node
    Node<D> next; // Reference for the next node

    // Constructor which takes an int value which is stored as the data in this Node
    // object.
    Node(D data) {
	this.data = data;
    }
}
