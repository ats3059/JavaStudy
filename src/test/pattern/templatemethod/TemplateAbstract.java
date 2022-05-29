package test.pattern.templatemethod;
//정의

/*
    템플릿 메서드 디자인 패턴의 목적은 다음과 같습니다.
    > "작업에서 알고리즘의 골격을 정의하고 일부 단계를 하위 클래스로 연기합니다. 템플릿 메서드를 사용하면
    하위 클래스가 알고리즘의 구조를 변경하지 않고도 알고리즘의 특정 단계를 재정의할 수 있습니다."

    변하는 부분과 변하지 않는 부분을 템플릿이라는 틀에 작성한다.
    변하는 부분은 추상메서드로 작성함으로서 변경되는 사항은 해당 클래스를 상속받는 다른 클래스(Pattern Apply)에서 작성
    변하는 부분과 변하지 않는 부분을 분리했다!
    해당 패턴의 문제점은 TemplateAbstract 클래스에 변동이 있을 경우 상속받는 클래스들 전부에게 수정이 필요하다. ( 추상메서드가 추가된다면 )
    자식 클래스 입장에서는 부모 클래스의 기능을 전혀 사용하지 않는데, 부모 클래스를 알아야한다.
    추가로 템플릿 메서드 패턴은 상속 구조를 사용하기 때문에, 별도의 클래스나 익명 내부 클래스를 만들어야 하는 부분도 복잡하다.
*/

public abstract class TemplateAbstract {

    public abstract void execute();

    //조건
    //실행시간을 메서드마다 넣어야 한다
    public void applyLogic(){
        //부가적인 로직
        long startTime = System.currentTimeMillis();
        //핵심로직
        execute();
        //핵심로직 end
        long endTime = System.currentTimeMillis();
        long executeTime = endTime - startTime;
        System.out.println("실행에 소요되는 시간 : " + executeTime);
    }



}
