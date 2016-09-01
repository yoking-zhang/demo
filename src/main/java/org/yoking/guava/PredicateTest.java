package org.yoking.guava;

import java.util.List;

import com.google.common.base.CharMatcher;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;


public class PredicateTest {

	public static void main(String[] args) {

		Function<String, Integer> lengFunction = new Function<String, Integer>() {
			@Override
			public Integer apply(String input) {
				return input.length();
			}
			
		};
		
		Predicate<String> allCaps = new Predicate<String>() {
			@Override
			public boolean apply(String input) {
				return CharMatcher.JAVA_UPPER_CASE.matchesAllOf(input);
			}
		};
		
		List<String> strings = Lists.newArrayList("A", "b", "c", "D", "EF", "g", "HIJ");
		Multiset<Integer> lengths = HashMultiset.create(Iterables.transform(Iterables.filter(strings, allCaps), lengFunction));
		
		System.out.println(lengths);
	}

}