package codewars;

import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;

import java.lang.RuntimeException;

import stream.Thunk;

public class Stream<T> {

    // head of the stream
    private T _head;

    // lazy tail of the stream
    private Thunk<Stream<T>> _tail;

    public Stream(T head, Thunk<Stream<T>> tail) {
        this._head = head;
        this._tail = tail;
    }

    // Returns the head of the stream.
    public T headS() {
        return _head;
    }

    // Returns the unevaluated tail of the stream.
    public Thunk<Stream<T>> tailS() {
        return _tail;
    }

    // Returns the evaluated tail of the stream.
    public Stream<T> next() {

    }

    // .------------------------------.
    // | Static constructor functions |
    // '------------------------------'

    // Construct a stream by repeating a value.
    public static <U> Stream<U> repeatS(U x) {

    }

    // Construct a stream by repeatedly applying a function.
    public static <U> Stream<U> iterateS(Function<U, U> f, U x) {

    }

    // Construct a stream by repeating a list forever. (Sadly no pure single linked lists :( )
    public static <U> Stream<U> cycleS(List<U> l) {

    }

    // Construct a stream by counting numbers starting from a given one.
    public static Stream<Integer> fromS(int x) {

    }

    // Same as @{fromS} but count with a given step width.
    public static Stream<Integer> fromThenS(int x, int d) {

    }

    // .------------------------------------------.
    // | Stream reduction and modification (pure) |
    // '------------------------------------------'

    // Fold a stream from the left.
    public <R> R foldrS(BiFunction<T, Thunk<R>, R> f) {

    }

    // Filter stream with a predicate. (Returns a lazy result.)
    public Thunk<Stream<T>> filterS(Predicate<T> p) {

    }

    // Take a given amount of elements from the stream.
    public LinkedList<T> takeS(int n) {

    }

    // Drop a given amount of elements from the stream.
    public Stream<T> dropS(int n) {

    }

    // Combine 2 streams with a function.
    public <U, R> Stream<R> zipWithS(BiFunction<T, U, R> f, Stream<U> other) {

    }

    // Map every value of the stream with a function, returning a new stream.
    public <R> Stream<R> fmap(Function<T, R> f) {

    }

    // Helper class, to create cyclic declarations, may be helpful for generating the fibonacci numbers.
    public static class CyclicRef<T> {
        public T value;
    }

    // Return the stream of all fibonacci numbers.
    public static Stream<Integer> fibS() {
        // Hint: Use CyclicRef to refer to the not yet computed sequence!

    }

    // Return the stream of all prime numbers.
    public static Stream<Integer> primeS() {

    }
}
