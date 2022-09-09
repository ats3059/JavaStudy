package test.exceptionexam;

public interface MemberRepository {

    /**
     *
     * @return 멤버의 이름을 반환한다.
     */
    String find(String someName);

    /**
     *
     * @param someWord 새로운 멤버의 이름
     * @return Long 멤버의 자원이 저장된 번호를 반환한다.
     * @throws Exception
     */
    Long save(String someWord) throws Exception;

    /**
     *
     * @param someWord 삭제할 멤버의 이름
     * @throws Exception
     */
    String delete(String someWord) throws Exception;
}
