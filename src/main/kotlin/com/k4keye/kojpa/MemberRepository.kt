package com.k4keye.kojpa

import com.k4keye.kojpa.domain.Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Repository
interface MemberRepository :JpaRepository<Member,Long>{


}