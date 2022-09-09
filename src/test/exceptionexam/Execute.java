package test.exceptionexam;

public class Execute {
    // 예제로 작성하였습니다
    // 내용참조 : https://ats3059.tistory.com/25
    public static void main(String[] args) {
        MemberRepository memberRepository = new MemberRepositoryImpl();
        MemberService memberService = new MemberServiceImpl(memberRepository);
        MemberController memberController = new MemberController(memberService);

        String test = memberController.findByMemberName("익명");
        System.out.println(test);
    }

}
