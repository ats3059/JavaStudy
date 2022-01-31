package ch14;

@FunctionalInterface
public interface TripleRamda<A,S,F,R> {
    R method(A a,S s, F f);
}
