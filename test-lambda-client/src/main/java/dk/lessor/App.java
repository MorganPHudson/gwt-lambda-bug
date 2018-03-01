package dk.lessor;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import dk.lessor.testLambda.TestLambdaReceiver;
import dk.lessor.testLambda.TestLambdaReceiverImpl;

public class App implements EntryPoint {
    public void onModuleLoad() {
        TestLambdaReceiver testLambdaReceiver = new TestLambdaReceiverImpl();
        TestLambdaReceiver testLambdaReceiver1 = new TestLambdaReceiverImpl();

        testLambdaReceiver.addParent(testLambdaReceiver1);

        testLambdaReceiver.find(o1 -> o1 instanceof Object, true);
        testLambdaReceiver.find(o1 -> o1 instanceof String, true);
        testLambdaReceiver.find(o1 -> o1 instanceof Object, false);

        RootPanel.get().add(testLambdaReceiver.getTextBox());
    }
}
