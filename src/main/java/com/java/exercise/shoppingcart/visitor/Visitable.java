/*
* Copyright (c) 2017, Ritesh. All rights reserved.
*
*/
package com.java.exercise.shoppingcart.visitor;

/**
 * DESCRIPTION - Used to implement visitor design pattern. Everything what can be visited.
 *
 * @author - Ritesh Bangal
 * @version 1.0
 * @since <24-November-2017>
 */
@FunctionalInterface
public interface Visitable<T extends Visitable<T>> {

    /**
     *
     * @param visitor visitor to visit this visitable with
     */
    void accept(Visitor<T> visitor);
}