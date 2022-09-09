package test.exceptionexam;



public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public String find(String someName){
        String resultStr;
        try {
            resultStr = memberRepository.find(someName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return resultStr;
    }

    @Override
    public Long save(String someWord) throws Exception {
        return null;
    }

    @Override
    public String delete(String someWord) throws Exception {
        return null;
    }
}
