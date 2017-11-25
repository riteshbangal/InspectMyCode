/*
* Copyright (c) 2017, Ritesh. All rights reserved.
*
*/
package com.java.exercise.shoppingcart.visitor;

/**
 * DESCRIPTION - Visitor to visit all visitable items with
 *
 * @author - Ritesh Bangal
 * @version 1.0
 * @since <24-November-2017>
 */
public interface Visitor<T extends Visitable<T>> {

    /**
     * @param element element to visit
     */
    void visit(T item);

    /**
     * @return result of visitation
     */
    double getResult();

    /**
     * Resets state of this visitor so its like it has not visited anything yet
     */
    void reset();
}