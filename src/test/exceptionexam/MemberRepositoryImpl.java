package test.exceptionexam;

public class MemberRepositoryImpl implements MemberRepository{

    @Override
    public String find(String someName){
        try{
            throw new Exception("해당 이름은 찾을 수 없습니다.");
        }catch (Exception e){
            throw new RuntimeException(e);
        }

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
