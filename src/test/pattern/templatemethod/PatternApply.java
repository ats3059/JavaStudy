package test.pattern.templatemethod;

import test.pattern.templatemethod.execute.TemplateMethod;

public class PatternApply extends TemplateAbstract{
    @Override
    public void execute() {
        TemplateMethod.sleep(1000);
        System.out.println("실행");
    }
}
