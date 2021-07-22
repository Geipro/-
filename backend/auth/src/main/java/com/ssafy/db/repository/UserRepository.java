package com.ssafy.db.repository;

import com.ssafy.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * ���� �� ���� ��� ���� ������ ���� JPA Query Method �������̽� ����.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // �Ʒ��� ����, Query Method �������̽�(��ȯ��, �޼ҵ��, ����) ���Ǹ� �ϸ� �ڵ����� Query Method ������.
    Optional<User> findByUserId(String userId);

    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}
