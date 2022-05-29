package test.pattern.templatemethod;

import test.pattern.templatemethod.execute.TemplateMethod;

//템플릿 메서드 패턴 적용전
//해당 메서드의 문제점 -> 메서드 작성 시 모든 코드에 실행시간을 구하는 부가적인 코드들이 전부 들어가야함.
public class Origin{
    //조건
    //실행시간을 메서드마다 넣어야 한다
    public void execute(){
        //부가적인 로직
        long startTime = System.currentTimeMillis();
        //핵심로직
        TemplateMethod.sleep(1000);
        System.out.println("실행");
        //핵심로직 end
        long endTime = System.currentTimeMillis();
        long executeTime = endTime - startTime;
        System.out.println("실행에 소요되는 시간 : " + executeTime);

    }
}
