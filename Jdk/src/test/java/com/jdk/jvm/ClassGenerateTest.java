package com.jdk.jvm;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

public class ClassGenerateTest {

  @Test
  void testCom() {
	List<String> a =new ArrayList<>(1);
	a.add("1");
	a.add("2");
	a.clear();
	  System.out.println(a.size());
  }

  @Test
  void testFloat() {
	float a = 0.1f;
	float b= 0.100000001f;
	System.out.println(a==b);
  }

	@Test
	void set() {
		AtomicInteger atomicInteger = new AtomicInteger(1);
		System.out.println(atomicInteger.getAndIncrement());
		System.out.println(atomicInteger.getAndIncrement());
		System.out.println(atomicInteger.getAndIncrement());
	}

	class CCC implements Comparable<CCC>{

    private int id;

	public CCC(int id) {
	  this.id = id;
	}


	@Override
	public int compareTo(CCC o) {
	  return this.id -o.id;
	}
  }
}
