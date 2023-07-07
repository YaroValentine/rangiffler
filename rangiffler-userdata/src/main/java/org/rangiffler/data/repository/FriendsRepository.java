package org.rangiffler.data.repository;

import org.rangiffler.data.FriendsEntity;
import org.rangiffler.data.FriendsId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendsRepository extends JpaRepository<FriendsEntity, FriendsId> {


}
