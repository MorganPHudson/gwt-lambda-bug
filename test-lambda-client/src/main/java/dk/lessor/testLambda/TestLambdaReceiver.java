package dk.lessor.testLambda;

import com.google.gwt.user.client.ui.TextBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public interface TestLambdaReceiver {

    void addParent(TestLambdaReceiver parent);

    <T extends TestLambdaReceiver> Optional<T> getParent();

    <T extends TestLambdaReceiver> List<T> getChildren();

    default <T extends TestLambdaReceiver> List<T> siblings(String selector) {
        return siblings((Selector) receiver -> selector.equals(this.getTextBox().getName()));
    }

    default <T extends TestLambdaReceiver> List<T> siblings(Predicate matcher) {
        return getParent().map(parent -> parent.<T>getChildren().stream().filter(receiver -> receiver != this && matcher.test(receiver)).collect(Collectors.toList())).get();
    }

    default <T extends TestLambdaReceiver> List<T> find(Predicate matcher, boolean includeSelf) {
        List<T> result = new ArrayList<>();
        if (includeSelf && matcher.test(this)) {
            result.add((T) this);
        }
        for (int i = 0; i < getChildren().size(); i++) {
            result.addAll(getChildren().get(i).find(matcher, true));
        }
        return result;
    }

    void setText(String string);

    TextBox getTextBox();
}
