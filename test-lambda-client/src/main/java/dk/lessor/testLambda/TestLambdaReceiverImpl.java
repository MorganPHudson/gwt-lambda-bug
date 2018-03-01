package dk.lessor.testLambda;

import com.google.gwt.user.client.ui.TextBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestLambdaReceiverImpl implements TestLambdaReceiver {
    TestLambdaReceiver parents;

    List<TestLambdaReceiver> children = new ArrayList<>();
    TextBox textBox = new TextBox();

    public TestLambdaReceiverImpl() {
    }

    public void setText(String string) {
        textBox.setText(string);
    }

    @Override
    public TextBox getTextBox() {
        return textBox;
    }

    @Override
    public void addParent(TestLambdaReceiver parent) {
        this.parents = parent;
    }

    @Override
    public Optional getParent() {
        return Optional.ofNullable(parents);
    }

    @Override
    public <T extends TestLambdaReceiver> List<T> getChildren() {
        return (List<T>) children;
    }
}
