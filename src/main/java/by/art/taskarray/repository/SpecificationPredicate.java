package by.art.taskarray.repository;

import by.art.taskarray.entity.SimpleArray;

import java.util.function.Predicate;

@FunctionalInterface
public interface SpecificationPredicate extends Predicate<SimpleArray> {
}
