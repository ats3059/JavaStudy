package test.pattern.templatemethod;

import test.pattern.templatemethod.execute.TemplateMethod;
//해당 템플릿을 상속받아서 핵심 로직(변하는 부분)을 구현한 클래스
public class PatternApply extends TemplateAbstract{
    @Override
    public void execute() {
        TemplateMethod.sleep(1000);
        System.out.println("실행");
    }
}
