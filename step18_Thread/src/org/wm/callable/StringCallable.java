package org.wm.callable;

import java.util.concurrent.Callable;

public class StringCallable implements Callable<String>{

	@Override
	public String call() throws Exception {
		String[] a = {"a","b","c","d","e"};
		return a[(int)(Math.random()*5)];
	}

}
