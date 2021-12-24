package ch8;
/*
예외처리

	원래 컴파일은 javac 를 사용해야하지만
	이클립스가 해줌..

컴파일러가 해주는 것
	1.구문체크
	2.번역
	3.최적화

프로그램 오류
	컴파일 에러 : 컴파일 할 때 발생하는 에러
	런타임 에러 : 실행 할 때 발생하는 에러
	논리적 에러 : 작성 의도와 다르게 동작


Java의 런타임 에러
	에러 - 프로그램 코드에 의해서 수습될 수 없는 심각한 오류
	예외 - 프로그램 코드에 의해서 수습될 수 있는 다소 미약한오류


예외처리의 정의와 목적

	예외처리(exception handling)의
		정의 프로그램 실행 시 발생할 수 있는 예외의 발생에 대비한 코드를 작성하는 것
		목적 프로그램의 비정상 종료를 막고 정상적인 실행상태를 유지하는 것

Exception 클래스는 두 부류로 나눠진다

	Exception과 그 자손들
	Exception 자손 -> RuntimeExcepiton과 그 자손들

	Exception클래스들 사용자의 실수와 같은 외적인 요인에 의해 발생하는 예외
	RuntimeException클래스들 프로그래머의 실수로 발생하는 예외




	#1 try 블럭 내에서 예외가 발생한 경우,
		1. 발생한 예외와 일치하는 catch블럭이 있는지 확인한다.
		2. 일치하는 catch 블럭을 찾게 되면 , 그 catch블럭 내의 문장들을 수행하고 전체 try-catch 문을 빠져나가서 그 다음 문장을 계속해서 수행한다.
		만일 일치하는 catch 블럭을 찾지 못하면 예외는 처리되지 못한다.

	#2 try 블럭 내에서 예외가 발생하지 않은 경우,
		1. catch 블럭을 거치지 않고 전체 try-catch문을 빠져나가서 수행을 계속한다.


	printStackTrace() 예외발생 당시의 호출스택(Call Stack)에 있었던 메서드의 정보와 예외 메시지를 화면에 출력한다.
	getMessage() 발생한 예외클래스의 인스턴스에 저장된 메시지를 얻을 수 있다.


	멀티캐치블럭 주의사항
	캐치 블럭에 있는 예외가 부모자식 관계라면 에러;

	checked 예외 , unchecked 예외가

	checked 예외 : 컴파일러가 예외 처리 여부를 체크 (예외 처리 필수)
	unchecked 예외 : 컴파일러가 예외 처리 여부를 체크 안함 (예외 처리 선택)


 */
public class ExceptionProcess {
    public static void main(String[] args) {
        try{
            //Checked
            //컴파일러가 예외를 필수적으로 처리하라고 하는 것
            throw new Exception("1234");
            //Unchecked
            // 컴파일러가 예외 처리 여부를 체크 안함

        }catch(Exception e){
            //현재 예외에서 발생한 메시지
            e.getMessage();
            //예외가 발생한 호출스택을 불러온다
            e.getStackTrace();
        }

        //CheckedException 을 UnCheckedException 으로 변경
        throw new RuntimeException(new Exception("1234"));
    }

    //예외를 되던지기
    //해당 메서드에서 한 번 예외를 처리한 뒤
    //메서드를 호출한 곳에서 한 번 더 예외를 처리해준다.
    void method() throws Exception{
        try{
            throw new Exception("예외발생");
        }catch (Exception e){
            throw e;
        }

    }


}
