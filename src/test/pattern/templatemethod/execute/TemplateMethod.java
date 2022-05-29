package test.pattern.templatemethod.execute;

import test.pattern.templatemethod.Origin;
import test.pattern.templatemethod.PatternApply;
import test.pattern.templatemethod.TemplateAbstract;

public class TemplateMethod {
    public static void main(String[] args) {
        //---- 적용전 ----
//        Origin origin = new Origin();
//        origin.execute();
        //--------------

        //적용 후
        TemplateAbstract templateAbstract = new PatternApply();
        templateAbstract.applyLogic();

    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
