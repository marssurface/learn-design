package org.marsstudio.learn.design.lang;

/**
 * 迭代器
 * @param <E>
 */
public interface Iterator<E> {

    boolean hasNext();

    E next();
}
