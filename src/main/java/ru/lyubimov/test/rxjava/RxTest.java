package ru.lyubimov.test.rxjava;

import io.reactivex.*;
import io.reactivex.disposables.Disposable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Arrays;

public class RxTest {

    private static String result;

    public static void main(String[] args) {
        testTwo();
    }

    private static void testTwo() {
        String[] source = new String[]{"абырвалг", "главрыба", "писос"};
        Observable<String> obs = Observable.fromArray(source);
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onComplete() {}
        };
        obs.subscribe(observer);
    }

    private static void testOne() {
        Observable<String> observable = Observable.just("Hello");
        observable.subscribe(s -> result = s);
        System.out.println(result);
    }

    private static void testThree() {
        Observable<String> observable = Observable.just("Hello");

        Flowable<String> flowable = Flowable.just("FLB");

        Completable completable = Completable.fromObservable(observable);
        Disposable disposable = completable.subscribe();

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("DONE!");
            }
        };

        Subscriber<String> s = new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                subscription.request(4000);
            }

            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        };

        flowable.subscribe(s);
        observable.subscribe();

        Maybe<String> maybe = Maybe.just("e");

        Single<String> single = Single.just("e");


    }
}
