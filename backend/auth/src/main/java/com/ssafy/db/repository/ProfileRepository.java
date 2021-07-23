package com.ssafy.db.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssafy.db.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    // �Ʒ��� ����, Query Method �������̽�(��ȯ��, �޼ҵ��, ����) ���Ǹ� �ϸ� �ڵ����� Query Method ������.
    Optional<Profile> findByNickname(String nickname);

    boolean existsByNickname(String nickname);
}
