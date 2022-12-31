package ch14;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
public interface TripleRamda<A,S,F,R> {
    R method(A a,S s, F f);
}
