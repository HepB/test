package ru.lyubimov.test.rxjava;

import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class RxThreads {
    static String ss;

    public static void main(String[] args) {
        Disposable dis = generateString()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.from(command -> new Runnable() {
                    @Override
                    public void run() {
                        printThread();
                    }
                }))
                .subscribe(s -> {
                    printThread();
                    ss = s;
                });
        System.out.println(ss);
        dis.dispose();
    }

    private static void printThread() {
        System.out.println(Thread.currentThread().getName());
    }

    private static Single<String> generateString() {
        return Single.create(singleEmitter -> genString());
    }

    private static String genString() {
        printThread();
        return "go";
    }
}
