package dk.lessor.testLambda;

import java.util.function.Predicate;

public interface Selector extends Predicate<TestLambdaReceiver> {
    @Override
    boolean test(TestLambdaReceiver object);
}
