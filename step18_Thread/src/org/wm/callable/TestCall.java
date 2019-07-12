package org.wm.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCall {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		StringCallable sc = new StringCallable();
		FutureTask<String> futureTask = new FutureTask<String>(sc);
		Thread t = new Thread(futureTask);
		t.start();
		System.out.println(futureTask.get());
	}
}
