package com.umsign.refactoring.ch06;

import java.util.Enumeration;
import java.util.Vector;

public class ComposingMethodsExample {
    private Vector<Object> orders;
    private String name;
    private int numberOfLateDeliveries = 2;

    void printOwing() {
        printBanner();
        double outstanding = getOutstanding();
        printDetails(outstanding);

    }

    private double getOutstanding() {
        Enumeration e = orders.elements();
        double result = 0.0;
        while (e.hasMoreElements()) {
            Order each = (Order) e.nextElement();
            result += each.getAmount();
        }
        return result;
    }

    private void printDetails(double outstanding) {
        System.out.println("name:" + name);
        System.out.println("amount:" + outstanding);
    }

    private void printBanner() {
        System.out.println("*************************");
        System.out.println("***** Customer Owes *****");
        System.out.println("*************************");
    }

    int getRating() {
        //return (moreThanFiveLateDeliveries() ? 2 : 1);
        return (numberOfLateDeliveries > 5) ? 2 : 1;
    }

    private boolean moreThanFiveLateDeliveries() {
        return numberOfLateDeliveries > 5;
    }
}
