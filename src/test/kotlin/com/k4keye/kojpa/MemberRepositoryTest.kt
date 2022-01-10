package com.k4keye.kojpa

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class MemberRepositoryTest{

    @Autowired
    lateinit var memberRepository: MemberRepository

    @Test
    fun testMember(){
        val member = Member(0L,"memberA")

         memberRepository.save(member)
        val findMember = memberRepository.findById(member.id)
        assertEquals(findMember.get().id, member.id)

    }

}
