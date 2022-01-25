package modules;

import com.google.inject.AbstractModule;
import services.*;

public class BindingAnnotationModule extends AbstractModule {
    protected void configure() {
        bind(BankStatementInputService.class).to(BankStatementInputImpl.class);
        bind(BankStatementProcessorService.class).to(BankStatementProcessorImpl.class);
        bind(BankStatementParserService.class).to(BankStatementParserImpl.class);
    }
}