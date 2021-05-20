package hello.core.member;

import java.util.HashMap;
import java.util.Map;

//인터페이스와 구현체를 같은 패키지에 관리 안하는게 설계상좋다.
public class MemoryMemberRepositoty implements MemberRepository{
    //여러곳에서 접근할수있으니 해시맵보단 커퍼런스맵을 써야한다.
    private static Map<Long,Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
