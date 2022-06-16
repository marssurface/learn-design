package org.marsstudio.learn.design.lang;

/**
 * 可迭代接口
 * @param <E>
 */
public interface Iterable<E> {

    Iterator<E> iterator();
}
