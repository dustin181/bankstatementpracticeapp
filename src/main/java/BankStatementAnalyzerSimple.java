import com.google.inject.Guice;
import com.google.inject.Injector;
import modules.BindingAnnotationModule;

public class BankStatementAnalyzerSimple {

    public static void main(final String[] args) throws Exception {

        Injector i = Guice.createInjector(new BindingAnnotationModule());
        Analyzer analyzer = i.getInstance(Analyzer.class);

        analyzer.compute();
    }
}