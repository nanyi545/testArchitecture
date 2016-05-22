package com.finance.hechuang.datalayer.interactors.noUI;

import com.finance.hechuang.datalayer.executors.ThreadExecutor;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * Created by Administrator on 16-5-21.
 */
public abstract class BcgroundUseCase<T> {

    private final ThreadExecutor threadExecutor;

    private Subscription subscription = Subscriptions.empty();

    protected BcgroundUseCase(ThreadExecutor threadExecutor) {
        this.threadExecutor = threadExecutor;
    }

    protected abstract Observable buildUseCaseObservable(T t);

    /**
     * Executes the current use case.
     *
     * @param UseCaseSubscriber The guy who will be listen to the observable build
     * with {@link #buildUseCaseObservable(T t) }.
     */
    @SuppressWarnings("unchecked")
    public void execute(T t, Subscriber UseCaseSubscriber) {
        this.subscription = this.buildUseCaseObservable(t)
                .subscribeOn(Schedulers.from(threadExecutor))
//                .observeOn(Schedulers.from(threadExecutor))   // default behaviour --> same Schedulers as subscribe on
                .subscribe(UseCaseSubscriber);
    }

    /**
     * Unsubscribes from current {@link Subscription}.
     */
    public void unsubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

}
