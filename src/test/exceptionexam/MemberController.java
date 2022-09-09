package test.exceptionexam;

public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    public String findByMemberName(String someName){
        String resultName;

        resultName = memberService.find(someName);

        return resultName;
    }


}
